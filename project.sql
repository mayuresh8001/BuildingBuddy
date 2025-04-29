CREATE DATABASE IF NOT EXISTS mayuresh_project;
USE mayuresh_project;

-- Create User Table
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);
select * from users;
-- Create Project Table
CREATE TABLE IF NOT EXISTS projects (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    project_name VARCHAR(255) NOT NULL,
    location VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
select * from projects;

-- Create Material Table
CREATE TABLE IF NOT EXISTS materials (
    material_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    unit VARCHAR(50)
);
select * from materials;
-- Create Stock Table
CREATE TABLE IF NOT EXISTS stock (
    stock_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT,
    material_id INT,
    quantity DOUBLE DEFAULT 0,
    
    FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE,
    FOREIGN KEY (material_id) REFERENCES materials(material_id) ON DELETE CASCADE
);
drop table stock;
select * from stock;
-- Create UsageLog Table
CREATE TABLE IF NOT EXISTS usage_logs (
    usage_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT,
    material_id INT,
    used_quantity DOUBLE,
    used_date DATE,
    FOREIGN KEY (project_id) REFERENCES projects(project_id) ON DELETE CASCADE,
    FOREIGN KEY (material_id) REFERENCES materials(material_id) ON DELETE CASCADE
);
select * from usage_log;