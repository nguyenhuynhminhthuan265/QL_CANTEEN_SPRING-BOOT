# QL_CANTEEN_SPRING-BOOT
CREATE DATABASE IF NOT EXISTS QUANLY_CANTEEN ;
USE QUANLY_CANTEEN;
CREATE TABLE IF NOT EXISTS roles (
	id int auto_increment NOT NULL,
    name NVARCHAR(30) NOT NULL,
    description VARCHAR(255) NOT NULL,
    

    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS employees (
id int auto_increment NOT NULL,
name NVARCHAR (40),
email VARCHAR (40) not null unique,
password VARCHAR (255) not null,
phone VARCHAR (20),
is_delete BOOLEAN NOT NULL default false,
role_id int NOT NULL,
CONSTRAINT PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS status (
id int auto_increment NOT NULL,
name nvarchar(100),
CONSTRAINT PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS products (
id int auto_increment NOT NULL,
name NVARCHAR (50),
quantity INT,
price FLOAT,
date_product DATE,
is_beverage BOOLEAN NOT NULL default FALSE,
status_id int not null,
is_delete BOOLEAN NOT NULL default false,
CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS bills (
id int auto_increment NOT NULL,
date_bill DATE,
user_id int default 0,
employee_id int not null,
price FLOAT,


CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
id int auto_increment NOT NULL,
name VARCHAR (40),
email VARCHAR (40) not null unique,
password VARCHAR (255) not null,
address NVARCHAR (255),
phone VARCHAR (20),
is_delete BOOLEAN NOT NULL default false,

CONSTRAINT PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS detail_bill (
id int not null auto_increment,
bill_id int NOT NULL,
product_id int,
price float,
quantity int,

CONSTRAINT PRIMARY KEY (id)
);
ALTER TABLE products ADD CONSTRAINT FK_products_status FOREIGN KEY (status_id) REFERENCES status (id)  ON DELETE CASCADE;
ALTER TABLE employees ADD CONSTRAINT FK_employees_roles FOREIGN KEY (role_id) REFERENCES roles (id)  ON DELETE CASCADE;
ALTER TABLE bills ADD CONSTRAINT FK_bills_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE bills ADD CONSTRAINT FK_bills_employees FOREIGN KEY (employee_id) REFERENCES employees (id) ON DELETE CASCADE;
ALTER TABLE detail_bill ADD CONSTRAINT FK_detail_bills FOREIGN KEY (bill_id) REFERENCES bills (id) ON DELETE CASCADE;
ALTER TABLE detail_bill ADD CONSTRAINT FK_detail_product FOREIGN KEY (product_id) REFERENCES products (id) ON DELETE CASCADE;


DROP TRIGGER IF EXISTS before_product_update;
/* 

 DELIMITER $$

 CREATE TRIGGER before_product_update

 BEFORE UPDATE ON products

 FOR EACH ROW

BEGIN

 INSERT INTO products

SET

name = OLD.name,

quantity = OLD.quantity,
price = OLD.price,
status_id = OLD.status_id,
is_delete=OLD.is_delete,
date_product = NOW();

END$$
 DELIMITER ;


 */

 -- QUYỀN
INSERT INTO roles( name, description ) VALUES ("ROLE_ADMIN", "Quản trị hệ thống");
INSERT INTO roles( name, description ) VALUES ("ROLE_MANAGER", "Quản lý");
INSERT INTO roles( name, description ) VALUES ("ROLE_USER", "Khách hàng");
INSERT INTO roles( name, description ) VALUES ("ROLE_EMPLOYEE", "Khách hàng");

-- TRẠNG THÁI SẢN PHẨM
INSERT INTO status( name ) VALUES ("Còn");
INSERT INTO status( name ) VALUES ("Hết");

-- KHACH HANG
insert into users (id,name,email,password,address,phone) values('1','','','','','');

insert into users (name,email,password,address,phone) values('Nguyen Van A','nguyenvana@gmail.com','123456','731 Tran Hung Dao, Q5, TpHCM','8823451');
insert into users (name,email,password,address,phone) values('Tran Ngoc Han','tranngochan@gmail.com','123456','23/5 Nguyen Trai, Q5, TpHCM','908256478');
insert into users (name,email,password,address,phone) values('Tran Ngoc Linh','tranngoclinh@gmail.com','123456','45 Nguyen Canh Chan, Q1, TpHCM','938776266');
insert into users (name,email,password,address,phone) values('Tran Minh Long','tranminhlong@gmail.com','123456','50/34 Le Dai Hanh, Q10, TpHCM','917325476');
insert into users (name,email,password,address,phone) values('Le Nhat Minh','lenhatminh@gmail.com','123456','34 Truong Dinh, Q3, TpHCM','8246108');
insert into users (name,email,password,address,phone) values('Le Hoai Thuong','lehoaithuong@gmail.com','123456','227 Nguyen Van Cu, Q5, TpHCM','8631738');
insert into users (name,email,password,address,phone) values('Nguyen Van Tam','nguyenvantam@gmail.com','123456','32/3 Tran Binh Trong, Q5, TpHCM','916783565');
insert into users (name,email,password,address,phone) values('Phan Thi Thanh','phanthithanh@gmail.com','123456','45/2 An Duong Vuong, Q5, TpHCM','938435756');
insert into users (name,email,password,address,phone) values('Le Ha Vinh','lehavinh@gmail.com','123456','873 Le Hong Phong, Q5, TpHCM','8654763');
insert into users (name,email,password,address,phone) values('Ha Duy Lap','haduylap@gmail.com','123456','34/34B Nguyen Trai, Q1, TpHCM','8768904');


-- NHANVIEN
insert into employees(name,email,password,phone,role_id) values('Nguyen Nhu Nhut','admin@gmail.com','123456','927345678',1);
insert into employees(name,email,password,phone,role_id) values('Le Thi Phi Yen','manager@gmail.com','123456','987567390',2);
insert into employees(name,email,password,phone,role_id) values('Nguyen Van B','manager1@gmail.com','123456','997047382',2);
insert into employees(name,email,password,phone,role_id) values('Ngo Thanh Tuan','employee1@gmail.com','123456','913758498',4);
insert into employees(name,email,password,phone,role_id) values('Nguyen Thi Truc Thanh','employee2@gmail.com','123456','918590387',4);

-- SANPHAM
insert into products(name,quantity,price,date_product,status_id) values('Cơm',1,3000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('phở',1,5000,'2019/05/25',2);
insert into products(name,quantity,price,date_product,status_id) values('bún đậu',1,3500,'2019/05/25',2);
insert into products(name,quantity,price,date_product,status_id) values('hủ tiếu',1,30000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('cơm sườn',1,5000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('canh chua',1,7000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('mì trứng',1,100000,'2019/05/25',2);
insert into products(name,quantity,price,date_product,status_id) values('cơm chiên trứng',1,2500,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('cơm hải sản',1,4500,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('mì cay',1,3000,'2019/05/25',2);
insert into products(name,quantity,price,date_product,status_id) values('bún bò huế',1,5500,'2019/05/25',2);

insert into products(name,quantity,price,date_product,status_id) values('mì cay',1,30000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('Cơm hải sản',1,5000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('Coffee',1,29000,'2019/05/25',1);
insert into products(name,quantity,price,date_product,status_id) values('Bạc xỉu',1,29500,'2019/05/25',1);
-- HOADON
insert into bills(date_bill, user_id, employee_id, price) values('2017-03-27','1','1',320000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-08-12','1','2',840000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-08-23','2','1',100000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-01-09','2','1',180000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-10-20','1','2',3800000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-10-16','1','3',2430000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-10-28','3','3',510000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-10-28','1','3',440000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-10-28','3','4',200000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-11-01','1','1',5200000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-11-04','4','3',250000);
insert into bills(date_bill, user_id, employee_id, price) values('2017-11-30','5','3',21000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-12-12','6','1',5000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-12-13','3','2',3150000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-01','6','1',910000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-01','7','2',12500);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-02','8','3',35000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-13','8','3',330000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-13','1','3',30000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-14','9','4',70000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-16','10','3',67500);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-16','7','3',7000);
insert into bills(date_bill, user_id, employee_id, price) values('2018-01-17','8','1',330000);

insert into bills(date_bill, user_id, employee_id, price) values('2019-12-12','6','1',5000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-12-13','3','2',3150000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-01','6','1',910000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-01','7','2',12500);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-02','8','3',35000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-13','8','3',330000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-13','1','3',30000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-14','9','4',70000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-16','10','3',67500);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-16','7','3',7000);
insert into bills(date_bill, user_id, employee_id, price) values('2019-01-17','8','1',330000);


-- detail_bill(bill_id, product_id,price,quantity)
insert into detail_bill(bill_id, product_id,price,quantity) values(1,'1',1000,5);
insert into detail_bill(bill_id, product_id,price,quantity) values(1,'2',3000,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(1,'8',1000,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(2,'4',1000,20);
insert into detail_bill(bill_id, product_id,price,quantity) values(2,'1',1000,20);
insert into detail_bill(bill_id, product_id,price,quantity) values(2,'2',1000,20);
insert into detail_bill(bill_id, product_id,price,quantity) values(3,'3',2000,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(4,'1',1500,20);
insert into detail_bill(bill_id, product_id,price,quantity) values(4,'2',1000,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(4,'3',1050,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(4,'4',1500,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(5,'5',2050,50);
insert into detail_bill(bill_id, product_id,price,quantity) values(5,'6',2300,50);
insert into detail_bill(bill_id, product_id,price,quantity) values(6,'7',2400,20);
insert into detail_bill(bill_id, product_id,price,quantity) values(6,'1',2471,30);
insert into detail_bill(bill_id, product_id,price,quantity) values(6,'2',3012,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(7,'3',3000,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(8,'4',3140,8);
insert into detail_bill(bill_id, product_id,price,quantity) values(9,'5',3215,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(10,'7',2900,50);
insert into detail_bill(bill_id, product_id,price,quantity) values(10,'8',1600,100);
insert into detail_bill(bill_id, product_id,price,quantity) values(10,'4',1800,50);
insert into detail_bill(bill_id, product_id,price,quantity) values(10,'3',1850,100);
insert into detail_bill(bill_id, product_id,price,quantity) values(11,'6',1472,50);
insert into detail_bill(bill_id, product_id,price,quantity) values(12,'7',1498,3);
insert into detail_bill(bill_id, product_id,price,quantity) values(13,'8',1442,5);
insert into detail_bill(bill_id, product_id,price,quantity) values(14,'2',1220,80);
insert into detail_bill(bill_id, product_id,price,quantity) values(14,'4',1100,60);
insert into detail_bill(bill_id, product_id,price,quantity) values(14,'1',3600,50);
insert into detail_bill(bill_id, product_id,price,quantity) values(15,'2',1250,30);
insert into detail_bill(bill_id, product_id,price,quantity) values(15,'3',1150,7);
insert into detail_bill(bill_id, product_id,price,quantity) values(16,'8',1230,5);
insert into detail_bill(bill_id, product_id,price,quantity) values(17,'5',1235,1);
insert into detail_bill(bill_id, product_id,price,quantity) values(17,'4',1140,1);
insert into detail_bill(bill_id, product_id,price,quantity) values(17,'7',1980,5);
insert into detail_bill(bill_id, product_id,price,quantity) values(18,'8',1900,6);
insert into detail_bill(bill_id, product_id,price,quantity) values(19,'5',1999,1);
insert into detail_bill(bill_id, product_id,price,quantity) values(19,'6',2999,2);
insert into detail_bill(bill_id, product_id,price,quantity) values(20,'6',1547,10);
insert into detail_bill(bill_id, product_id,price,quantity) values(21,'9',1165,5);
insert into detail_bill(bill_id, product_id,price,quantity) values(22,'7',2140,1);
