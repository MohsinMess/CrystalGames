create table category
(
	id identity,
	name varchar(50),
	description varchar(255),
	image_url varchar(50),
	is_active boolean,
	
	constraint pk_category_id primary key(id)

);

insert into category(name,description,image_url,is_active)
values ('Consoles','Consoles are sold here','cat_3.jpg',true);
insert into category(name,description,image_url,is_active)
values ('DVDs','DVDs are sold here','cat_4.jpg',true);
insert into category(name,description,image_url,is_active)
values ('Spare Parts','Spare Parts are sold here','cat_3.jpg',true);


create table user_detail(

id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
enabled BOOLEAN,
password VARCHAR(60),
email VARCHAR(50),
contact_number VARCHAR(15),
CONSTRAINT pk_user_id PRIMARY KEY(id),
);

INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Ahmed','Raza','ADMIN',true,'12345','ah@gk.com','8888888888');
INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Ali','ther','SUPPLIER',true,'56789','kg@gk.com','7888888888');
INSERT INTO user_detail
(first_name,last_name,role,enabled,password,email,contact_number)
VALUES ('Raj','singh','SUPPLIER',true,'15151','rs@gk.com','6888888888');


create table product(

id IDENTITY,
code VARCHAR(50),
name VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(250),
unit_price DECIMAL(10,2),
quantity INT,
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT DEFAULT 0,
views INT DEFAULT 0,
CONSTRAINT pk_product_id PRIMARY KEY (id),
CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
);


INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('NBVBVBREH','GTA5','XYZ','This is GTA5',4000,5,true,1,1);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('VTVHGHVGH','ASSASIN CREED','ABC','This is ASSASIN CREED',4000,5,true,1,2);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('POKPOKPOI','FIFA','TUO','This is FIFA',4000,5,true,1,3);


CREATE TABLE cart_line(
id IDENTITY,
cart_id int,
total DECIMAL(10,2),
product_id int,
product_count int,
buying_price DECIMAL(10,2),
is_available boolean,
CONSTRAINT fk_cartline_cart_id FOREIGN KEY(cart_id) REFERENCES cart(id),
CONSTRAINT fk_cartline_product_id FOREIGN KEY(product_id) REFERENCES product(id),
CONSTRAINT fk_cartline_id PRIMARY KEY(id)
);

