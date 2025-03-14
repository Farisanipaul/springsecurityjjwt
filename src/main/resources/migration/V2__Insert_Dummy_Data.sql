-- Insert dummy data into roles
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

-- Insert dummy data into users
INSERT INTO users (name, username, email, password) 
VALUES 
('John Doe', 'john.doe', 'john.doe@example.com', 'password123'),
('Jane Smith', 'jane.smith', 'jane.smith@example.com', 'password456');

-- Insert users' roles into users_roles table
INSERT INTO users_roles (user_id, role_id) 
VALUES 
(1, 1),  -- John Doe has role 'ADMIN'
(1, 2),  -- John Doe also has role 'USER'
(2, 2);  -- Jane Smith has role 'USER'