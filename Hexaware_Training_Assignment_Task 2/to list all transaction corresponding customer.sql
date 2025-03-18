SELECT Customers.first_name, Customers.last_name, Transactions.transaction_type, Transactions.amount, Transactions.transaction_date
FROM Transactions
JOIN Accounts ON Transactions.account_id = Accounts.account_id
JOIN Customers ON Accounts.customer_id = Customers.customer_id;
