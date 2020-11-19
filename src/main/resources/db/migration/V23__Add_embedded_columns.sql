alter table pg_order
    add column apartment smallint,
    add column city      varchar(255),
    add column district  varchar(255),
    add column house smallint,
    add column index integer,
    add column region varchar (255),
    add column street varchar (255);