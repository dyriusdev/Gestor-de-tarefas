--
-- PostgreSQL database dump
--

-- Dumped from database version 16.9 (Ubuntu 16.9-0ubuntu0.24.04.1)
-- Dumped by pg_dump version 16.9 (Ubuntu 16.9-0ubuntu0.24.04.1)

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
-- Name: funcionarios; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.funcionarios (
    id integer NOT NULL,
    nome character varying(50)
);


ALTER TABLE public.funcionarios OWNER TO root;

--
-- Name: funcionarios_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.funcionarios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.funcionarios_id_seq OWNER TO root;

--
-- Name: funcionarios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.funcionarios_id_seq OWNED BY public.funcionarios.id;


--
-- Name: tarefas; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.tarefas (
    id integer NOT NULL,
    titulo character varying(50) NOT NULL,
    descricao text NOT NULL,
    responsavel character varying(50),
    prioridade integer NOT NULL,
    deadline date
);


ALTER TABLE public.tarefas OWNER TO root;

--
-- Name: tarefas_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

CREATE SEQUENCE public.tarefas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tarefas_id_seq OWNER TO root;

--
-- Name: tarefas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: root
--

ALTER SEQUENCE public.tarefas_id_seq OWNED BY public.tarefas.id;


--
-- Name: funcionarios id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.funcionarios ALTER COLUMN id SET DEFAULT nextval('public.funcionarios_id_seq'::regclass);


--
-- Name: tarefas id; Type: DEFAULT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tarefas ALTER COLUMN id SET DEFAULT nextval('public.tarefas_id_seq'::regclass);


--
-- Data for Name: funcionarios; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.funcionarios (id, nome) FROM stdin;
1	Funcionario 1
2	Funcionario 2
3	Funcionario 3
\.


--
-- Data for Name: tarefas; Type: TABLE DATA; Schema: public; Owner: root
--

COPY public.tarefas (id, titulo, descricao, responsavel, prioridade, deadline) FROM stdin;
5	teste 2	segundo teste de cadastro	Funcionario 1	1	2025-05-21
6	teste 3	terceiro teste de cadastro	Funcionario 1	2	2025-05-21
4	teste 1 alteração 2	primeiro teste de cadastro e alteração	Funcionario 1	0	2025-05-21
\.


--
-- Name: funcionarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.funcionarios_id_seq', 3, true);


--
-- Name: tarefas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.tarefas_id_seq', 6, true);


--
-- Name: funcionarios funcionarios_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.funcionarios
    ADD CONSTRAINT funcionarios_pkey PRIMARY KEY (id);


--
-- Name: tarefas tarefas_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tarefas
    ADD CONSTRAINT tarefas_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

