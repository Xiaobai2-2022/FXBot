USE fxbot_dev;

INSERT INTO fx_users (user_id, discord_id, display_name)
VALUES
    ('1', 495402967478960130, 'Admin')
ON DUPLICATE KEY UPDATE
    display_name = VALUES(display_name);

INSERT INTO fx_bot_admins (user_id, identity)
VALUES
    ('1', 'Owner of FXBot - Xiaobai2')
ON DUPLICATE KEY UPDATE
    identity = VALUES(identity);