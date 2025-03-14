-- Insert into users table
INSERT INTO users (email, username, password, name) 
VALUES
('ramesh@gmail.com', 'ramesh', '$2a$10$5PiyN0MsG0y886d8xWXtwuLXK0Y7zZwcN5xm82b4oDSVr7yF0O6em', 'ramesh'),
('admin@gmail.com', 'admin', '$2a$10$gqHrslMttQWSsDSVRTK1OehkkBiXsJ/a4z2OURU./dizwOQu5Lovu', 'admin');

-- Insert into roles table
INSERT INTO roles (name) 
VALUES 
('ROLE_ADMIN'),
('ROLE_USER');

-- Insert into users_roles table
-- Assume user_ids: 1 for 'admin' and 2 for 'ramesh'
-- Assume role_ids: 1 for 'ROLE_ADMIN' and 2 for 'ROLE_USER'
INSERT INTO users_roles (user_id, role_id) 
VALUES 
(2, 1),  -- 'ramesh' has 'ROLE_ADMIN'
(1, 2);  -- 'admin' has 'ROLE_USER'
