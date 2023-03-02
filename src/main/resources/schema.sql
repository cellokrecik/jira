CREATE TABLE IF NOT EXISTS TSHIRTSIZE (
    ID integer not null AUTO_INCREMENT,
    SIZE_NAME ENUM('XS', 'S', 'M', 'L', 'XL') NOT NULL,
    SIZE_VALUE double precision not null,
    primary key (ID)
);