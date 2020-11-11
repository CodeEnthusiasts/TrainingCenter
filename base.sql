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
-- Name: custom_movement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.custom_movement (
    id bigint NOT NULL,
    user_id bigint
);


ALTER TABLE public.custom_movement OWNER TO postgres;

--
-- Name: custom_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.custom_records (
    id bigint NOT NULL,
    date date NOT NULL,
    description character varying(255) NOT NULL,
    value double precision NOT NULL
);


ALTER TABLE public.custom_records OWNER TO postgres;

--
-- Name: custom_records_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.custom_records_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.custom_records_id_seq OWNER TO postgres;

--
-- Name: custom_records_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.custom_records_id_seq OWNED BY public.custom_records.id;


--
-- Name: endurance_exercises; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endurance_exercises (
    id bigint NOT NULL,
    distance double precision NOT NULL,
    distance_unit character varying(255),
    duration time without time zone,
    heart_rate integer NOT NULL,
    vo2max_percentage integer NOT NULL,
    time_unit character varying(255),
    exercisable_id bigint,
    training_session_id bigint
);


ALTER TABLE public.endurance_exercises OWNER TO postgres;

--
-- Name: endurance_exercises_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endurance_exercises_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endurance_exercises_id_seq OWNER TO postgres;

--
-- Name: endurance_exercises_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endurance_exercises_id_seq OWNED BY public.endurance_exercises.id;


--
-- Name: endurance_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endurance_records (
    id bigint NOT NULL,
    date date,
    distance double precision NOT NULL,
    distance_unit character varying(255) NOT NULL,
    duration time without time zone NOT NULL,
    exercise_name character varying(255) NOT NULL,
    time_unit character varying(255) NOT NULL,
    CONSTRAINT endurance_records_distance_check CHECK (((distance <= (10000)::double precision) AND (distance >= (0)::double precision)))
);


ALTER TABLE public.endurance_records OWNER TO postgres;

--
-- Name: endurance_records_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endurance_records_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endurance_records_id_seq OWNER TO postgres;

--
-- Name: endurance_records_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endurance_records_id_seq OWNED BY public.endurance_records.id;


