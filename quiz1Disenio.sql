CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS motorcycles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE SET NULL
);

SHOW TABLES;
DESC users;
DESC motorcycles;
DESC users;

DROP TABLE IF EXISTS motorcycles;
CREATE TABLE motorcycles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    cilindraje INT NOT NULL,  
    precio DECIMAL(10,2) NOT NULL,
    color VARCHAR(30) NOT NULL
);
DESC motorcycles;

