-- liquibase formatted sql

--changeset Rushikesh Malvadkar:1-create-role-table
CREATE TABLE roles (
    id VARCHAR(45) PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL
);

--changeset Rushikesh Malvadkar:2-insert-predefined-role
INSERT INTO roles (id, name, description) VALUES
('01K1MSYXAEHSZHTB3YNTE00MYF', 'System', 'Responsible to send email notifications and perform other automated tasks'),
('01K1MSXBRDM82DFK59CKCTVXYQ', 'Admin', 'Responsible to manage everything along with users and organizations'),
('01K1MSYEYFFG9M4JH173NP6RKZ', 'Manager', 'Responsible to manage projects, contexts and terms along with user assignment to project'),
('01K1MSYQSFNS2R0G28WC79WSZ1', 'Member', 'Responsible to view terms and contexts related to assigned projects');

--changeset Rushikesh Malvadkar:3-create-user-table
CREATE TABLE users (
    id VARCHAR(45) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    last_login_time DATETIME,
    active BIT(1) NOT NULL DEFAULT 1,
    role_id VARCHAR(45) NOT NULL,
    created_by VARCHAR(45),
    created_on DATETIME,
    updated_by VARCHAR(45),
    updated_on DATETIME,
    delete_flag BIT(1) DEFAULT 0,

    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (created_by) REFERENCES users(id),
    FOREIGN KEY (updated_by) REFERENCES users(id)
);

--changeset Rushikesh Malvadkar:4-insert-system-user
INSERT INTO users (id, name, email,  role_id,  created_on, updated_on) VALUES
('01K1MTB02FEYQWHGZBSSGTAGM9', 'System', 'system@yourdomain.com', '01K1MSYXAEHSZHTB3YNTE00MYF', utc_timestamp(), utc_timestamp());







