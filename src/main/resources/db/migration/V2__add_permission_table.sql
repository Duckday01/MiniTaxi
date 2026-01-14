
CREATE TABLE permissions (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE role_permissions (
  role_id BIGINT NOT NULL,
  permission_id BIGINT NOT NULL,
  PRIMARY KEY (role_id, permission_id),
  FOREIGN KEY (role_id) REFERENCES roles(id),
  FOREIGN KEY (permission_id) REFERENCES permissions(id)
);


-- Insert Sample Permissions
INSERT INTO permissions(name) VALUES 
('user:read'), ('user:update'), ('user:create'), ('user:delete');

-- Assign permissions to ADMIN role (Assuming ADMIN has id 1)
-- ADMIN has all permissions
INSERT INTO role_permissions(role_id, permission_id)
SELECT (SELECT id FROM roles WHERE name = 'ADMIN'), id FROM permissions;

-- CUSTOMER might only have read permission (Example)
INSERT INTO role_permissions(role_id, permission_id)
VALUES ((SELECT id FROM roles WHERE name = 'CUSTOMER'), (SELECT id FROM permissions WHERE name = 'user:read'));
