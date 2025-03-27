SELECT first_name, last_name, account_type, email
FROM Customers
JOIN Accounts ON Customers.customer_id = Accounts.customer_id;

SELECT Customers.first_name, Customers.last_name, Transactions.transaction_type, Transactions.amount, Transactions.transaction_date
FROM Transactions
JOIN Accounts ON Transactions.account_id = Accounts.account_id
JOIN Customers ON Accounts.customer_id = Customers.customer_id;

UPDATE Accounts SET balance = balance + 500 WHERE account_id = 101;

SELECT CONCAT(first_name, ' ', last_name) AS full_name FROM Customers;

SET SQL_SAFE_UPDATES = 0;


DELETE FROM Accounts WHERE balance = 0 AND account_type = 'Savings';

SELECT * FROM Customers WHERE address LIKE '%303 Cedar Lane%';

SELECT balance FROM Accounts WHERE account_id = 107;

SELECT * FROM Accounts WHERE account_type = 'Current' AND balance > 1000;

SELECT * FROM Transactions WHERE account_id = 104;

SELECT account_id, balance, (balance * 0.03) AS interest
FROM Accounts
WHERE account_type = 'Savings';

SELECT * FROM Accounts WHERE balance < -500;

SELECT *
FROM Customers
WHERE address NOT LIKE '%303 Cedar Lane%';