--
-- Name: exercisable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.exercisable (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.exercisable OWNER TO postgres;

--
-- Name: exercisable_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.exercisable_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.exercisable_id_seq OWNER TO postgres;

--
-- Name: exercisable_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.exercisable_id_seq OWNED BY public.exercisable.id;


--
-- Name: images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.images (
    id bigint NOT NULL,
    file_url character varying(255)
);


ALTER TABLE public.images OWNER TO postgres;

--
-- Name: images_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.images_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.images_id_seq OWNER TO postgres;

--
-- Name: images_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.images_id_seq OWNED BY public.images.id;


--
-- Name: key_technique_elements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_technique_elements (
    id bigint NOT NULL,
    content character varying(255),
    movement_id bigint
);


ALTER TABLE public.key_technique_elements OWNER TO postgres;

--
-- Name: key_technique_elements_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.key_technique_elements_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.key_technique_elements_id_seq OWNER TO postgres;

--
-- Name: key_technique_elements_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.key_technique_elements_id_seq OWNED BY public.key_technique_elements.id;


--
-- Name: movement; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movement (
    id bigint NOT NULL
);


ALTER TABLE public.movement OWNER TO postgres;

--
-- Name: movement_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movement_images (
    movement_id bigint NOT NULL,
    images_id bigint NOT NULL
);


ALTER TABLE public.movement_images OWNER TO postgres;

--
-- Name: movement_key_technique_elements; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movement_key_technique_elements (
    movement_id bigint NOT NULL,
    key_technique_elements_id bigint NOT NULL
);


ALTER TABLE public.movement_key_technique_elements OWNER TO postgres;

--
-- Name: movement_muscles_involved; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movement_muscles_involved (
    movement_id bigint NOT NULL,
    muscles_involved_id bigint NOT NULL
);


ALTER TABLE public.movement_muscles_involved OWNER TO postgres;

--
-- Name: muscles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.muscles (
    id bigint NOT NULL,
    description character varying(500),
    name character varying(48)
);


ALTER TABLE public.muscles OWNER TO postgres;

--
-- Name: muscles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.muscles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.muscles_id_seq OWNER TO postgres;

--
-- Name: muscles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.muscles_id_seq OWNED BY public.muscles.id;


--
-- Name: muscles_images; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.muscles_images (
    muscles_id bigint NOT NULL,
    images_id bigint NOT NULL
);


ALTER TABLE public.muscles_images OWNER TO postgres;

--
-- Name: pace; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pace (
    id bigint NOT NULL,
    holding_down integer NOT NULL,
    holding_up integer NOT NULL,
    lowering integer NOT NULL,
    name character varying(255),
    raising integer NOT NULL
);


ALTER TABLE public.pace OWNER TO postgres;

--
-- Name: pace_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pace_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pace_id_seq OWNER TO postgres;

--
-- Name: pace_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pace_id_seq OWNED BY public.pace.id;


--
-- Name: personal_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal_records (
    id bigint NOT NULL
);


ALTER TABLE public.personal_records OWNER TO postgres;

--
-- Name: personal_records_custom_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal_records_custom_records (
    personal_records_id bigint NOT NULL,
    custom_records_id bigint NOT NULL
);


ALTER TABLE public.personal_records_custom_records OWNER TO postgres;

--
-- Name: personal_records_endurance_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal_records_endurance_records (
    personal_records_id bigint NOT NULL,
    endurance_records_id bigint NOT NULL
);


ALTER TABLE public.personal_records_endurance_records OWNER TO postgres;

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
-- Name: personal_records_strength_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personal_records_strength_records (
    personal_records_id bigint NOT NULL,
    strength_records_id bigint NOT NULL
);


ALTER TABLE public.personal_records_strength_records OWNER TO postgres;

--
-- Name: priorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.priorities (
    id bigint NOT NULL,
    details character varying(255),
    name character varying(255)
);


ALTER TABLE public.priorities OWNER TO postgres;

--
-- Name: priorities_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.priorities_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.priorities_id_seq OWNER TO postgres;

--
-- Name: priorities_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.priorities_id_seq OWNED BY public.priorities.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: strength_exercises; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.strength_exercises (
    id bigint NOT NULL,
    repetition_unit character varying(255),
    reps integer NOT NULL,
    reps_in_reserve integer NOT NULL,
    weight integer NOT NULL,
    weight_unit character varying(255),
    exercisable_id bigint,
    training_session_id bigint,
    pace_id bigint
);


ALTER TABLE public.strength_exercises OWNER TO postgres;

--
-- Name: strength_exercises_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.strength_exercises_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.strength_exercises_id_seq OWNER TO postgres;

--
-- Name: strength_exercises_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.strength_exercises_id_seq OWNED BY public.strength_exercises.id;


--
-- Name: strength_records; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.strength_records (
    id bigint NOT NULL,
    date date,
    exercise_name character varying(255) NOT NULL,
    repetition_unit character varying(255) NOT NULL,
    reps integer NOT NULL,
    weight integer NOT NULL,
    weight_unit character varying(255) NOT NULL,
    CONSTRAINT strength_records_reps_check CHECK (((reps <= 1000) AND (reps >= 0))),
    CONSTRAINT strength_records_weight_check CHECK (((weight >= '-30'::integer) AND (weight <= 500)))
);


ALTER TABLE public.strength_records OWNER TO postgres;

--
-- Name: strength_records_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.strength_records_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.strength_records_id_seq OWNER TO postgres;

--
-- Name: strength_records_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.strength_records_id_seq OWNED BY public.strength_records.id;


--
-- Name: training_plans; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_plans (
    id bigint NOT NULL,
    description character varying(255),
    difficulty character varying(255),
    end_date date,
    name character varying(255),
    number_of_executed_trainings integer NOT NULL,
    number_of_planned_trainings integer NOT NULL,
    start_date date,
    user_id bigint
);


ALTER TABLE public.training_plans OWNER TO postgres;

--
-- Name: training_plans_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.training_plans_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.training_plans_id_seq OWNER TO postgres;

--
-- Name: training_plans_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.training_plans_id_seq OWNED BY public.training_plans.id;


--
-- Name: training_plans_priorities; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_plans_priorities (
    training_plans_id bigint NOT NULL,
    priorities_id bigint NOT NULL
);


ALTER TABLE public.training_plans_priorities OWNER TO postgres;

--
-- Name: training_plans_training_sessions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_plans_training_sessions (
    training_plans_id bigint NOT NULL,
    training_sessions_id bigint NOT NULL
);


ALTER TABLE public.training_plans_training_sessions OWNER TO postgres;

--
-- Name: training_sessions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_sessions (
    id bigint NOT NULL,
    date date,
    day_of_week character varying(255),
    difficulty character varying(255),
    end_time time without time zone,
    name character varying(255),
    notes character varying(255),
    start_time time without time zone,
    training_duration time without time zone
);


ALTER TABLE public.training_sessions OWNER TO postgres;

--
-- Name: training_sessions_endurance_exercises; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_sessions_endurance_exercises (
    training_sessions_id bigint NOT NULL,
    endurance_exercises_id bigint NOT NULL
);


ALTER TABLE public.training_sessions_endurance_exercises OWNER TO postgres;

--
-- Name: training_sessions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.training_sessions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.training_sessions_id_seq OWNER TO postgres;

--
-- Name: training_sessions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.training_sessions_id_seq OWNED BY public.training_sessions.id;


--
-- Name: training_sessions_strength_exercises; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.training_sessions_strength_exercises (
    training_sessions_id bigint NOT NULL,
    strength_exercises_id bigint NOT NULL
);


ALTER TABLE public.training_sessions_strength_exercises OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    email character varying(255),
    password character varying(255),
    age integer NOT NULL,
    body_weight_unit character varying(255),
    height double precision NOT NULL,
    height_unit character varying(255),
    sex character varying(255),
    weight double precision NOT NULL,
    username character varying(255),
    image_id bigint,
    personal_records_id bigint
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
-- Name: custom_records id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_records ALTER COLUMN id SET DEFAULT nextval('public.custom_records_id_seq'::regclass);


--
-- Name: endurance_exercises id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercises ALTER COLUMN id SET DEFAULT nextval('public.endurance_exercises_id_seq'::regclass);


--
-- Name: endurance_records id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_records ALTER COLUMN id SET DEFAULT nextval('public.endurance_records_id_seq'::regclass);


--
-- Name: exercisable id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercisable ALTER COLUMN id SET DEFAULT nextval('public.exercisable_id_seq'::regclass);


--
-- Name: images id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images ALTER COLUMN id SET DEFAULT nextval('public.images_id_seq'::regclass);


--
-- Name: key_technique_elements id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_technique_elements ALTER COLUMN id SET DEFAULT nextval('public.key_technique_elements_id_seq'::regclass);


--
-- Name: muscles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscles ALTER COLUMN id SET DEFAULT nextval('public.muscles_id_seq'::regclass);


--
-- Name: pace id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pace ALTER COLUMN id SET DEFAULT nextval('public.pace_id_seq'::regclass);


--
-- Name: personal_records id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records ALTER COLUMN id SET DEFAULT nextval('public.personal_records_id_seq'::regclass);


--
-- Name: priorities id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.priorities ALTER COLUMN id SET DEFAULT nextval('public.priorities_id_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: strength_exercises id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercises ALTER COLUMN id SET DEFAULT nextval('public.strength_exercises_id_seq'::regclass);


--
-- Name: strength_records id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_records ALTER COLUMN id SET DEFAULT nextval('public.strength_records_id_seq'::regclass);


--
-- Name: training_plans id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans ALTER COLUMN id SET DEFAULT nextval('public.training_plans_id_seq'::regclass);


--
-- Name: training_sessions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions ALTER COLUMN id SET DEFAULT nextval('public.training_sessions_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: custom_movement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.custom_movement (id, user_id) FROM stdin;
\.


--
-- Data for Name: custom_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.custom_records (id, date, description, value) FROM stdin;
1	2020-10-10	Vertical jump	0.8
2	2020-03-03	Drive 100km on bike	100
\.


--
-- Data for Name: endurance_exercises; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endurance_exercises (id, distance, distance_unit, duration, heart_rate, vo2max_percentage, time_unit, exercisable_id, training_session_id) FROM stdin;
1	2	KILOMETERS	00:15:00	130	70	MINUTES	6	2
2	2	KILOMETERS	00:10:00	150	80	MINUTES	6	2
3	1	KILOMETERS	00:05:00	170	90	MINUTES	6	2
\.


--
-- Data for Name: endurance_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endurance_records (id, date, distance, distance_unit, duration, exercise_name, time_unit) FROM stdin;
1	2020-05-09	1	KILOMETERS	00:03:00	Running	HOURS
2	2020-07-09	5	KILOMETERS	00:28:00	Running	HOURS
3	2021-05-09	100	METERS	00:10:00	Swimming	HOURS
\.


--
-- Data for Name: exercisable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.exercisable (id, name) FROM stdin;
1	Squat
2	Bench Press
3	Dead lift
4	Pull Up
5	Overhead Press
6	Run outdoor
\.


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.images (id, file_url) FROM stdin;
1	https://res.cloudinary.com/dr6odau4r/image/upload/v1604332186/gxiql7mxiykikz1f5rej.jpg
2	https://res.cloudinary.com/dr6odau4r/image/upload/v1604387417/qbu1rpql12lszfyey15u.jpg
3	https://res.cloudinary.com/dr6odau4r/image/upload/v1594185873/sample.jpg
4	https://squatuniversity.com/wp-content/uploads/2016/02/859835_577024942352334_10881976_o.jpg
5	https://barbend.com/wp-content/uploads/2019/04/Bench-Press-Plateau-1024x538.jpg
6	https://barbend.com/wp-content/uploads/2016/11/floating-clean-pull.png
7	https://www.yogajournal.com/.image/t_share/MTQ2ODMwNzA2OTE4NTY1NjA5/juneanatomy.jpg
8	https://www.performancehealth.com/media/wysiwyg/blog/articles/Hamstring-quadriceps_3.PNG
9	https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQvd9IRdgVMu8sf0J0E_sQG4jYcvuZLFludzw&usqp=CAU
\.


--
-- Data for Name: key_technique_elements; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_technique_elements (id, content, movement_id) FROM stdin;
1	Keep chest up	\N
2	Plain foot, weight on the middle	\N
3	Pull shoulder blades together	\N
4	Elbow under the bar	\N
5	Kepp air pressure in diapragma	\N
6	Push legs to the floow	\N
\.


--
-- Data for Name: movement; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movement (id) FROM stdin;
1
2
3
4
5
\.


--
-- Data for Name: movement_images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movement_images (movement_id, images_id) FROM stdin;
1	4
2	5
3	6
\.


--
-- Data for Name: movement_key_technique_elements; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movement_key_technique_elements (movement_id, key_technique_elements_id) FROM stdin;
1	1
1	2
2	3
2	4
3	5
3	6
\.


--
-- Data for Name: movement_muscles_involved; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movement_muscles_involved (movement_id, muscles_involved_id) FROM stdin;
1	1
2	2
3	3
4	4
5	5
\.


--
-- Data for Name: muscles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.muscles (id, description, name) FROM stdin;
1	Biggest Human Muscle	Glute
2	Primary knee extensor	Quad
3	Sign of Arnold, big muscle in front of  	Peck
4	Small, but fameous muscle	Biceps
5	Long, tought muscles on the back thigh	Hamsting
6	Very important to stabilization of whole arm	Shoulder
\.


--
-- Data for Name: muscles_images; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.muscles_images (muscles_id, images_id) FROM stdin;
1	7
2	8
3	9
\.


--
-- Data for Name: pace; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pace (id, holding_down, holding_up, lowering, name, raising) FROM stdin;
1	0	1	1	Fast	1
2	2	1	1	Short pause	1
3	0	1	3	Long eccentric phase	1
4	3	1	2	Long eccentric and pause	1
5	2	1	0	Fast and short pause	1
\.


--
-- Data for Name: personal_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal_records (id) FROM stdin;
1
2
3
\.


--
-- Data for Name: personal_records_custom_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal_records_custom_records (personal_records_id, custom_records_id) FROM stdin;
1	1
1	2
\.


--
-- Data for Name: personal_records_endurance_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal_records_endurance_records (personal_records_id, endurance_records_id) FROM stdin;
1	1
1	2
1	3
\.


--
-- Data for Name: personal_records_strength_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.personal_records_strength_records (personal_records_id, strength_records_id) FROM stdin;
1	1
1	2
1	3
\.


--
-- Data for Name: priorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.priorities (id, details, name) FROM stdin;
1	Lower chest is the weakest part - need to work on it	Lower chest growth
2	Quad is very irresistible to higher reps - needs to get better before strength phase	Develop quad endurance
3	Right scapulae is unstable and destroy whole movement trajectory	Improve bench stability
4	In order to beat 200kg barrier, need to be on 180 in strength phase at least	Gain 10kg + in squat
5	This will improve power generation ability for sure	Beat the record in clean and jerk - + 132.5kg
6	Rest them to heal tendinitis	Heal injured elbow
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
1	ROLE_USER
2	ROLE_ADMIN
3	ROLE_MODERATOR
\.


--
-- Data for Name: strength_exercises; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.strength_exercises (id, repetition_unit, reps, reps_in_reserve, weight, weight_unit, exercisable_id, training_session_id, pace_id) FROM stdin;
1	MOTION	8	3	100	KILOGRAMS	1	1	1
2	MOTION	8	2	100	KILOGRAMS	1	1	1
3	MOTION	8	1	100	KILOGRAMS	1	1	1
4	MOTION	10	2	70	KILOGRAMS	2	1	2
5	MOTION	10	2	70	KILOGRAMS	2	1	2
6	MOTION	10	2	70	KILOGRAMS	2	1	2
7	MOTION	5	4	120	KILOGRAMS	3	1	3
8	MOTION	5	4	120	KILOGRAMS	3	1	3
9	MOTION	5	4	120	KILOGRAMS	3	1	3
\.


--
-- Data for Name: strength_records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.strength_records (id, date, exercise_name, repetition_unit, reps, weight, weight_unit) FROM stdin;
1	2020-09-09	Squat	MOTION	1	190	KILOGRAMS
2	2020-07-09	Squat	MOTION	5	140	KILOGRAMS
3	2020-05-09	Bench press	MOTION	1	150	KILOGRAMS
\.


--
-- Data for Name: training_plans; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_plans (id, description, difficulty, end_date, name, number_of_executed_trainings, number_of_planned_trainings, start_date, user_id) FROM stdin;
1	Strength training plan description	MEDIUM	2020-09-01	Strength v1	8	15	2020-07-01	1
2	Muscle mass training plan description	HARD	2020-02-01	Mass v1	20	20	2020-06-01	1
3	Power training plan description	EASY	2020-11-02	Power v1	0	9	2020-12-01	1
\.


--
-- Data for Name: training_plans_priorities; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_plans_priorities (training_plans_id, priorities_id) FROM stdin;
1	1
1	2
2	3
2	4
3	5
3	6
\.


--
-- Data for Name: training_plans_training_sessions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_plans_training_sessions (training_plans_id, training_sessions_id) FROM stdin;
1	1
1	2
1	3
\.


--
-- Data for Name: training_sessions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_sessions (id, date, day_of_week, difficulty, end_time, name, notes, start_time, training_duration) FROM stdin;
1	2020-09-02	MONDAY	HARD	17:00:00	First strength training	Heavy squat and knee pain	14:30:00	02:30:00
2	2020-09-04	WEDNESDAY	EASY	18:00:00	Second strength training	Light squat and easy bench 	17:00:00	01:00:00
3	2020-09-06	FRIDAY	MEDIUM	19:00:00	Third strength training	Medium deadlift and accessories	17:30:00	01:30:00
\.


--
-- Data for Name: training_sessions_endurance_exercises; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_sessions_endurance_exercises (training_sessions_id, endurance_exercises_id) FROM stdin;
2	1
2	2
2	3
\.


--
-- Data for Name: training_sessions_strength_exercises; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.training_sessions_strength_exercises (training_sessions_id, strength_exercises_id) FROM stdin;
1	1
1	2
1	3
1	4
1	5
1	6
1	7
1	8
1	9
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, password, age, body_weight_unit, height, height_unit, sex, weight, username, image_id, personal_records_id) FROM stdin;
1	user@gmail.com	$2a$10$j3y4WrBpcBLAfir0W5C/6eUEfHwwV9LCN27Eg7libt7HURTirh4O.	20	KILOGRAMS	183	METERS	MALE	93	usertest	1	1
\.


--
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users_roles (users_id, roles_id) FROM stdin;
1	1
\.


--
-- Name: custom_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.custom_records_id_seq', 1, false);


--
-- Name: endurance_exercises_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endurance_exercises_id_seq', 1, false);


--
-- Name: endurance_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endurance_records_id_seq', 1, false);


--
-- Name: exercisable_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.exercisable_id_seq', 1, false);


--
-- Name: images_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.images_id_seq', 1, false);


--
-- Name: key_technique_elements_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.key_technique_elements_id_seq', 1, false);


--
-- Name: muscles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.muscles_id_seq', 1, false);


--
-- Name: pace_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pace_id_seq', 1, false);


--
-- Name: personal_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.personal_records_id_seq', 1, false);


--
-- Name: priorities_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.priorities_id_seq', 1, false);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 1, false);


--
-- Name: strength_exercises_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.strength_exercises_id_seq', 1, false);


--
-- Name: strength_records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.strength_records_id_seq', 1, false);


--
-- Name: training_plans_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.training_plans_id_seq', 1, false);


--
-- Name: training_sessions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.training_sessions_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 1, false);


--
-- Name: custom_movement custom_movement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_movement
    ADD CONSTRAINT custom_movement_pkey PRIMARY KEY (id);


--
-- Name: custom_records custom_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_records
    ADD CONSTRAINT custom_records_pkey PRIMARY KEY (id);


--
-- Name: endurance_exercises endurance_exercises_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercises
    ADD CONSTRAINT endurance_exercises_pkey PRIMARY KEY (id);


--
-- Name: endurance_records endurance_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_records
    ADD CONSTRAINT endurance_records_pkey PRIMARY KEY (id);


--
-- Name: exercisable exercisable_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.exercisable
    ADD CONSTRAINT exercisable_pkey PRIMARY KEY (id);


--
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.images
    ADD CONSTRAINT images_pkey PRIMARY KEY (id);


--
-- Name: key_technique_elements key_technique_elements_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_technique_elements
    ADD CONSTRAINT key_technique_elements_pkey PRIMARY KEY (id);


--
-- Name: movement movement_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement
    ADD CONSTRAINT movement_pkey PRIMARY KEY (id);


--
-- Name: muscles muscles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscles
    ADD CONSTRAINT muscles_pkey PRIMARY KEY (id);


--
-- Name: pace pace_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pace
    ADD CONSTRAINT pace_pkey PRIMARY KEY (id);


--
-- Name: personal_records personal_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records
    ADD CONSTRAINT personal_records_pkey PRIMARY KEY (id);


--
-- Name: priorities priorities_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.priorities
    ADD CONSTRAINT priorities_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: strength_exercises strength_exercises_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercises
    ADD CONSTRAINT strength_exercises_pkey PRIMARY KEY (id);


--
-- Name: strength_records strength_records_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_records
    ADD CONSTRAINT strength_records_pkey PRIMARY KEY (id);


--
-- Name: training_plans training_plans_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans
    ADD CONSTRAINT training_plans_pkey PRIMARY KEY (id);


--
-- Name: training_sessions training_sessions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions
    ADD CONSTRAINT training_sessions_pkey PRIMARY KEY (id);


--
-- Name: training_sessions_endurance_exercises uk_bvv5axefxuu5cvk2kh25n9rb0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions_endurance_exercises
    ADD CONSTRAINT uk_bvv5axefxuu5cvk2kh25n9rb0 UNIQUE (endurance_exercises_id);


--
-- Name: personal_records_endurance_records uk_c15jgev6gpshpeljc4rti7u9y; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_endurance_records
    ADD CONSTRAINT uk_c15jgev6gpshpeljc4rti7u9y UNIQUE (endurance_records_id);


--
-- Name: personal_records_strength_records uk_dcpev2xyjnr4kgtkyutqth5pj; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_strength_records
    ADD CONSTRAINT uk_dcpev2xyjnr4kgtkyutqth5pj UNIQUE (strength_records_id);


--
-- Name: training_sessions_strength_exercises uk_e1hh5uorvmckto2hnpxwexktm; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions_strength_exercises
    ADD CONSTRAINT uk_e1hh5uorvmckto2hnpxwexktm UNIQUE (strength_exercises_id);


--
-- Name: movement_key_technique_elements uk_f89do1634scw313e9oddscy9m; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_key_technique_elements
    ADD CONSTRAINT uk_f89do1634scw313e9oddscy9m UNIQUE (key_technique_elements_id);


--
-- Name: personal_records_custom_records uk_fsoaao1bhbt72t5a88dhmappe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_custom_records
    ADD CONSTRAINT uk_fsoaao1bhbt72t5a88dhmappe UNIQUE (custom_records_id);


--
-- Name: movement_muscles_involved uk_jteyisto1j8et0rqc2qlujunn; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_muscles_involved
    ADD CONSTRAINT uk_jteyisto1j8et0rqc2qlujunn UNIQUE (muscles_involved_id);


--
-- Name: muscles_images uk_n2ftnrq4ca7pphts5kgsf9tvw; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscles_images
    ADD CONSTRAINT uk_n2ftnrq4ca7pphts5kgsf9tvw UNIQUE (images_id);


--
-- Name: training_plans_priorities uk_rgrmsbbldyfxfm46yg0l6jwym; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans_priorities
    ADD CONSTRAINT uk_rgrmsbbldyfxfm46yg0l6jwym UNIQUE (priorities_id);


--
-- Name: training_plans_training_sessions uk_seuexe1r9g79ehgi5i3eekpux; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans_training_sessions
    ADD CONSTRAINT uk_seuexe1r9g79ehgi5i3eekpux UNIQUE (training_sessions_id);


--
-- Name: movement_images uk_sp2u6xt4mck88mq6bf8o4yh3; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_images
    ADD CONSTRAINT uk_sp2u6xt4mck88mq6bf8o4yh3 UNIQUE (images_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: users fk17herqt2to4hyl5q5r5ogbxk9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk17herqt2to4hyl5q5r5ogbxk9 FOREIGN KEY (image_id) REFERENCES public.images(id);


--
-- Name: movement_muscles_involved fk2c9v7wiv6up9mc0i8xobn9m53; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_muscles_involved
    ADD CONSTRAINT fk2c9v7wiv6up9mc0i8xobn9m53 FOREIGN KEY (muscles_involved_id) REFERENCES public.muscles(id);


--
-- Name: endurance_exercises fk4ebhwmq4cp74wubpmqt74uh4b; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercises
    ADD CONSTRAINT fk4ebhwmq4cp74wubpmqt74uh4b FOREIGN KEY (exercisable_id) REFERENCES public.exercisable(id);


--
-- Name: personal_records_custom_records fk4vf4qw0hrdnolb01pvo80wc0w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_custom_records
    ADD CONSTRAINT fk4vf4qw0hrdnolb01pvo80wc0w FOREIGN KEY (custom_records_id) REFERENCES public.custom_records(id);


--
-- Name: movement_key_technique_elements fk5830tt7v5bx30cppu8a080g5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_key_technique_elements
    ADD CONSTRAINT fk5830tt7v5bx30cppu8a080g5 FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: training_sessions_strength_exercises fk5vmglryid7sqq7dmu6h9xruyl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions_strength_exercises
    ADD CONSTRAINT fk5vmglryid7sqq7dmu6h9xruyl FOREIGN KEY (training_sessions_id) REFERENCES public.training_sessions(id);


--
-- Name: personal_records_custom_records fk5yfja5s079e52o76rhfa5b6hw; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_custom_records
    ADD CONSTRAINT fk5yfja5s079e52o76rhfa5b6hw FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: movement_images fk7d4ws0de6t6isjx7ikx1cwodc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_images
    ADD CONSTRAINT fk7d4ws0de6t6isjx7ikx1cwodc FOREIGN KEY (images_id) REFERENCES public.images(id);


--
-- Name: users_roles fka62j07k5mhgifpp955h37ponj; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fka62j07k5mhgifpp955h37ponj FOREIGN KEY (roles_id) REFERENCES public.roles(id);


--
-- Name: personal_records_strength_records fkal7skhkvx9nbilwwtxubg97uk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_strength_records
    ADD CONSTRAINT fkal7skhkvx9nbilwwtxubg97uk FOREIGN KEY (strength_records_id) REFERENCES public.strength_records(id);


--
-- Name: training_plans_priorities fkaqplj65dvjg37a31j5cm8o7eh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans_priorities
    ADD CONSTRAINT fkaqplj65dvjg37a31j5cm8o7eh FOREIGN KEY (priorities_id) REFERENCES public.priorities(id);


--
-- Name: movement fkbrmnnoxmrir43cdtba799o9l7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement
    ADD CONSTRAINT fkbrmnnoxmrir43cdtba799o9l7 FOREIGN KEY (id) REFERENCES public.exercisable(id);


--
-- Name: custom_movement fkbtgh00k33v08e35th80rplm9v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_movement
    ADD CONSTRAINT fkbtgh00k33v08e35th80rplm9v FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: training_sessions_endurance_exercises fkd6e88n8sufue7w7aguljokrxi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions_endurance_exercises
    ADD CONSTRAINT fkd6e88n8sufue7w7aguljokrxi FOREIGN KEY (endurance_exercises_id) REFERENCES public.endurance_exercises(id);


--
-- Name: users fke5tv2vyqqm11m46c2agrd5i14; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fke5tv2vyqqm11m46c2agrd5i14 FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: personal_records_strength_records fkf0mt23woxrhwo523wxy6702f3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_strength_records
    ADD CONSTRAINT fkf0mt23woxrhwo523wxy6702f3 FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: key_technique_elements fkfl7s3wulk5m7sa9vlf4vtpx8j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_technique_elements
    ADD CONSTRAINT fkfl7s3wulk5m7sa9vlf4vtpx8j FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: training_plans fkfmh2q5ujep9t2ysd9eh75mto2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans
    ADD CONSTRAINT fkfmh2q5ujep9t2ysd9eh75mto2 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: training_sessions_endurance_exercises fki22ftqunc4mpvjniaxrsqdr6u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions_endurance_exercises
    ADD CONSTRAINT fki22ftqunc4mpvjniaxrsqdr6u FOREIGN KEY (training_sessions_id) REFERENCES public.training_sessions(id);


--
-- Name: endurance_exercises fki4t0vthme1cm0ad4qy83jmiyh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endurance_exercises
    ADD CONSTRAINT fki4t0vthme1cm0ad4qy83jmiyh FOREIGN KEY (training_session_id) REFERENCES public.training_sessions(id);


--
-- Name: muscles_images fkid756aomggthxji6kije0ooyq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscles_images
    ADD CONSTRAINT fkid756aomggthxji6kije0ooyq FOREIGN KEY (muscles_id) REFERENCES public.muscles(id);


--
-- Name: strength_exercises fkjaaxg2kp0j9tyo28xjj7btnl0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercises
    ADD CONSTRAINT fkjaaxg2kp0j9tyo28xjj7btnl0 FOREIGN KEY (exercisable_id) REFERENCES public.exercisable(id);


--
-- Name: personal_records_endurance_records fkjo7i8if4qn9cljon9fle6w2mo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_endurance_records
    ADD CONSTRAINT fkjo7i8if4qn9cljon9fle6w2mo FOREIGN KEY (personal_records_id) REFERENCES public.personal_records(id);


--
-- Name: personal_records_endurance_records fkl7ajgcpbkprx90wfuf8gyy2nm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personal_records_endurance_records
    ADD CONSTRAINT fkl7ajgcpbkprx90wfuf8gyy2nm FOREIGN KEY (endurance_records_id) REFERENCES public.endurance_records(id);


--
-- Name: training_plans_training_sessions fklyr4lfsnalww85tvs2mhfrade; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans_training_sessions
    ADD CONSTRAINT fklyr4lfsnalww85tvs2mhfrade FOREIGN KEY (training_sessions_id) REFERENCES public.training_sessions(id);


--
-- Name: movement_key_technique_elements fkmbv4e965ge96x2efqaaom5yhl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_key_technique_elements
    ADD CONSTRAINT fkmbv4e965ge96x2efqaaom5yhl FOREIGN KEY (key_technique_elements_id) REFERENCES public.key_technique_elements(id);


--
-- Name: users_roles fkml90kef4w2jy7oxyqv742tsfc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkml90kef4w2jy7oxyqv742tsfc FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- Name: custom_movement fkouadishyb16c9wlejt4bpsdcl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.custom_movement
    ADD CONSTRAINT fkouadishyb16c9wlejt4bpsdcl FOREIGN KEY (id) REFERENCES public.exercisable(id);


--
-- Name: muscles_images fkppb7mo72tuvg5hppq8nstlts3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.muscles_images
    ADD CONSTRAINT fkppb7mo72tuvg5hppq8nstlts3 FOREIGN KEY (images_id) REFERENCES public.images(id);


--
-- Name: movement_images fkqmtk3h30jqwljjcte260bkku3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_images
    ADD CONSTRAINT fkqmtk3h30jqwljjcte260bkku3 FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- Name: strength_exercises fkqwe3se4ku3s0hjj8y6m05b9r5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercises
    ADD CONSTRAINT fkqwe3se4ku3s0hjj8y6m05b9r5 FOREIGN KEY (pace_id) REFERENCES public.pace(id);


--
-- Name: training_plans_priorities fkr5es05xisi2dgdbxnxawxevli; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans_priorities
    ADD CONSTRAINT fkr5es05xisi2dgdbxnxawxevli FOREIGN KEY (training_plans_id) REFERENCES public.training_plans(id);


--
-- Name: training_sessions_strength_exercises fkr8jds992x1u3oaiiwygwa7ikq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_sessions_strength_exercises
    ADD CONSTRAINT fkr8jds992x1u3oaiiwygwa7ikq FOREIGN KEY (strength_exercises_id) REFERENCES public.strength_exercises(id);


--
-- Name: strength_exercises fkrkqkyvf3xh9frc3qegxyavro8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.strength_exercises
    ADD CONSTRAINT fkrkqkyvf3xh9frc3qegxyavro8 FOREIGN KEY (training_session_id) REFERENCES public.training_sessions(id);


--
-- Name: training_plans_training_sessions fkrtsqjdb9l60lk43qmkgt74efl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.training_plans_training_sessions
    ADD CONSTRAINT fkrtsqjdb9l60lk43qmkgt74efl FOREIGN KEY (training_plans_id) REFERENCES public.training_plans(id);


--
-- Name: movement_muscles_involved fkt3na1q7cl43316m5b07yey7oc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movement_muscles_involved
    ADD CONSTRAINT fkt3na1q7cl43316m5b07yey7oc FOREIGN KEY (movement_id) REFERENCES public.movement(id);


--
-- PostgreSQL database dump complete
--

