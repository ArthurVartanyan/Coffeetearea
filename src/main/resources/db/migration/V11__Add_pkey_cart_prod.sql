-- -- CART_PRODUCTS
-- ALTER TABLE public.cart_products
--   ADD id serial primary key;
--
-- alter table cart_products alter column id type bigint using id::bigint;
--
--   alter table pg_order
--     add cart_products_id bigint references cart_products(id);