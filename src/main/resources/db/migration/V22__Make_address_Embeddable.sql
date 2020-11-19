alter table pg_order
    drop column address_id;

drop table pg_address cascade;