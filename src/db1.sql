use demo;
drop table if exists product;
drop table if exists category;
create table category
(
   id                  int not null auto_increment,
   name                varchar(20),
   primary key (id) 
);
create table product
(
   id                  int not null auto_increment,
   name                varchar(20),
   price               decimal(8,2),
   remark              longtext,
   date                timestamp default CURRENT_TIMESTAMP,
   cid                 int,
   primary key (id)
);
insert into category (name) values ('服装');
insert into category (name) values ('手机');
insert into category (name) values ('其它');

insert into product (name,price,remark,cid) values ('圣得西服',3000.00,'这里是简单介绍',1);
insert into product (name,price,remark,cid) values ('衫衫西服',3000.00,'这里是简单介绍',1);
insert into product (name,price,remark,cid) values ('Iphone6',6000.00,'这里是简单介绍',2);
select * from product;
select * from product where name like'%手机%';