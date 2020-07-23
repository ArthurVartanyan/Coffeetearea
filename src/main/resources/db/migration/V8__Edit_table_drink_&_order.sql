-- Edit ID type in TEA_COLOR
alter table public.tea_color alter column id type bigint using id::bigint;