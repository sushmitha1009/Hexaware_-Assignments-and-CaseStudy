-- 1.to Find the average account balance for all customers--
SELECT AVG(balance) AS average_balance FROM Accounts;

-- 2. to Retrieve the top 10 highest account balances. 
select * from accounts order by balance desc limit 10;

select * from transactions;

-- 3. to Calculate Total Deposits for All Customers in specific date.
select sum(amount) from transactions where transaction_type="Deposit" and transaction_date=2025-03-05;

select*from customers;

-- 4. to Find the Oldest and Newest Customers.
-- new customer
select concat(first_name,' ',last_name) as new_customer from customers order by customer_id desc limit 1;

-- old customer
select concat(first_name,' ',last_name) as new_customer from customers order by customer_id asc limit 1;

select*from accounts;

-- 5.to Retrieve transaction details along with the account type.
select transactions.transaction_id, transactions.transaction_type, transactions.transaction_date, transactions.amount, accounts.account_type from transactions join accounts on transactions.account_id=accounts.account_id;

-- 6. to Get a list of customers along with their account details.
select concat(first_name,' ',last_name) as customer_name , accounts.account_id, accounts.account_type, accounts.balance 
from accounts join customers on accounts.customer_id=customers.customer_id;

-- 7.  to Retrieve transaction details along with customer information for a specific account.
select transactions.*, customers.first_name,customers.last_name
from transactions join accounts on transactions.account_id=accounts.account_id 
join customers on accounts.customer_id=customers.customer_id where accounts.account_id=105;

-- 8.to Identify customers who have more than one account.
select customers.first_name, customers.last_name, count(accounts.account_id) as account_count 
from customers join accounts on customers.customer_id=accounts.customer_id
group by customers.customer_id
having count(accounts.account_id)>1;

-- 9. to Calculate the difference in transaction amounts between deposits and withdrawals.
-- using subquery
select
(select sum(transactions.amount) as deposit_amount from transactions where transactions.transaction_type='Deposit')-
(select sum(transactions.amount) as withdrawals_amount from transactions where transactions.transaction_type='Withdrawal') AS transaction_difference;
-- using case
SELECT 
    SUM(CASE WHEN transactions.transaction_type = 'Deposit' THEN transactions.amount ELSE 0 END) -
    SUM(CASE WHEN transactions.transaction_type = 'Withdrawal' THEN transactions.amount ELSE 0 END) AS difference
FROM transactions;

-- 10. to Calculate the average daily balance for each account over a specified period.
SELECT Accounts.account_id, AVG(Transactions.amount) AS average_daily_balance
FROM Accounts JOIN Transactions ON Accounts.account_id = Transactions.account_id
WHERE Transactions.transaction_date BETWEEN '2025-03-01' AND '2025-03-10'
GROUP BY Accounts.account_id;

-- 11.  the total balance for each account type.
select sum(balance) as total_balance, account_type from accounts group by account_type;

-- 12.  Identify accounts with the highest number of transactions order by descending order. 
select account_id, count(transaction_id) as highest_transactions from transactions group by account_id
order by count(transaction_id) desc;

-- 13.  List customers with high aggregate account balances, along with their account types. 
select customers.first_name, customers.last_name, sum(balance) as high_aggregate_account_balances,
account_type from customers join accounts on customers.customer_id=accounts.customer_id 
group by customers.customer_id,accounts.account_type having sum(balance) > 8000;

-- 14. Identify and list duplicate transactions based on transaction amount, date, and account.
select account_id, transaction_type, amount, transaction_date, count(*) as duplicate_transactions
from transactions group by account_id, transaction_type, amount, transaction_date 
having count(*) >1;