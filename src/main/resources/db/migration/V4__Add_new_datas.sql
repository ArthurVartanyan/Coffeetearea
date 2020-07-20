-- Создаем новых пользователей
insert into public.users(name, last_name, login, password, role, mail, is_deleted)
values ('Артур', 'Вартанян', 'art123', 'pass123', 'CUSTOMER', 'artur@mail.ru', false);
insert into public.users(name, last_name, login, password, role, mail, is_deleted)
values ('Сергей', 'Иванов', 'ivan123', 'pass123', 'CUSTOMER', 'ivan@mail.ru', false);
insert into public.users(name, last_name, login, password, role, mail, is_deleted)
values ('Сергей', 'Павлов', 'try123523', 'pass123', 'CUSTOMER', 'serg@mail.ru', false);
insert into public.users(name, last_name, login, password, role, mail, is_deleted)
values ('Григорий', 'Дубцов', 'grigort', 'pass123', 'CUSTOMER', 'grig@mail.ru', false);

-- Заполняем справочник COFFEE_TYPE
insert into public.coffee_type(name, is_deleted)
values ('Молотый', false);
insert into public.coffee_type(name, is_deleted)
values ('Зерновой', false);
insert into public.coffee_type(name, is_deleted)
values ('Гранулированный', false);
insert into public.coffee_type(name, is_deleted)
values ('Растворимый молотый', false);
insert into public.coffee_type(name, is_deleted)
values ('Растворимый гранулированный', false);

-- Заполняем справочник TEA_TYPE
insert into public.tea_type(name, is_deleted)
values ('Листовой', false);
insert into public.tea_type(name, is_deleted)
values ('Гранулированный', false);
insert into public.coffee_type(name, is_deleted)
values ('Молотый', false);
insert into public.coffee_type(name, is_deleted)
values ('Пакетированный', false);

-- Заполняем справочник Country
insert into public.countries(name, is_deleted)
values ('Бразилия', false);
insert into public.countries(name, is_deleted)
values ('Индия', false);
insert into public.countries(name, is_deleted)
values ('Китай', false);
insert into public.countries(name, is_deleted)
values ('Зимбабве', false);
insert into public.countries(name, is_deleted)
values ('Аргентина', false);
insert into public.countries(name, is_deleted)
values ('Турция', false);
insert into public.countries(name, is_deleted)
values ('Франция', false);
insert into public.countries(name, is_deleted)
values ('Англия', false);

-- Заполняем справочник Manufacturer
insert into public.manufacturer(name, is_deleted)
values ('Lipton', false);
insert into public.manufacturer(name, is_deleted)
values ('Richard', false);
insert into public.manufacturer(name, is_deleted)
values ('Arabica', false);
insert into public.manufacturer(name, is_deleted)
values ('Nescafe', false);
insert into public.manufacturer(name, is_deleted)
values ('Jacobs', false);
insert into public.manufacturer(name, is_deleted)
values ('Curtis', false);

-- Заполняем справочник Packaging
insert into public.packaging(name, is_deleted)
values ('Вакуумная упаковка', false);
insert into public.packaging(name, is_deleted)
values ('Коробка', false);
insert into public.packaging(name, is_deleted)
values ('Бумажный пакет', false);
insert into public.packaging(name, is_deleted)
values ('Стеклаянная банка', false);
insert into public.packaging(name, is_deleted)
values ('Жестяная банка', false);

-- Заполняем справочник Roasting
insert into public.roasting(roasting, is_deleted)
values (1, false);
insert into public.roasting(roasting, is_deleted)
values (2, false);
insert into public.roasting(roasting, is_deleted)
values (3, false);
insert into public.roasting(roasting, is_deleted)
values (4, false);
insert into public.roasting(roasting, is_deleted)
values (5, false);
insert into public.roasting(roasting, is_deleted)
values (6, false);
insert into public.roasting(roasting, is_deleted)
values (7, false);
insert into public.roasting(roasting, is_deleted)
values (8, false);


