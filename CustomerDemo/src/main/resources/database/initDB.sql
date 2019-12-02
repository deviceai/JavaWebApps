CREATE TABLE IF NOT EXISTS customer(
    id BIGINT auto_increment primary key,
    first_name VARCHAR(50) not null ,
    last_name VARCHAR(100) not null ,
    address VARCHAR(1000) not null ,
    budget DECIMAL not null
);