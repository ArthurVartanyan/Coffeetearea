-- drop tables
drop table if exists public.tea_color cascade;
drop table if exists public.cart_products cascade;
drop table if exists public.coffee cascade;
drop table if exists public.coffee_type cascade;
drop table if exists public.countries cascade;
drop table if exists public.drink cascade;
drop table if exists public.favourites cascade;
drop table if exists public.manufacturer cascade;
drop table if exists public.packaging cascade;
drop table if exists public.pg_order cascade;
drop table if exists public.users cascade;
drop table if exists public.roasting cascade;
drop table if exists public.tea cascade;
drop table if exists public.tea_type cascade;

-- Create table USER
create table users
(
    id         serial      not null
        constraint users_pkey
        primary key,
    name       varchar(50) not null,
    last_name  varchar(50) not null,
    login      varchar(25) not null,
    password   varchar(25) not null,
    role       varchar(10) not null,
    mail       varchar(30) not null,
    is_deleted boolean     not null
);

-- Create table ROASTING
create table roasting
(
    id         serial   not null
        constraint roasting_pkey
            primary key,
    roasting   smallint not null,
    is_deleted boolean  not null
);

-- Create table COUNTRY
create table countries
(
    id         serial      not null
        constraint countries_pkey
            primary key,
    name       varchar(25) not null,
    is_deleted boolean     not null
);

-- Create table MANUFACTURER
create table manufacturer
(
    id         serial      not null
        constraint manufacturer_pkey
            primary key,
    name       varchar(25) not null,
    is_deleted boolean     not null
);

-- Create table PACKAGING
create table packaging
(
    id         serial      not null
        constraint packaging_pkey
            primary key,
    name       varchar(25) not null,
    is_deleted boolean     not null
);

-- Create table DRINK
create table drink
(
    id              serial      not null
        constraint drink_pkey
        primary key,
    name            varchar(30) not null,
    price           numeric     not null,
    about           text        not null,
    packaging_id    bigint     not null
        constraint drink_packaging_id_fkey
        references packaging,
    manufacturer_id bigint     not null
        constraint drink_manufacturer_id_fkey
        references manufacturer,
    country_id      bigint     not null
        constraint drink_country_id_fkey
        references countries,
    is_deleted      boolean     not null
);

-- Create table TEA_TYPE
create table tea_type
(
    id         serial      not null
        constraint tea_type_pkey
        primary key,
    name       varchar(25) not null,
    is_deleted boolean     not null
);

-- Create table COFFEE_TYPE
create table coffee_type
(
    id         serial      not null
        constraint coffee_type_pkey
        primary key,
    name       varchar(25) not null,
    is_deleted boolean     not null
);

-- Create table COFFEE
create table coffee
(
    id          serial  not null
        constraint coffee_pkey
        primary key,
    drink_id    bigint not null
        constraint coffee_drink_id_fkey
        references drink,
    type_id     bigint not null
        constraint coffee_type_id_fkey
        references coffee_type,
    roasting_id bigint not null
        constraint coffee_roasting_id_fkey
        references roasting
);

-- Create table TEA
create table tea
(
    id       serial  not null
        constraint tea_pkey
        primary key,
    drink_id bigint not null
        constraint tea_drink_id_fkey
        references drink,
    type_id  bigint not null
        constraint tea_type_id_fkey
        references tea_type
);

-- Create table ORDER
create table pg_order
(
    id           serial                   not null
        constraint pg_order_pkey
        primary key,
    address      varchar(40)              not null,
    phone_number varchar(10)              not null,
    date_order   timestamp with time zone not null,
    order_status varchar(20)              not null,
    total_cost   numeric                  not null,
    user_id      bigint                  not null
        constraint pg_order_users_id_fkey
        references users
);

-- Create table FAVOURITES
create table favourites
(
    drink_id bigint
        constraint favourites_drink_id_fkey
        references drink,
    user_id  bigint
        constraint favourites_user_id_fkey
        references users
        on update cascade on delete cascade
);

-- Create table CART_PRODUCTS
create table cart_products
(
    drink_id bigint
        constraint cart_products_drink_id_fkey
        references drink
        on update cascade on delete cascade,
    order_id bigint
        constraint cart_products_order_id_fkey
        references pg_order
        on update cascade on delete cascade,
    count    integer not null
);