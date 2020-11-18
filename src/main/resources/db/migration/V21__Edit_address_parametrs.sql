alter table pg_order
    drop column address;

alter table pg_order
    add column address_id bigint references pg_address(id) on delete cascade on update cascade
