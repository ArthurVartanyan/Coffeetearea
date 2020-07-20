-- В ходе работы необходимо было увеличить значение типа
alter table coffee_type alter column name type varchar(40) using name::varchar(40);

-- Создаем новый справочник (TEA_COLOR)
create table tea_color(id serial primary key,
                        name varchar(30) not null, is_deleted boolean not null );
