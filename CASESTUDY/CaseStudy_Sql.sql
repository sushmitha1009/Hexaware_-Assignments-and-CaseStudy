create database Car_Rental_System;
use Car_Rental_System;

create table vehicle(vehicle_id int primary key,
make varchar(50) not null,
model varchar(50) not null,
year YEAR not null,
dailyRate decimal(10,2),
status enum('Available', 'notAvailable') not null,
passengerCapacity int,
engineCapacity decimal(5,2));

ALTER TABLE vehicle MODIFY vehicle_id INT AUTO_INCREMENT;

create table customer(customer_id int auto_increment primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(100) unique not null,
phone_number varchar(15) unique not null);

create table lease(lease_id int auto_increment primary key,
vehicle_id int not null,
customer_id int not null,
startDate int not null,
endDate int not null,
type enum('Dailylease', 'Monthlylease') not null,
foreign key (vehicle_id) references vehicle(vehicle_id) on delete cascade,
foreign key (customer_id) references customer(customer_id) on delete cascade);

create table payment(payment_id int auto_increment primary key,
lease_id int not null,
payment_date date not null,
amount decimal(10,2) not null,
foreign key(lease_id) references lease(lease_id) on delete cascade);

INSERT INTO vehicle (make, model, year, dailyRate, status, passengerCapacity, engineCapacity) VALUES
('Toyota', 'Corolla', 2020, 50.00, 'Available', 5, 1.8),
('Honda', 'Civic', 2019, 55.00, 'Available', 5, 2.0),
('Ford', 'Focus', 2021, 60.00, 'notAvailable', 5, 2.0),
('Hyundai', 'Elantra', 2018, 45.00, 'Available', 5, 1.6),
('Chevrolet', 'Cruze', 2017, 40.00, 'notAvailable', 5, 1.4),
('Toyota', 'Camry', 2021, 70.00, 'Available', 5, 2.5),
('Honda', 'Accord', 2020, 75.00, 'notAvailable', 5, 2.4),
('Nissan', 'Sentra', 2019, 50.00, 'Available', 5, 2.0),
('Mazda', '3', 2019, 55.00, 'Available', 5, 2.0),
('Kia', 'Optima', 2018, 60.00, 'notAvailable', 5, 2.4);

INSERT INTO customer (first_name, last_name, email, phone_number) VALUES
('Mahendra Singh', 'Dhoni', 'ms.dhoni@gmail.com', '9876543210'), 
('Virat', 'Kohli', 'virat.kohli@gmail.com', '9876543211'),
('Suriya', 'Sivakumar', 'suriya.sivakumar@gmail.com', '9876543212'),
('Sam', 'Ruth', 'sam.ruth@gmail.com', '9876543213'),
('Hardik', 'Pandya', 'hardik.pandya@gmail.com', '9876543214'),
('Anjali', 'Devi', 'anjali.devi@gmail.com', '9876543215'),
('Rahul', 'Chowdhury', 'rahul.chowdhury@gmail.com', '9876543216'),
('Pooja', 'Shri', 'pooja.shri@gmail.com', '9876543217'),
('Kavitha', 'Saravanan', 'kavitha.saravanan@gmail.com', '9876543218'),
('Meera', 'Deepak', 'meera.deepak@gmail.com', '9876543219');

INSERT INTO lease (vehicle_id, customer_id, startDate, endDate, type) VALUES
(1, 1, 20250315, 20250320, 'Dailylease'),
(2, 2, 20250310, 20250320, 'Monthlylease'),
(3, 3, 20250305, 20250315, 'Dailylease'),
(4, 4, 20250308, 20250312, 'Dailylease'),
(5, 5, 20250301, 20250330, 'Monthlylease'),
(6, 6, 20250310, 20250325, 'Dailylease'),
(7, 7, 20250307, 20250317, 'Dailylease'),
(8, 8, 20250302, 20250322, 'Monthlylease'),
(9, 9, 20250312, 20250315, 'Dailylease'),
(10, 10, 20250311, 20250320, 'Monthlylease');


SELECT lease_id FROM lease;

INSERT INTO payment (lease_id, payment_date, amount) VALUES
(11, '2025-03-16', 250.00),
(12, '2025-03-11', 550.00),
(13, '2025-03-06', 300.00),
(14, '2025-03-09', 180.00),
(15, '2025-03-02', 600.00),
(16, '2025-03-11', 375.00),
(17, '2025-03-08', 250.00),
(18, '2025-03-03', 500.00),
(19, '2025-03-13', 150.00),
(20, '2025-03-12', 500.00);

SELECT * FROM vehicle;
SELECT * FROM customer;
SELECT * FROM lease;
SELECT * FROM payment;




