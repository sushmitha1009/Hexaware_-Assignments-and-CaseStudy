CREATE DATABASE HMBank;
USE HMBank;

CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    DOB DATE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone_number VARCHAR(15) UNIQUE NOT NULL,
    address TEXT
);

CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    account_type ENUM('Savings', 'Current', 'Zero_Balance') NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    address TEXT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id) 
        ON DELETE CASCADE
);

CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type ENUM('Deposit', 'Withdrawal', 'Transfer') NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id) 
        ON DELETE CASCADE
);

SHOW TABLES;
DESCRIBE Customers;
DESCRIBE Accounts;
DESCRIBE Transactions;

INSERT INTO Customers (customer_id, first_name, last_name, DOB, email, phone_number, address) VALUES
(1, 'John', 'Doe', '2003-01-15', 'john.doe@gmail.com', '9876543210', '123 Elm Street'),
(2, 'Jane', 'Smith', '2004-03-22', 'jane.smith@gmail.com', '9876543211', '456 Maple Avenue'),
(3, 'Alice', 'Johnson', '1988-07-10', 'alice.johnson@gmail.com', '9876543212', '789 Oak Boulevard'),
(4, 'Bob', 'Brown', '1985-11-30', 'bob.brown@gmail.com', '9876543213', '101 Pine Drive'),
(5, 'Charlie', 'Davis', '1997-04-18', 'charlie.davis@gmail.com', '9876543214', '202 Birch Road'),
(6, 'Diana', 'Evans', '2003-09-12', 'diana.evans@gmail.com', '9876543215', '303 Cedar Lane'),
(7, 'Frank', 'Green', '2000-06-25', 'frank.green@gmail.com', '9876543216', '404 Walnut Street'),
(8, 'Grace', 'Harris', '2002-10-05', 'grace.harris@gmail.com', '9876543217', '505 Chestnut Avenue'),
(9, 'Henry', 'Miller', '1999-12-08', 'henry.miller@gmail.com', '9876543218', '606 Ash Boulevard'),
(10, 'Ivy', 'Wilson', '2004-02-20', 'ivy.wilson@gmail.com', '9876543219', '707 Spruce Road');

INSERT INTO Accounts (account_id, customer_id, account_type, balance) VALUES
(101, 1, 'Savings', 5000),
(102, 2, 'Current', 2000),
(103, 3, 'Savings', 10000),
(104, 4, 'Savings', 7000),
(105, 5, 'Current', 3000),
(106, 6, 'Savings', 4000),
(107, 7, 'Savings', 8000),
(108, 8, 'Current', 1000),
(109, 9, 'Savings', 6000),
(110, 10, 'Zero_Balance', 0);

INSERT INTO Transactions (transaction_id, account_id, transaction_type, amount, transaction_date) VALUES
(201, 101, 'Deposit', 1000.00, '2025-03-01'),
(202, 102, 'Withdrawal', 500.00, '2025-03-02'),
(203, 103, 'Transfer', 2000.00, '2025-03-03'),
(204, 104, 'Deposit', 3000.00, '2025-03-04'),
(205, 105, 'Withdrawal', 1000.00, '2025-03-05'),
(206, 106, 'Transfer', 1500.00, '2025-03-06'),
(207, 107, 'Deposit', 2000.00, '2025-03-07'),
(208, 108, 'Withdrawal', 700.00, '2025-03-08'),
(209, 109, 'Transfer', 500.00, '2025-03-09'),
(210, 110, 'Deposit', 1200.00, '2025-03-10');

