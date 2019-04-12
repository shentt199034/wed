use demo;
drop table if exists product;
drop table if exists category;
create table category
(
   cid                  int not null auto_increment,
   cname                varchar(20),
   chot                 bool default false,
   primary key (cid) 
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
insert into category (cname,chot) values ('服装',true);
insert into category (cname,chot) values ('手机',true);
insert into category (cname,chot) values ('其它',false);

insert into product (name,price,remark,cid) values ('圣得西服',3000.00,'这里是简单介绍',1);
insert into product (name,price,remark,cid) values ('衫衫西服',3000.00,'这里是简单介绍',1);
insert into product (name,price,remark,cid) values ('Iphone6',6000.00,'这里是简单介绍',2);
insert into product (name,price,remark) values ('Iphone8',7000.00,'这里是简单介绍');
select * from product;
select * from product where name like'%%'limit 0,4;
select * from product p inner join category c on p.cid=c.id;
select * from product p left join category c on p.cid=c.id;
select * from product p right join category c on p.cid=c.id where p.name like "%西服%";