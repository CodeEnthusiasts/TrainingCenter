--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: custom_record; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.custom_record (
    id bigint NOT NULL,
    date date,
    description character varying(255),
    value double precision NOT NULL,
    personal_records_id bigint
);


ALTER TABLE public.custom_record OWNER TO postgres;

--
-- Name: custom_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.custom_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.custom_record_id_seq OWNER TO postgres;

--
-- Name: custom_record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.custom_record_id_seq OWNED BY public.custom_record.id;


--
-- Name: endurance_exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endurance_exercise (
    id bigint NOT NULL,
    distance double precision NOT NULL,
    distance_unit character varying(255),
    duration time without time zone,
    heart_rate smallint NOT NULL,
    vo2max_percentage smallint NOT NULL,
    time_unit character varying(255),
    movement_id bigint,
    training_session_id bigint
);


ALTER TABLE public.endurance_exercise OWNER TO postgres;

--
-- Name: endurance_exercise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endurance_exercise_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endurance_exercise_id_seq OWNER TO postgres;

--
-- Name: endurance_exercise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endurance_exercise_id_seq OWNED BY public.endurance_exercise.id;


--
-- Name: endurance_record; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endurance_record (
    id bigint NOT NULL,
    date date,
    distance double precision NOT NULL,
    distance_unit character varying(255),
    duration time without time zone,
    movement_name character varying(255),
    time_unit character varying(255),
    personal_records_id bigint
);


ALTER TABLE public.endurance_record OWNER TO postgres;

--
-- Name: endurance_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endurance_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endurance_record_id_seq OWNER TO postgres;

--
-- Name: endurance_record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endurance_record_id_seq OWNED BY public.endurance_record.id;


--
-- Name: image; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.image (
    id bigint NOT NULL,
    file_url character varying(255),
    movement_id bigint,
    muscle_id bigint,
    user_id bigint
);


ALTER TABLE public.image OWNER TO postgres;

--
-- Name: image_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.image_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.image_id_seq OWNER TO postgres;

--
-- Name: image_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.image_id_seq OWNED BY public.image.id;


--
-- Name: key_technique_element; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_technique_element (
    id bigint NOT NULL,
    content character varying(255),
    movement_id bigint
);


ALTER TABLE public.key_technique_element OWNER TO postgres;

--
-- Name: key_technique_element_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.key_technique_element_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.key_technique_element_id_seq OWNER TO postgres;

--
-- Name: key_technique_element_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.key_technique_element_id_seq OWNED BY public.key_technique_element.id;


