create database product_db;
create user 'product_app'@'%' identified by 'P@ssw0rd12345';
grant ALL PRIVILEGES on `product_db`.* to 'product_app'@'%';
