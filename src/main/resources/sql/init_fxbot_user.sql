-- Create a dedicated user
CREATE USER IF NOT EXISTS 'fxbot_dev_user'@'localhost' IDENTIFIED BY 'F*angXiaDe*v';

-- Grant full access on fxbot_dev
GRANT ALL PRIVILEGES ON fxbot_dev.* TO 'fxbot_dev_user'@'localhost';

-- Apply privilege changes
FLUSH PRIVILEGES;