--
-- Name: movement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movement (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.movement OWNER TO postgres;

--
-- Name: movement_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movement_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movement_id_seq OWNER TO postgres;

--
-- Name: movement_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movement_id_seq OWNED BY public.movement.id;


--
-- Name: muscle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.muscle (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(255),
    movement_id bigint
);


ALTER TABLE public.muscle OWNER TO postgres;

--
-- Name: muscle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.muscle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.muscle_id_seq OWNER TO postgres;

--
-- Name: muscle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.muscle_id_seq OWNED BY public.muscle.id;


--
-- Name: personal_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal_records (
    id bigint NOT NULL,
    user_id bigint
);


ALTER TABLE public.personal_records OWNER TO postgres;

--
-- Name: personal_records_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.personal_records_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.personal_records_id_seq OWNER TO postgres;

--
-- Name: personal_records_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.personal_records_id_seq OWNED BY public.personal_records.id;


--
-- Name: priority; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.priority (
    id bigint NOT NULL,
    details character varying(255),
    name character varying(255),
    training_plan_id bigint
);


ALTER TABLE public.priority OWNER TO postgres;

--
-- Name: priority_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.priority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.priority_id_seq OWNER TO postgres;

--
-- Name: priority_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.priority_id_seq OWNED BY public.priority.id;


--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_seq OWNER TO postgres;

--
-- Name: role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.role_id_seq OWNED BY public.role.id;


--
-- Name: strength_exercise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.strength_exercise (
    id bigint NOT NULL,
    repetition_unit character varying(255),
    reps smallint NOT NULL,
    weight double precision NOT NULL,
    weight_unit character varying(255),
    movement_id bigint,
    training_session_id bigint
);


ALTER TABLE public.strength_exercise OWNER TO postgres;

--
-- Name: strength_exercise_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.strength_exercise_details (
    id bigint NOT NULL,
    holding_down smallint NOT NULL,
    holding_up smallint NOT NULL,
    lowering smallint NOT NULL,
    note character varying(255),
    raising smallint NOT NULL,
    reps_in_reserve integer NOT NULL,
    strength_exercise_id bigint
);


ALTER TABLE public.strength_exercise_details OWNER TO postgres;

--
-- Name: strength_exercise_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.strength_exercise_details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.strength_exercise_details_id_seq OWNER TO postgres;

--
-- Name: strength_exercise_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.strength_exercise_details_id_seq OWNED BY public.strength_exercise_details.id;


--
-- Name: strength_exercise_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.strength_exercise_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.strength_exercise_id_seq OWNER TO postgres;

--
-- Name: strength_exercise_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.strength_exercise_id_seq OWNED BY public.strength_exercise.id;


--
-- Name: strength_record; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.strength_record (
    id bigint NOT NULL,
    date date,
    movement_name character varying(255),
    repetition_unit character varying(255),
    reps smallint NOT NULL,
    weight double precision NOT NULL,
    weight_unit character varying(255),
    personal_records_id bigint
);


ALTER TABLE public.strength_record OWNER TO postgres;

--
-- Name: strength_record_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.strength_record_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.strength_record_id_seq OWNER TO postgres;

--
-- Name: strength_record_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.strength_record_id_seq OWNED BY public.strength_record.id;


--
-- Name: training_plan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_plan (
    id bigint NOT NULL,
    description character varying(255),
    difficulty character varying(255),
    end_date date,
    name character varying(255),
    number_of_executed_trainings smallint NOT NULL,
    number_of_planned_trainings smallint NOT NULL,
    start_date date,
    user_id bigint
);


ALTER TABLE public.training_plan OWNER TO postgres;

--
-- Name: training_plan_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.training_plan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.training_plan_id_seq OWNER TO postgres;

--
-- Name: training_plan_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.training_plan_id_seq OWNED BY public.training_plan.id;


--
-- Name: training_session; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_session (
    id bigint NOT NULL,
    date date,
    day_of_week character varying(255),
    difficulty character varying(255),
    end_time time without time zone,
    name character varying(255),
    notes character varying(255),
    start_time time without time zone,
    training_duration time without time zone,
    training_plan_id bigint
);


ALTER TABLE public.training_session OWNER TO postgres;

--
-- Name: training_session_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.training_session_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.training_session_id_seq OWNER TO postgres;

--
-- Name: training_session_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.training_session_id_seq OWNED BY public.training_session.id;


--
-- Name: user_details; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_details (
    id bigint NOT NULL,
    age smallint NOT NULL,
    body_weight_unit character varying(255),
    height double precision NOT NULL,
    height_unit character varying(255),
    sex character varying(255),
    weight double precision NOT NULL,
    user_id bigint
);


ALTER TABLE public.user_details OWNER TO postgres;

--
-- Name: user_details_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_details_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_details_id_seq OWNER TO postgres;

--
-- Name: user_details_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_details_id_seq OWNED BY public.user_details.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
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
-- Name: users_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users_roles (
    users_id bigint NOT NULL,
    roles_id bigint NOT NULL
);


ALTER TABLE public.users_roles OWNER TO postgres;

--
-- Name: custom_record id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_record ALTER COLUMN id SET DEFAULT nextval('public.custom_record_id_seq'::regclass);


--
-- Name: endurance_exercise id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercise ALTER COLUMN id SET DEFAULT nextval('public.endurance_exercise_id_seq'::regclass);


--
-- Name: endurance_record id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_record ALTER COLUMN id SET DEFAULT nextval('public.endurance_record_id_seq'::regclass);


--
-- Name: image id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image ALTER COLUMN id SET DEFAULT nextval('public.image_id_seq'::regclass);


--
-- Name: key_technique_element id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_technique_element ALTER COLUMN id SET DEFAULT nextval('public.key_technique_element_id_seq'::regclass);


--
-- Name: movement id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement ALTER COLUMN id SET DEFAULT nextval('public.movement_id_seq'::regclass);


--
-- Name: muscle id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscle ALTER COLUMN id SET DEFAULT nextval('public.muscle_id_seq'::regclass);


--
-- Name: personal_records id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records ALTER COLUMN id SET DEFAULT nextval('public.personal_records_id_seq'::regclass);


--
-- Name: priority id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.priority ALTER COLUMN id SET DEFAULT nextval('public.priority_id_seq'::regclass);


--
-- Name: role id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role ALTER COLUMN id SET DEFAULT nextval('public.role_id_seq'::regclass);


--
-- Name: strength_exercise id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise ALTER COLUMN id SET DEFAULT nextval('public.strength_exercise_id_seq'::regclass);


--
-- Name: strength_exercise_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise_details ALTER COLUMN id SET DEFAULT nextval('public.strength_exercise_details_id_seq'::regclass);


--
-- Name: strength_record id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_record ALTER COLUMN id SET DEFAULT nextval('public.strength_record_id_seq'::regclass);


--
-- Name: training_plan id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plan ALTER COLUMN id SET DEFAULT nextval('public.training_plan_id_seq'::regclass);


--
-- Name: training_session id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_session ALTER COLUMN id SET DEFAULT nextval('public.training_session_id_seq'::regclass);


--
-- Name: user_details id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details ALTER COLUMN id SET DEFAULT nextval('public.user_details_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: custom_record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.custom_record (id, date, description, value, personal_records_id) FROM stdin;
1	2020-10-10	Vertical jump	0.8	1
2	2020-03-03	Drive 100km on bike	100	1
3	2020-03-04	Drive 105km on bike	100	2
\.


--
-- Data for Name: endurance_exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endurance_exercise (id, distance, distance_unit, duration, heart_rate, vo2max_percentage, time_unit, movement_id, training_session_id) FROM stdin;
1	2	KILOMETERS	00:15:00	130	70	MINUTES	6	2
2	2	KILOMETERS	00:10:00	150	80	MINUTES	6	2
3	1	KILOMETERS	00:05:00	170	90	MINUTES	6	2
\.


--
-- Data for Name: endurance_record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endurance_record (id, date, distance, distance_unit, duration, movement_name, time_unit, personal_records_id) FROM stdin;
1	2020-05-09	1	KILOMETERS	00:03:00	Running	HOURS	1
2	2020-07-09	5	KILOMETERS	00:28:00	Running	HOURS	1
3	2021-05-09	100	METERS	00:10:00	Swimming	HOURS	1
4	2021-05-09	100	METERS	00:10:00	Swimming	HOURS	2
\.


--
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.image (id, file_url, movement_id, muscle_id, user_id) FROM stdin;
2	https://res.cloudinary.com/dr6odau4r/image/upload/v1604387417/qbu1rpql12lszfyey15u.jpg	\N	\N	\N
3	https://res.cloudinary.com/dr6odau4r/image/upload/v1594185873/sample.jpg	\N	\N	\N
1	https://res.cloudinary.com/dr6odau4r/image/upload/v1604332186/gxiql7mxiykikz1f5rej.jpg	\N	\N	1
7	https://www.yogajournal.com/.image/t_share/MTQ2ODMwNzA2OTE4NTY1NjA5/juneanatomy.jpg	\N	1	\N
8	https://www.performancehealth.com/media/wysiwyg/blog/articles/Hamstring-quadriceps_3.PNG	\N	2	\N
9	https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQvd9IRdgVMu8sf0J0E_sQG4jYcvuZLFludzw&usqp=CAU	\N	3	\N
4	https://squatuniversity.com/wp-content/uploads/2016/02/859835_577024942352334_10881976_o.jpg	1	\N	\N
5	https://barbend.com/wp-content/uploads/2019/04/Bench-Press-Plateau-1024x538.jpg	2	\N	\N
6	https://barbend.com/wp-content/uploads/2016/11/floating-clean-pull.png	3	\N	\N
\.


--
-- Data for Name: key_technique_element; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_technique_element (id, content, movement_id) FROM stdin;
1	Keep chest up	1
2	Plain foot, weight on the middle	1
3	Pull shoulder blades together	2
4	Elbow under the bar	2
5	Kepp air pressure in diapragma	3
6	Push legs to the floow	3
\.


--
-- Data for Name: movement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movement (id, name) FROM stdin;
1	Squat
2	Bench Press
3	Dead lift
4	Pull Up
5	Overhead Press
6	Run outdoor
\.


--
-- Data for Name: muscle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.muscle (id, description, name, movement_id) FROM stdin;
1	Biggest Human Muscle	Glute	1
2	Primary knee extensor	Quad	2
3	Sign of Arnold, big muscle in front of  	Peck	3
4	Small, but fameous muscle	Biceps	4
5	Long, tought muscles on the back thigh	Hamsting	5
6	Very important to stabilization of whole arm	Shoulder	2
\.


--
-- Data for Name: personal_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal_records (id, user_id) FROM stdin;
1	1
2	2
\.


--
-- Data for Name: priority; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.priority (id, details, name, training_plan_id) FROM stdin;
1	Lower chest is the weakest part - need to work on it	Lower chest growth	1
2	Quad is very irresistible to higher reps - needs to get better before strength phase	Develop quad endurance	2
4	In order to beat 200kg barrier, need to be on 180 in strength phase at least	Gain 10kg + in squat	3
6	Rest them to heal tendinitis	Heal injured elbow	5
5	This will improve power generation ability for sure	Beat the record in clean and jerk - + 132.5kg	5
3	Right scapulae is unstable and destroy whole movement trajectory	Improve bench stability	2
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id, name) FROM stdin;
1	ROLE_USER
2	ROLE_ADMIN
3	ROLE_MODERATOR
\.


--
-- Data for Name: strength_exercise; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.strength_exercise (id, repetition_unit, reps, weight, weight_unit, movement_id, training_session_id) FROM stdin;
1	MOTION	8	100	KILOGRAMS	1	1
2	MOTION	8	100	KILOGRAMS	1	1
3	MOTION	8	100	KILOGRAMS	1	1
4	MOTION	10	70	KILOGRAMS	2	1
5	MOTION	10	70	KILOGRAMS	2	1
6	MOTION	10	70	KILOGRAMS	2	1
7	MOTION	5	120	KILOGRAMS	3	1
8	MOTION	5	120	KILOGRAMS	3	1
9	MOTION	5	120	KILOGRAMS	3	1
10	MOTION	8	60	KILOGRAMS	3	4
11	MOTION	8	60	KILOGRAMS	3	4
12	MOTION	8	60	KILOGRAMS	4	4
13	MOTION	3	75	KILOGRAMS	3	5
14	MOTION	4	70	KILOGRAMS	3	5
15	MOTION	5	65	KILOGRAMS	4	5
\.


--
-- Data for Name: strength_exercise_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.strength_exercise_details (id, holding_down, holding_up, lowering, note, raising, reps_in_reserve, strength_exercise_id) FROM stdin;
1	0	1	2	Example note 1	1	3	1
2	0	1	2	Example note 2	1	3	2
3	0	1	2	Example note 	1	3	3
4	0	1	2	Example note 1	1	3	4
5	0	1	2	Example note 2	1	3	5
6	0	1	2	Example note 	1	3	6
7	0	1	2	Example note 1	1	3	7
8	0	1	2	Example note 2	1	3	8
9	0	1	2	Example note 	1	3	9
10	0	1	2	Example note 1	1	3	10
11	0	1	2	Example note 2	1	3	11
12	0	1	2	Example note 	1	3	12
\.


--
-- Data for Name: strength_record; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.strength_record (id, date, movement_name, repetition_unit, reps, weight, weight_unit, personal_records_id) FROM stdin;
1	2020-09-09	Squat	MOTION	1	190	KILOGRAMS	1
2	2020-07-09	Squat	MOTION	5	140	KILOGRAMS	1
3	2020-05-09	Bench press	MOTION	1	150	KILOGRAMS	1
4	2020-06-09	Bench press	MOTION	1	155	KILOGRAMS	2
\.


--
-- Data for Name: training_plan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_plan (id, description, difficulty, end_date, name, number_of_executed_trainings, number_of_planned_trainings, start_date, user_id) FROM stdin;
1	Strength training plan description	MEDIUM	2020-09-01	Strength v1	8	15	2020-07-01	1
2	Muscle mass training plan description	HARD	2020-02-01	Mass v1	20	20	2020-06-01	1
3	Power training plan description	EASY	2020-11-02	Power v1	0	9	2020-12-01	1
4	Clean and jerk training plan description	HARD	2020-12-05	Power v1	3	20	2020-12-30	2
5	Snatch training plan description	MEDIUM	2021-01-05	Power v1	2	23	2021-02-01	2
\.


--
-- Data for Name: training_session; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_session (id, date, day_of_week, difficulty, end_time, name, notes, start_time, training_duration, training_plan_id) FROM stdin;
1	2020-09-02	MONDAY	HARD	17:00:00	First strength training	Heavy squat and knee pain	14:30:00	02:30:00	1
2	2020-09-04	WEDNESDAY	EASY	18:00:00	Second strength training	Light squat and easy bench 	17:00:00	01:00:00	2
3	2020-09-06	FRIDAY	MEDIUM	19:00:00	Third strength training	Medium deadlift and accessories	17:30:00	01:30:00	3
4	2018-09-06	TUESDAY	HARD	19:00:00	Nth strength training	Clean and jerk max out and accessories	17:00:00	02:00:00	4
5	2021-09-06	THURSDAY	EASY	19:00:00	Nth + 1 strength training	Light squats for regeneration purposes	17:30:00	01:30:00	5
\.


--
-- Data for Name: user_details; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_details (id, age, body_weight_unit, height, height_unit, sex, weight, user_id) FROM stdin;
1	20	KILOGRAMS	1.83	METERS	MALE	93	1
2	30	KILOGRAMS	1.85	METERS	FEMALE	95	2
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, password, username) FROM stdin;
1	user@gmail.com	$2a$10$j3y4WrBpcBLAfir0W5C/6eUEfHwwV9LCN27Eg7libt7HURTirh4O.	usertest
2	trainingtest@gmail.com	$2a$10$KopU7tPDq.bZDxTIAWSdke1krzCxxoKq03kHHyhI/f7Sxfb/I.S36	trainingtest
\.


