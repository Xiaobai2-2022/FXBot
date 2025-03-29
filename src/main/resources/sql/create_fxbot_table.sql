USE fxbot_dev;

CREATE TABLE fx_users (
    user_id CHAR(36) PRIMARY KEY,
    discord_id BIGINT UNIQUE NOT NULL,
    display_name VARCHAR(255) NOT NULL,

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE fx_user_channels (

    channel_id CHAR(36) PRIMARY KEY,
    user_id CHAR(36) UNIQUE NOT NULL,
    display_name VARCHAR(255) NOT NULL,
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES fx_users(user_id) ON DELETE CASCADE
);

CREATE TABLE fx_servers (
    server_id CHAR(36) PRIMARY KEY,
    owner_id CHAR(36) NOT NULL,
    display_name VARCHAR(255) NOT NULL,

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (owner_id) REFERENCES fx_users(user_id) ON DELETE CASCADE
);

CREATE TABLE fx_discord_permissions (
    permission_id VARCHAR(255) PRIMARY KEY,
    permission_bit BIGINT UNIQUE NOT NULL,
    permission_description VARCHAR(255) NOT NULL,

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE fx_server_roles (
    role_id CHAR(36) PRIMARY KEY,
    server_id CHAR(36) NOT NULL,
    role_name VARCHAR(255) NOT NULL,

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    UNIQUE (server_id, role_name),
    FOREIGN KEY (server_id) REFERENCES fx_servers(server_id) ON DELETE CASCADE
);

CREATE TABLE fx_role_permissions (
    role_id CHAR(36) NOT NULL,
    permission_id VARCHAR(255) NOT NULL,

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES fx_server_roles(role_id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES fx_discord_permissions(permission_id) ON DELETE CASCADE
);

CREATE TABLE fx_user_roles (
    user_id CHAR(36) NOT NULL,
    server_id CHAR(36) NOT NULL,
    role_id CHAR(36) NOT NULL,

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (user_id, server_id, role_id),
    FOREIGN KEY (user_id) REFERENCES fx_users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (server_id) REFERENCES fx_servers(server_id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES fx_server_roles(role_id) ON DELETE CASCADE
);

CREATE TABLE fx_bot_admins (
    user_id CHAR(36) PRIMARY KEY,
    identity VARCHAR(255),

    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES fx_users(user_id) ON DELETE CASCADE
);
