--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: coffeetearea; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE coffeetearea;


ALTER DATABASE coffeetearea OWNER TO postgres;

\connect coffeetearea

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: pgcrypto; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;


--
-- Name: EXTENSION pgcrypto; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';


SET default_tablespace = '';

--
-- Name: cart_items; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cart_items (
    order_id bigint NOT NULL,
    drink_id bigint NOT NULL,
    count integer NOT NULL
);


ALTER TABLE public.cart_items OWNER TO postgres;

--
-- Name: coffee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.coffee (
    type_id bigint NOT NULL,
    roasting_id bigint NOT NULL,
    id bigint
);


ALTER TABLE public.coffee OWNER TO postgres;

--
-- Name: coffee_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.coffee_type (
    id bigint NOT NULL,
    name character varying(40) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.coffee_type OWNER TO postgres;

--
-- Name: coffee_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.coffee_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.coffee_type_id_seq OWNER TO postgres;

--
-- Name: coffee_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.coffee_type_id_seq OWNED BY public.coffee_type.id;


--
-- Name: countries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.countries (
    id bigint NOT NULL,
    name character varying(25) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.countries OWNER TO postgres;

--
-- Name: countries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.countries_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.countries_id_seq OWNER TO postgres;

--
-- Name: countries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.countries_id_seq OWNED BY public.countries.id;


--
-- Name: drink; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.drink (
    id bigint NOT NULL,
    name character varying(30) NOT NULL,
    price numeric NOT NULL,
    about text NOT NULL,
    packaging_id bigint NOT NULL,
    manufacturer_id bigint NOT NULL,
    country_id bigint NOT NULL,
    is_deleted boolean NOT NULL,
    weight double precision,
    image character varying
);


ALTER TABLE public.drink OWNER TO postgres;

--
-- Name: drink_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.drink_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.drink_id_seq OWNER TO postgres;

--
-- Name: drink_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.drink_id_seq OWNED BY public.drink.id;


--
-- Name: favourites; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.favourites (
    drink_id bigint,
    user_id bigint
);


ALTER TABLE public.favourites OWNER TO postgres;

--
-- Name: flyway_schema_history; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE public.flyway_schema_history OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: manufacturer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manufacturer (
    id bigint NOT NULL,
    name character varying(25) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.manufacturer OWNER TO postgres;

--
-- Name: manufacturer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.manufacturer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.manufacturer_id_seq OWNER TO postgres;

--
-- Name: manufacturer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.manufacturer_id_seq OWNED BY public.manufacturer.id;


--
-- Name: packaging; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.packaging (
    id bigint NOT NULL,
    name character varying(25) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.packaging OWNER TO postgres;

--
-- Name: packaging_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.packaging_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.packaging_id_seq OWNER TO postgres;

--
-- Name: packaging_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.packaging_id_seq OWNED BY public.packaging.id;


--
-- Name: pg_order; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pg_order (
    id bigint NOT NULL,
    phone_number character varying(11),
    date_order timestamp with time zone,
    order_status character varying(20) NOT NULL,
    total_cost numeric,
    user_id bigint,
    apartment smallint,
    city character varying(255),
    district character varying(255),
    house smallint,
    index integer,
    region character varying(255),
    street character varying(255)
);


ALTER TABLE public.pg_order OWNER TO postgres;

--
-- Name: pg_order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pg_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pg_order_id_seq OWNER TO postgres;

--
-- Name: pg_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pg_order_id_seq OWNED BY public.pg_order.id;


--
-- Name: roasting; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roasting (
    id bigint NOT NULL,
    name character varying(5) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.roasting OWNER TO postgres;

--
-- Name: roasting_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roasting_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roasting_id_seq OWNER TO postgres;

--
-- Name: roasting_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roasting_id_seq OWNED BY public.roasting.id;


--
-- Name: tea; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tea (
    type_id bigint NOT NULL,
    color_id bigint NOT NULL,
    id bigint
);


ALTER TABLE public.tea OWNER TO postgres;

--
-- Name: tea_color; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tea_color (
    id bigint NOT NULL,
    name character varying(30) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.tea_color OWNER TO postgres;

--
-- Name: tea_color_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tea_color_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tea_color_id_seq OWNER TO postgres;

--
-- Name: tea_color_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tea_color_id_seq OWNED BY public.tea_color.id;


--
-- Name: tea_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tea_type (
    id bigint NOT NULL,
    name character varying(25) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.tea_type OWNER TO postgres;

--
-- Name: tea_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tea_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tea_type_id_seq OWNER TO postgres;

--
-- Name: tea_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tea_type_id_seq OWNED BY public.tea_type.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    login character varying(25) NOT NULL,
    password character varying NOT NULL,
    role character varying(10) NOT NULL,
    mail character varying(30) NOT NULL,
    is_deleted boolean NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: coffee_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coffee_type ALTER COLUMN id SET DEFAULT nextval('public.coffee_type_id_seq'::regclass);


--
-- Name: countries id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.countries ALTER COLUMN id SET DEFAULT nextval('public.countries_id_seq'::regclass);


--
-- Name: drink id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drink ALTER COLUMN id SET DEFAULT nextval('public.drink_id_seq'::regclass);


--
-- Name: manufacturer id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manufacturer ALTER COLUMN id SET DEFAULT nextval('public.manufacturer_id_seq'::regclass);


--
-- Name: packaging id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.packaging ALTER COLUMN id SET DEFAULT nextval('public.packaging_id_seq'::regclass);


--
-- Name: pg_order id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pg_order ALTER COLUMN id SET DEFAULT nextval('public.pg_order_id_seq'::regclass);


--
-- Name: roasting id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roasting ALTER COLUMN id SET DEFAULT nextval('public.roasting_id_seq'::regclass);


--
-- Name: tea_color id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea_color ALTER COLUMN id SET DEFAULT nextval('public.tea_color_id_seq'::regclass);


--
-- Name: tea_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea_type ALTER COLUMN id SET DEFAULT nextval('public.tea_type_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: cart_items; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: coffee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.coffee VALUES (1, 4, 9);
INSERT INTO public.coffee VALUES (2, 1, 10);
INSERT INTO public.coffee VALUES (2, 2, 11);
INSERT INTO public.coffee VALUES (4, 7, 12);
INSERT INTO public.coffee VALUES (1, 6, 13);
INSERT INTO public.coffee VALUES (2, 6, 14);
INSERT INTO public.coffee VALUES (3, 7, 15);
INSERT INTO public.coffee VALUES (2, 8, 16);


--
-- Data for Name: coffee_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.coffee_type VALUES (1, 'Молотый', false);
INSERT INTO public.coffee_type VALUES (2, 'Зерновой', false);
INSERT INTO public.coffee_type VALUES (3, 'Гранулированный', false);
INSERT INTO public.coffee_type VALUES (4, 'Растворимый молотый', false);
INSERT INTO public.coffee_type VALUES (5, 'Растворимый гранулированный', false);


--
-- Data for Name: countries; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.countries VALUES (1, 'Бразилия', false);
INSERT INTO public.countries VALUES (2, 'Индия', false);
INSERT INTO public.countries VALUES (3, 'Китай', false);
INSERT INTO public.countries VALUES (4, 'Зимбабве', false);
INSERT INTO public.countries VALUES (5, 'Аргентина', false);
INSERT INTO public.countries VALUES (6, 'Турция', false);
INSERT INTO public.countries VALUES (7, 'Франция', false);
INSERT INTO public.countries VALUES (8, 'Англия', false);


--
-- Data for Name: drink; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.drink VALUES (1, 'Пуэр', 1000, 'Пуэ́р — постферментированный чай. Отличается специфической технологией производства: собранные листья, обработанные до уровня зелёного чая, подвергаются процедуре микробной ферментации — естественному либо искусственному (ускоренному) старению.', 3, 6, 3, false, 0.9, NULL);
INSERT INTO public.drink VALUES (2, 'Латте', 330, 'Латте - измельчённый чай со специями, который растворяется в воде или горячем молоке. Чай-латте готовят из чая масала — чая, который заваривается вместе со смесью различных согревающих специй. Является недостающим звеном между традиционным чаем и кофе-латте.', 5, 1, 5, false, 0.7, NULL);
INSERT INTO public.drink VALUES (3, 'Те Гуань Инь', 500, 'Те Гуань Инь - Легендарный улун. Ласковый, благородный вкус и весенний душистый аромат этого чая заворожат Вас с первой встречи и навсегда. Очень популярен в Китае и за его пределами.', 5, 1, 1, false, 0.3, NULL);
INSERT INTO public.drink VALUES (6, 'Мате Green Fuerte', 1100, 'Мате Green Fuerte - Мягкая йерба, выращенная на затененных склонах, благодаря чему содержит меньшее количество дубильных веществ и, как следствие, меньше горечи. Мате 90%, натуральные добавки 10%: гуарана, катуаба, лист гинко билоба, ягоды годжи, лист смородины.', 1, 6, 1, false, 0.99, NULL);
INSERT INTO public.drink VALUES (9, 'Принц', 730, 'Принц - неповторимый купаж кофе создан из отборных сортов кофе с плантаций Центральной, Южной Америки и Индии. С самого первого глотка его бодрящий вкус и деликатный, богатый аромат покорит даже самого настоящего гурмана. Вкус кофе насыщенный, сбалансированный, с приятными фруктовыми нотками, легкой консистенции. Кофе идеален для приготовления в турке.', 1, 5, 5, false, 0.1, NULL);
INSERT INTO public.drink VALUES (10, 'Mokka', 590, 'Mokka - это крепкий и ароматный кофе средней степени обжарки (3 по 5-тибальной шкале Paulig).', 1, 4, 7, false, 0.8, NULL);
INSERT INTO public.drink VALUES (11, 'Бурбон', 320, 'Бурбон - свое название сорт получил в честь географической родины – французского острова Бурбон (ныне Реюньон). Именно здесь в начале XVIII века прижились первые саженцы кофейных деревьев, вывезенных из Йемена.', 5, 5, 8, false, 0.4, NULL);
INSERT INTO public.drink VALUES (12, 'Черная карта', 690, 'На Востоке говорят, что кофе должен быть черным, как ночь, и крепким, как настоящая любовь.Кофе «ЧЕРНАЯ КАРТА» раскрывает самую суть кофейного аромата и глубину вкуса, таящуюся в сердце кофейных зерен. Этот кофе идеален для любителей крепкого насыщенного вкуса, который великолепно раскрывается при заваривании в чашке.', 5, 3, 4, false, 0.35, NULL);
INSERT INTO public.drink VALUES (13, 'Жокей', 1199, 'Жокей - насыщенный, крепкий, ароматный, с пряными нотками Жокей Для турки создан искусным сочетанием лучших сортов кофе из Центральной и Южной Америки, Африки и Индии. Особо мелкий помол идеален для приготовления кофе в турке.', 4, 4, 2, false, 0.85, NULL);
INSERT INTO public.drink VALUES (15, 'Monarch', 990, 'Monarch обладает богатым, классическим вкусом и притягательным ароматом, благодаря искусному сочетанию отборных кофейных зёрен и глубокой обжарке, и является наиболее популярным кофе в линейке Jacobs. Приготовьте кофе Monarch для себя и своих близких и почувствуйте его вдохновляющую Аромагию', 4, 4, 5, false, 0.45, NULL);
INSERT INTO public.drink VALUES (16, 'Bravo Brazilia', 450, 'Кофе Brazilia специально подобранный сорт бразильской Арабики для идеально сбалансированного эспрессо с плотной кремовой текстурой и богатым сливочным послевкусием. 100% высокогорная арабика из Бразилии. Темная обжарка.', 5, 3, 4, false, 1, NULL);
INSERT INTO public.drink VALUES (8, 'Золото Йоркшира', 500, 'Золото Йоркшира - Окруженный высокогорными деревьями Баньчжан расположен на горном хребте Хэндуань в г. Буланьшань, на 1500-2000 м выше уровня моря. Горный серпантин, проходящий по тем местам, сравнивают с известными сычуаньскими дорогами, которые в китайской культуре олицетворяют трудный жизненный путь, что акцентирует наше внимание на трудностях получения этого чая.', 4, 6, 4, false, 0.35, NULL);
INSERT INTO public.drink VALUES (5, 'Да Хун Пао', 2199, 'Да Хун Пао - невзрачен, как и все удивительные сорта. Они имеют тяжелый маслянистый аромат, который превращается в легкий напиток коричневого цвета. При заваривании Да Хун Пао раз от раза с каждой последующей заваркой можно заметить изменение вкуса и аромата от черного хлеба до цветочных легких ноток на фоне грубой основы из печеного каштана.', 2, 1, 3, false, 0.65, NULL);
INSERT INTO public.drink VALUES (7, 'Taylors Lapsang Souchong', 699, 'Taylors Lapsang Souchong — легендарный сорт черного купажа, выпускаемый в порционном варианте. Его получают из сырья, собранного в горах провинции Фуцзянь. Ферментация чайных листов осуществляется рядом с огнем, после чего их коптят на сосновых дровах. Благодаря такой обработке ароматический букет наполняется благородными хвойными тонами. Чай Тейлорс Лапсанг Сушонг в пакетиках имеет сложный вкус, изобилующий копчеными мотивами, отголосками сухофруктов, имбиря и древесины. ', 4, 2, 8, false, 0.45, NULL);
INSERT INTO public.drink VALUES (4, 'Улун', 780, 'Улун - чай, который построен на полутонах: тонкое сливочное послевкусие, деликатные намеки на сладость карамели – настоящее открытие для европейцев, привычных к прямолинейности черного чая. Согревающий золотистый настой поднимет настроение в зимнюю стужу, молочный аромат успокоит и настроит на позитивный лад.', 1, 6, 2, false, 0.55, NULL);
INSERT INTO public.drink VALUES (14, 'Oro', 790, 'Ароматный напиток Oro, созданный для требовательного кофемана с утонченным вкусом. Тщательно подобранный купаж создан из 100 % высокогорной арабики, выращенной на лучших плантациях Центральной Америки. Средняя обжарка и высокое качество сырья позволяют получить ярко выраженный красочный вкус и запоминающийся аромат, наполненный выразительной цветочной нотой с небольшой горчинкой.', 1, 5, 3, false, 0.75, NULL);
INSERT INTO public.drink VALUES (17, 'strqwdqwdqwing', 1111, 'sdfsdfsdfsdfssdfsdfsdfsdfsdfsdfsdfdfsdf', 1, 2, 2, false, 0.000333, NULL);
INSERT INTO public.drink VALUES (18, 'strqwsdqwdqwing', 1111, 'sdfsdfsdfsdfssdfsdfsdfsdfsdfsdfsdfdfsdf', 1, 2, 2, false, 0.333, NULL);


--
-- Data for Name: favourites; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: flyway_schema_history; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.flyway_schema_history VALUES (1, '1', '<< Flyway Baseline >>', 'BASELINE', '<< Flyway Baseline >>', NULL, 'null', '2020-11-19 20:19:18.477309', 0, true);
INSERT INTO public.flyway_schema_history VALUES (2, '2', 'Edit id types', 'SQL', 'V2__Edit_id_types.sql', 39098137, 'postgres', '2020-11-19 20:19:18.503643', 104, true);
INSERT INTO public.flyway_schema_history VALUES (3, '3', 'Update types and columns', 'SQL', 'V3__Update_types_and_columns.sql', -588659692, 'postgres', '2020-11-19 20:19:18.628977', 5, true);
INSERT INTO public.flyway_schema_history VALUES (4, '4', 'Add new datas', 'SQL', 'V4__Add_new_datas.sql', 1998380016, 'postgres', '2020-11-19 20:19:18.642929', 19, true);
INSERT INTO public.flyway_schema_history VALUES (5, '5', 'Add datas for tea color & foreign key', 'SQL', 'V5__Add_datas_for_tea_color_&_foreign_key.sql', -165597598, 'postgres', '2020-11-19 20:19:18.667414', 3, true);
INSERT INTO public.flyway_schema_history VALUES (6, '6', 'Add datas & remake drink types', 'SQL', 'V6__Add_datas_&_remake_drink_types.sql', 357921447, 'postgres', '2020-11-19 20:19:18.677765', 9, true);
INSERT INTO public.flyway_schema_history VALUES (7, '7', 'Add datas tea & coffee', 'SQL', 'V7__Add_datas_tea_&_coffee.sql', -1853055046, 'postgres', '2020-11-19 20:19:18.691552', 7, true);
INSERT INTO public.flyway_schema_history VALUES (8, '8', 'Edit table drink & order', 'SQL', 'V8__Edit_table_drink_&_order.sql', 1581749165, 'postgres', '2020-11-19 20:19:18.701967', 6, true);
INSERT INTO public.flyway_schema_history VALUES (9, '9', 'Drop ids in coffee & tea', 'SQL', 'V9__Drop_ids_in_coffee_&_tea.sql', 249405413, 'postgres', '2020-11-19 20:19:18.715648', 4, true);
INSERT INTO public.flyway_schema_history VALUES (10, '10', 'Create ids for tea & coffee', 'SQL', 'V10__Create_ids_for_tea_&_coffee.sql', 1968844587, 'postgres', '2020-11-19 20:19:18.724791', 1, true);
INSERT INTO public.flyway_schema_history VALUES (11, '11', 'Delete data from coffee type', 'SQL', 'V11__Delete_data_from_coffee_type.sql', -227319070, 'postgres', '2020-11-19 20:19:18.730002', 1, true);
INSERT INTO public.flyway_schema_history VALUES (12, '12', 'new datas for for coffee', 'SQL', 'V12__new_datas_for_for_coffee.sql', -465343537, 'postgres', '2020-11-19 20:19:18.734574', 3, true);
INSERT INTO public.flyway_schema_history VALUES (13, '13', 'New datas for tea', 'SQL', 'V13__New_datas_for_tea.sql', -182823284, 'postgres', '2020-11-19 20:19:18.742125', 4, true);
INSERT INTO public.flyway_schema_history VALUES (14, '14', 'New admin data', 'SQL', 'V14__New_admin_data.sql', -1675316426, 'postgres', '2020-11-19 20:19:18.750051', 1, true);
INSERT INTO public.flyway_schema_history VALUES (15, '15', 'New columns for drinks', 'SQL', 'V15__New_columns_for_drinks.sql', 756227395, 'postgres', '2020-11-19 20:19:18.754606', 1, true);
INSERT INTO public.flyway_schema_history VALUES (16, '16', 'Drop not null for order', 'SQL', 'V16__Drop_not_null_for_order.sql', 848616359, 'postgres', '2020-11-19 20:19:18.759104', 1, true);
INSERT INTO public.flyway_schema_history VALUES (17, '17', 'Rename cart products', 'SQL', 'V17__Rename_cart_products.sql', 504999964, 'postgres', '2020-11-19 20:19:18.763917', 0, true);
INSERT INTO public.flyway_schema_history VALUES (18, '18', 'Edit varchar in order', 'SQL', 'V18__Edit_varchar_in_order.sql', -1418154985, 'postgres', '2020-11-19 20:19:18.767684', 0, true);
INSERT INTO public.flyway_schema_history VALUES (19, '19', 'Add login unique', 'SQL', 'V19__Add_login_unique.sql', 567701248, 'postgres', '2020-11-19 20:19:18.7718', 3, true);
INSERT INTO public.flyway_schema_history VALUES (20, '20', 'New table for Address.sql', 'SQL', 'V20__New_table_for_Address.sql.sql', -1732683935, 'postgres', '2020-11-19 20:19:18.778709', 7, true);
INSERT INTO public.flyway_schema_history VALUES (21, '21', 'Edit address parametrs', 'SQL', 'V21__Edit_address_parametrs.sql', -572504053, 'postgres', '2020-11-19 20:19:18.788787', 1, true);
INSERT INTO public.flyway_schema_history VALUES (22, '22', 'Make address Embeddable', 'SQL', 'V22__Make_address_Embeddable.sql', -498996963, 'postgres', '2020-11-19 20:19:18.793389', 1, true);
INSERT INTO public.flyway_schema_history VALUES (23, '23', 'Add embedded columns', 'SQL', 'V23__Add_embedded_columns.sql', -1077563381, 'postgres', '2020-11-19 20:19:18.800001', 1, true);


--
-- Data for Name: manufacturer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.manufacturer VALUES (1, 'Lipton', false);
INSERT INTO public.manufacturer VALUES (2, 'Richard', false);
INSERT INTO public.manufacturer VALUES (3, 'Arabica', false);
INSERT INTO public.manufacturer VALUES (4, 'Nescafe', false);
INSERT INTO public.manufacturer VALUES (5, 'Jacobs', false);
INSERT INTO public.manufacturer VALUES (6, 'Curtis', false);


--
-- Data for Name: packaging; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.packaging VALUES (1, 'Вакуумная упаковка', false);
INSERT INTO public.packaging VALUES (2, 'Коробка', false);
INSERT INTO public.packaging VALUES (3, 'Бумажный пакет', false);
INSERT INTO public.packaging VALUES (4, 'Стеклаянная банка', false);
INSERT INTO public.packaging VALUES (5, 'Жестяная банка', false);


--
-- Data for Name: pg_order; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: roasting; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roasting VALUES (1, '1', false);
INSERT INTO public.roasting VALUES (2, '2', false);
INSERT INTO public.roasting VALUES (3, '3', false);
INSERT INTO public.roasting VALUES (4, '4', false);
INSERT INTO public.roasting VALUES (5, '5', false);
INSERT INTO public.roasting VALUES (6, '6', false);
INSERT INTO public.roasting VALUES (7, '7', false);
INSERT INTO public.roasting VALUES (8, '8', false);


--
-- Data for Name: tea; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tea VALUES (2, 2, 1);
INSERT INTO public.tea VALUES (1, 1, 2);
INSERT INTO public.tea VALUES (1, 1, 3);
INSERT INTO public.tea VALUES (2, 1, 4);
INSERT INTO public.tea VALUES (1, 3, 5);
INSERT INTO public.tea VALUES (2, 2, 7);
INSERT INTO public.tea VALUES (2, 2, 8);
INSERT INTO public.tea VALUES (1, 1, 17);
INSERT INTO public.tea VALUES (1, 1, 18);


--
-- Data for Name: tea_color; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tea_color VALUES (1, 'Черный', false);
INSERT INTO public.tea_color VALUES (2, 'Зеленый', false);
INSERT INTO public.tea_color VALUES (3, 'Фруктовый', false);


--
-- Data for Name: tea_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tea_type VALUES (1, 'Листовой', false);
INSERT INTO public.tea_type VALUES (2, 'Гранулированный', false);
INSERT INTO public.tea_type VALUES (3, 'Пакетированный', false);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (2, 'Сергей', 'Иванов', 'ivan123', 'pass123', 'CUSTOMER', 'ivan@mail.ru', false);
INSERT INTO public.users VALUES (3, 'Сергей', 'Павлов', 'try123523', 'pass123', 'CUSTOMER', 'serg@mail.ru', false);
INSERT INTO public.users VALUES (4, 'Григорий', 'Дубцов', 'grigort', 'pass123', 'CUSTOMER', 'grig@mail.ru', false);
INSERT INTO public.users VALUES (5, 'Артур', 'Вартанян', 'admin', 'pass123', 'ADMIN', 'artur@mail.ru', false);
INSERT INTO public.users VALUES (1, 'Артур', 'Вартанян', 'art123', '$2a$10$UXRrtm7rGCVKe28YaLyTWOqeLWpnTXl2JpZ7ievl6KmZgU.wTSF52', 'CUSTOMER', 'artur@mail.ru', false);
INSERT INTO public.users VALUES (6, 'Артур', 'Вартанян', 'admin123', '$2a$10$UXRrtm7rGCVKe28YaLyTWOqeLWpnTXl2JpZ7ievl6KmZgU.wTSF52', 'ADMIN', 'artur@mail.ru', false);


--
-- Name: coffee_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.coffee_type_id_seq', 7, true);


--
-- Name: countries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.countries_id_seq', 8, true);


--
-- Name: drink_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.drink_id_seq', 18, true);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: manufacturer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.manufacturer_id_seq', 6, true);


--
-- Name: packaging_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.packaging_id_seq', 5, true);


--
-- Name: pg_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pg_order_id_seq', 1, false);


--
-- Name: roasting_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roasting_id_seq', 8, true);


--
-- Name: tea_color_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tea_color_id_seq', 3, true);


--
-- Name: tea_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tea_type_id_seq', 3, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 6, true);


--
-- Name: coffee_type coffee_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coffee_type
    ADD CONSTRAINT coffee_type_pkey PRIMARY KEY (id);


--
-- Name: countries countries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (id);


--
-- Name: drink drink_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drink
    ADD CONSTRAINT drink_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history flyway_schema_history_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.flyway_schema_history
    ADD CONSTRAINT flyway_schema_history_pk PRIMARY KEY (installed_rank);


--
-- Name: manufacturer manufacturer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manufacturer
    ADD CONSTRAINT manufacturer_pkey PRIMARY KEY (id);


--
-- Name: cart_items order_drink_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT order_drink_pkey PRIMARY KEY (order_id, drink_id);


--
-- Name: packaging packaging_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.packaging
    ADD CONSTRAINT packaging_pkey PRIMARY KEY (id);


--
-- Name: pg_order pg_order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pg_order
    ADD CONSTRAINT pg_order_pkey PRIMARY KEY (id);


--
-- Name: roasting roasting_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roasting
    ADD CONSTRAINT roasting_pkey PRIMARY KEY (id);


--
-- Name: tea_color tea_color_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea_color
    ADD CONSTRAINT tea_color_pkey PRIMARY KEY (id);


--
-- Name: tea_type tea_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea_type
    ADD CONSTRAINT tea_type_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: flyway_schema_history_s_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX flyway_schema_history_s_idx ON public.flyway_schema_history USING btree (success);


--
-- Name: users_login_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX users_login_uindex ON public.users USING btree (login);


--
-- Name: cart_items cart_products_drink_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT cart_products_drink_id_fkey FOREIGN KEY (drink_id) REFERENCES public.drink(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: cart_items cart_products_order_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cart_items
    ADD CONSTRAINT cart_products_order_id_fkey FOREIGN KEY (order_id) REFERENCES public.pg_order(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: coffee coffee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coffee
    ADD CONSTRAINT coffee_id_fkey FOREIGN KEY (id) REFERENCES public.drink(id);


--
-- Name: coffee coffee_roasting_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coffee
    ADD CONSTRAINT coffee_roasting_id_fkey FOREIGN KEY (roasting_id) REFERENCES public.roasting(id);


--
-- Name: coffee coffee_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.coffee
    ADD CONSTRAINT coffee_type_id_fkey FOREIGN KEY (type_id) REFERENCES public.coffee_type(id);


--
-- Name: drink drink_country_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drink
    ADD CONSTRAINT drink_country_id_fkey FOREIGN KEY (country_id) REFERENCES public.countries(id);


--
-- Name: drink drink_manufacturer_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drink
    ADD CONSTRAINT drink_manufacturer_id_fkey FOREIGN KEY (manufacturer_id) REFERENCES public.manufacturer(id);


--
-- Name: drink drink_packaging_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.drink
    ADD CONSTRAINT drink_packaging_id_fkey FOREIGN KEY (packaging_id) REFERENCES public.packaging(id);


--
-- Name: favourites favourites_drink_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourites
    ADD CONSTRAINT favourites_drink_id_fkey FOREIGN KEY (drink_id) REFERENCES public.drink(id);


--
-- Name: favourites favourites_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.favourites
    ADD CONSTRAINT favourites_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: pg_order pg_order_users_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pg_order
    ADD CONSTRAINT pg_order_users_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: tea tea_color_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea
    ADD CONSTRAINT tea_color_id_fkey FOREIGN KEY (color_id) REFERENCES public.tea_color(id);


--
-- Name: tea tea_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea
    ADD CONSTRAINT tea_id_fkey FOREIGN KEY (id) REFERENCES public.drink(id);


--
-- Name: tea tea_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tea
    ADD CONSTRAINT tea_type_id_fkey FOREIGN KEY (type_id) REFERENCES public.tea_type(id);


--
-- PostgreSQL database dump complete
--