--
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (users_id, roles_id) FROM stdin;
1	2
2	1
\.


--
-- Name: custom_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.custom_record_id_seq', 1, false);


--
-- Name: endurance_exercise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endurance_exercise_id_seq', 1, false);


--
-- Name: endurance_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endurance_record_id_seq', 1, false);


--
-- Name: image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.image_id_seq', 1, false);


--
-- Name: key_technique_element_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.key_technique_element_id_seq', 1, false);


--
-- Name: movement_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movement_id_seq', 1, false);


--
-- Name: muscle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.muscle_id_seq', 1, false);


--
-- Name: personal_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personal_records_id_seq', 1, false);


--
-- Name: priority_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.priority_id_seq', 1, false);


--
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_id_seq', 1, false);


--
-- Name: strength_exercise_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.strength_exercise_details_id_seq', 1, false);


--
-- Name: strength_exercise_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.strength_exercise_id_seq', 1, false);


--
-- Name: strength_record_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.strength_record_id_seq', 1, false);


--
-- Name: training_plan_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.training_plan_id_seq', 1, false);


--
-- Name: training_session_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.training_session_id_seq', 1, false);


--
-- Name: user_details_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_details_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- Name: custom_record custom_record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_record
    ADD CONSTRAINT custom_record_pkey PRIMARY KEY (id);


