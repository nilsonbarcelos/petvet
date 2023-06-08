create table pet_vet(
    id bigint not null auto_increment,
    dog_name varchar(50) not null,
    dog_age bigint(10) not null,
    dog_breed varchar(50) not null,
    tutor_name varchar(100) not null,
    tutor_phone varchar(20) not null,
    tutor_email varchar(100),
    active tinyint ,
    address varchar(100) not null,
    neighborhood varchar(50) not null,
    zip_code varchar(10) not null,
    address_number bigint(10) not null,
    complement varchar(100),
    city varchar(100) not null,
    state varchar(50) not null,
    country varchar(100) not null,

    primary key (id)
);