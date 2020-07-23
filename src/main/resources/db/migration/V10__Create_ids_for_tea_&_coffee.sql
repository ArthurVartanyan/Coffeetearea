-- TABLE COFFEE
alter table coffee add
    id bigint
        constraint coffee_id_fkey
            references drink;

-- TABLE TEA
alter table tea add
    id bigint
        constraint tea_id_fkey
            references drink;