--
-- Name: endurance_exercise endurance_exercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercise
    ADD CONSTRAINT endurance_exercise_pkey PRIMARY KEY (id);


--
-- Name: endurance_record endurance_record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_record
    ADD CONSTRAINT endurance_record_pkey PRIMARY KEY (id);


--
-- Name: image image_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT image_pkey PRIMARY KEY (id);


--
-- Name: key_technique_element key_technique_element_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_technique_element
    ADD CONSTRAINT key_technique_element_pkey PRIMARY KEY (id);


--
-- Name: movement movement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement
    ADD CONSTRAINT movement_pkey PRIMARY KEY (id);


--
-- Name: muscle muscle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscle
    ADD CONSTRAINT muscle_pkey PRIMARY KEY (id);


--
-- Name: personal_records personal_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records
    ADD CONSTRAINT personal_records_pkey PRIMARY KEY (id);


--
-- Name: priority priority_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.priority
    ADD CONSTRAINT priority_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: strength_exercise_details strength_exercise_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise_details
    ADD CONSTRAINT strength_exercise_details_pkey PRIMARY KEY (id);


--
-- Name: strength_exercise strength_exercise_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise
    ADD CONSTRAINT strength_exercise_pkey PRIMARY KEY (id);


--
-- Name: strength_record strength_record_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_record
    ADD CONSTRAINT strength_record_pkey PRIMARY KEY (id);


