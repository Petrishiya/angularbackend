CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       mobile_no VARCHAR(15) NOT NULL
);

CREATE TABLE tasks (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description TEXT NOT NULL,
                       assignee VARCHAR(255) NOT NULL,
                       creator VARCHAR(255) NOT NULL,
                       status VARCHAR(50) NOT NULL
);
