-- 1.Retrieve the customer(s) with the highest account balance.
select customers.first_name, customers.last_name from customers join accounts on
customers.customer_id=accounts.customer_id where accounts.balance =
(select MAX(balance) from accounts);

select* from transactions;

-- 2.Calculate the average account balance for customers who have more than one account. 
select avg(balance) as average_account_balance from accounts where customer_id IN
(select customer_id from accounts group by customer_id having count(account_id)>1);

-- 3.Retrieve accounts with transactions whose amounts exceed the average transaction amount
select customers.customer_id, customers.first_name, customers.last_name, 
accounts.account_id, transactions.amount
from customers join accounts on
customers.customer_id=accounts.customer_id join transactions on accounts.account_id=transactions.account_id
where transactions.amount >
(select avg(amount) from transactions);

-- 4.Identify customers who have no recorded transactions. 
select customers.first_name, customers.last_name from customers where customers.customer_id
not in(select distinct accounts.customer_id from accounts join transactions on
accounts.account_id=transactions.account_id);

-- 5.Calculate the total balance of accounts with no recorded transactions.
select sum(balance) as total_balance from accounts where account_id not in
(select distinct account_id from transactions);

-- 6.Retrieve transactions for accounts with the lowest balance.
select t.transaction_id, t.account_id from transactions t join accounts a on
a.balance=(select min(balance) from accounts);

-- 7.Identify customers who have accounts of multiple types. 
select first_name, last_name from customers where customer_id in(select customer_id
from accounts group by customer_id having count(distinct account_type)>1);

-- 8.Calculate the percentage of each account type out of the total number of accounts.
select account_type, count(*)*100.0/(select count(*) from accounts) as percentage
from accounts group by account_type;

-- 9.Retrieve all transactions for a customer with a given customer_id.
select * from transactions where account_id in 
(select account_id from accounts where customer_id = 1);

-- 10.Calculate the total balance for each account type, including a subquery within the SELECT clause. 
SELECT account_type,(SELECT SUM(balance) FROM accounts AS sub 
WHERE sub.account_type = accounts.account_type) AS total_balance FROM accounts
GROUP BY account_type;