--
-- Name: training_plan training_plan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plan
    ADD CONSTRAINT training_plan_pkey PRIMARY KEY (id);


--
-- Name: training_session training_session_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_session
    ADD CONSTRAINT training_session_pkey PRIMARY KEY (id);


--
-- Name: user_details user_details_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT user_details_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users_roles fk15d410tj6juko0sq9k4km60xq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk15d410tj6juko0sq9k4km60xq FOREIGN KEY (roles_id) REFERENCES public.role(id);


--
-- Name: priority fk2x9x3bkeesstyhi9jb35gipfx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.priority
    ADD CONSTRAINT fk2x9x3bkeesstyhi9jb35gipfx FOREIGN KEY (training_plan_id) REFERENCES public.training_plan(id);


--
-- Name: endurance_record fk3re75a6xhcpeka03a583aqcap; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_record
    ADD CONSTRAINT fk3re75a6xhcpeka03a583aqcap FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: endurance_exercise fk78hq430g0uc29pjv1yya8bfiw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercise
    ADD CONSTRAINT fk78hq430g0uc29pjv1yya8bfiw FOREIGN KEY (training_session_id) REFERENCES public.training_session(id);


--
-- Name: image fk8pqdg1a2yefff3l7tsqw3quyf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT fk8pqdg1a2yefff3l7tsqw3quyf FOREIGN KEY (muscle_id) REFERENCES public.muscle(id);


