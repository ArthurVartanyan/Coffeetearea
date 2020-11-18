create table pg_address
(
    id        bigserial not null
constraint pg_address_pkey
primary key,
    apartment smallint,
    city      varchar(255),
    district  varchar(255),
    house     smallint,
    index     integer,
    region    varchar(255),
    street    varchar(255)
);

alter table pg_address
owner to postgres;

