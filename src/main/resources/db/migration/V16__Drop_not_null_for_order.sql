alter table pg_order alter column address drop not null;

alter table pg_order alter column phone_number drop not null;

alter table pg_order alter column date_order drop not null;

alter table pg_order alter column total_cost drop not null;

alter table pg_order alter column user_id drop not null;