USE fxbot_dev;

-- All Servers
INSERT INTO fx_servers (server_id, discord_server_id, owner_id, display_name)
VALUES
    ('*', 0, '1', 'All Servers')
ON DUPLICATE KEY UPDATE
     discord_server_id = VALUES(discord_server_id),
     owner_id = VALUES(owner_id),
     display_name = VALUES(display_name);

-- Insert Default Roles
INSERT INTO fx_roles (role_id, server_id, role_name, manager_id)
VALUES
    ('0-1', '*', 'Owner', '1'),
    ('0-2', '*', 'Administrator', '1'),
    ('1-1', '*', 'Member', '1'),
    ('1-2', '*', 'Guest', '1'),
    ('2-1', '*', 'Forbidden', '1')
ON DUPLICATE KEY UPDATE
    server_id = VALUES(server_id),
    role_name = VALUES(role_name),
    manager_id = VALUES(manager_id);

-- Owner: Full Permissions
INSERT INTO fx_role_permissions (role_id, permission_id)
VALUES
    ('0-1', 'administrator'),
    ('0-1', 'create_fxbot_role');

-- Administrator: Full Permissions
INSERT INTO fx_role_permissions (role_id, permission_id)
VALUES
    ('0-2', 'administrator'),
    ('0-2', 'create_fxbot_role');

-- Regular User
INSERT INTO fx_role_permissions (role_id, permission_id)
VALUES
    ('1-1', 'add_reactions'),
    ('1-1', 'stream'),
    ('1-1', 'view_channel'),
    ('1-1', 'send_messages'),
    ('1-1', 'embed_links'),
    ('1-1', 'attach_files'),
    ('1-1', 'read_message_history'),
    ('1-1', 'use_external_emojis'),
    ('1-1', 'connect'),
    ('1-1', 'speak'),
    ('1-1', 'use_voice_activity'),
    ('1-1', 'change_nickname'),
    ('1-1', 'use_external_stickers'),
    ('1-1', 'use_embedded_activities'),
    ('1-1', 'send_messages_in_threads'),
    ('1-1', 'use_soundboard'),
    ('1-1', 'use_external_sounds'),
    ('1-1', 'create_events'),
    ('1-1', 'send_voice_messages'),
    ('1-1', 'send_polls'),
    ('1-1', 'use_external_apps'),
    ('1-1', 'create_fxbot_role');

-- Guest Permissions
INSERT INTO fx_role_permissions (role_id, permission_id)
VALUES
    ('1-2', 'view_channel'),
    ('1-2', 'send_messages'),
    ('1-2', 'add_reactions');

-- Forbidden Permissions
INSERT INTO fx_role_permissions (role_id, permission_id)
VALUES
    ('2-1', 'forbidden');
