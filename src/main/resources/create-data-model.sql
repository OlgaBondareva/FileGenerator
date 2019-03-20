CREATE DATABASE task1 CHARACTER SET utf8;

USE task1;

CREATE TABLE all_files (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    date DATE NOT NULL,
    latin_string VARCHAR(10) NOT NULL,
    russian_string VARCHAR(10) NOT NULL,
    integer_number INT UNSIGNED NOT NULL,
    real_number DECIMAL(10, 8) UNSIGNED NOT NULL,
    PRIMARY KEY (id)
);