-- COFFEE TABLE
alter table public.coffee
    drop constraint coffee_pkey cascade;

alter table public.coffee
    drop column drink_id;

alter table public.coffee
    drop column id;

-- TEA TABLE
alter table public.tea
    drop constraint tea_pkey cascade;

alter table public.tea
    drop column drink_id;

alter table public.tea
    drop column id;
