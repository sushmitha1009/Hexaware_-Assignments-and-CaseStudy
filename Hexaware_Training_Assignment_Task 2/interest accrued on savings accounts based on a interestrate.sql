SELECT account_id, balance, (balance * 0.03) AS interest
FROM Accounts
WHERE account_type = 'Savings';