--
-- Name: training_plan fkakdfy6q2i5e7jomdkfms446ds; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plan
    ADD CONSTRAINT fkakdfy6q2i5e7jomdkfms446ds FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: endurance_exercise fkcr0ywb8bm1fgnwinr9r4s9nxa; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercise
    ADD CONSTRAINT fkcr0ywb8bm1fgnwinr9r4s9nxa FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: image fkcvpnctgluno47ac6avana5sqf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT fkcvpnctgluno47ac6avana5sqf FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: strength_exercise fkddbk1424apr5581mac18csw92; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise
    ADD CONSTRAINT fkddbk1424apr5581mac18csw92 FOREIGN KEY (training_session_id) REFERENCES public.training_session(id);


--
-- Name: image fkf0boe6ktga3gn2mtwilv6o20l; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.image
    ADD CONSTRAINT fkf0boe6ktga3gn2mtwilv6o20l FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: personal_records fkfb734lyklj943i562usa54v10; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records
    ADD CONSTRAINT fkfb734lyklj943i562usa54v10 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: custom_record fkfi5kjatc0q5bir5xs5cgvqmuc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_record
    ADD CONSTRAINT fkfi5kjatc0q5bir5xs5cgvqmuc FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: strength_record fki075pkql41t3cxhy0tbkeghpm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_record
    ADD CONSTRAINT fki075pkql41t3cxhy0tbkeghpm FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: user_details fkicouhgavvmiiohc28mgk0kuj5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_details
    ADD CONSTRAINT fkicouhgavvmiiohc28mgk0kuj5 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: muscle fkiree3pmbhvlh9fgbepiyq5nmy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscle
    ADD CONSTRAINT fkiree3pmbhvlh9fgbepiyq5nmy FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: training_session fkitk9ihth9dk046e1wbebpxmc9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_session
    ADD CONSTRAINT fkitk9ihth9dk046e1wbebpxmc9 FOREIGN KEY (training_plan_id) REFERENCES public.training_plan(id);


--
-- Name: strength_exercise fkl1e5wmtpueme70kpq9jvnsidb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise
    ADD CONSTRAINT fkl1e5wmtpueme70kpq9jvnsidb FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: users_roles fkml90kef4w2jy7oxyqv742tsfc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- Name: key_technique_element fkr8flu6yyae6y73245vp771sg3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_technique_element
    ADD CONSTRAINT fkr8flu6yyae6y73245vp771sg3 FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: strength_exercise_details fktdhusfwcvpenqq95eb7g2rs2a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercise_details
    ADD CONSTRAINT fktdhusfwcvpenqq95eb7g2rs2a FOREIGN KEY (strength_exercise_id) REFERENCES public.strength_exercise(id);


--
-- PostgreSQL database dump complete
--

