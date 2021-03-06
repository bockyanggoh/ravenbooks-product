use product_db;
create table tbl_products(
     product_id varchar(36) not null primary key ,
     product_name varchar(200) not null unique ,
     product_description text ,
     img_url varchar(255) not null unique ,
     isbn varchar(10) not null unique,
     created_ts timestamp default CURRENT_TIMESTAMP,
     updated_ts timestamp ON UPDATE CURRENT_TIMESTAMP,
     stocks int not null default 0
);

create index idx_pid on tbl_products(product_id);
create index idx_isbn on tbl_products(isbn);
create index idx_pname on tbl_products(product_name);