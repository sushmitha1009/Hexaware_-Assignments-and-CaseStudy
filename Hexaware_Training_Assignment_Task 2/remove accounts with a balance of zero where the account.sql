SET SQL_SAFE_UPDATES = 0;


DELETE FROM Accounts WHERE balance = 0 AND account_type = 'Savings';
