-- Создаем ключ в TEA со ссылкой на TEA_COLOR
alter table tea
    add color_id bigint not null references tea_color(id);

-- Заполняем таблицу TEA_COLOR
insert into public.tea_color(name, is_deleted)
values ('Черный', false);
insert into public.tea_color(name, is_deleted)
values ('Зеленый', false);
insert into public.tea_color(name, is_deleted)
values ('Фруктовый', false);