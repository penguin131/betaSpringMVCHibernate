
BEGIN;

DO $$
    BEGIN
        IF (SELECT count(*) FROM pg_user WHERE usename='sammy')=0 THEN
            create user sammy
                superuser
                createdb
                createrole;
        END IF;
    END
$$;


DO $$
    BEGIN
        IF (SELECT count(*) FROM pg_user WHERE usename='postgres')=0 THEN
            create user postgres
                superuser
                createdb
                createrole
                replication
                bypassrls;
        END IF;
    END
$$;
commit;

--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0 (Debian 13.0-1.pgdg100+1)
-- Dumped by pg_dump version 13.0

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

--
-- Name: postgres; Type: DATABASE; Schema: -; Owner: sammy
--

ALTER DATABASE postgres OWNER TO sammy;

\connect postgres

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

--
-- Name: DATABASE postgres; Type: COMMENT; Schema: -; Owner: sammy
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: cinema; Type: SCHEMA; Schema: -; Owner: sammy
--

CREATE SCHEMA cinema;


ALTER SCHEMA cinema OWNER TO sammy;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: t_film; Type: TABLE; Schema: cinema; Owner: sammy
--

CREATE TABLE cinema.t_film (
                               film_id integer NOT NULL,
                               name character varying,
                               year integer,
                               min_age integer,
                               description character varying
);


ALTER TABLE cinema.t_film OWNER TO sammy;

--
-- Name: t_film_film_id_seq; Type: SEQUENCE; Schema: cinema; Owner: sammy
--

CREATE SEQUENCE cinema.t_film_film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cinema.t_film_film_id_seq OWNER TO sammy;

--
-- Name: t_film_film_id_seq; Type: SEQUENCE OWNED BY; Schema: cinema; Owner: sammy
--

ALTER SEQUENCE cinema.t_film_film_id_seq OWNED BY cinema.t_film.film_id;


--
-- Name: t_hall; Type: TABLE; Schema: cinema; Owner: sammy
--

CREATE TABLE cinema.t_hall (
                               hall_id integer NOT NULL,
                               number integer,
                               seats_count integer
);


ALTER TABLE cinema.t_hall OWNER TO sammy;

--
-- Name: t_hall_hall_id_seq; Type: SEQUENCE; Schema: cinema; Owner: sammy
--

CREATE SEQUENCE cinema.t_hall_hall_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cinema.t_hall_hall_id_seq OWNER TO sammy;

--
-- Name: t_hall_hall_id_seq; Type: SEQUENCE OWNED BY; Schema: cinema; Owner: sammy
--

ALTER SEQUENCE cinema.t_hall_hall_id_seq OWNED BY cinema.t_hall.hall_id;


--
-- Name: t_poster; Type: TABLE; Schema: cinema; Owner: sammy
--

CREATE TABLE cinema.t_poster (
                                 poster_id integer NOT NULL,
                                 film integer
);


ALTER TABLE cinema.t_poster OWNER TO sammy;

--
-- Name: t_poster_poster_id_seq; Type: SEQUENCE; Schema: cinema; Owner: sammy
--

CREATE SEQUENCE cinema.t_poster_poster_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cinema.t_poster_poster_id_seq OWNER TO sammy;

--
-- Name: t_poster_poster_id_seq; Type: SEQUENCE OWNED BY; Schema: cinema; Owner: sammy
--

ALTER SEQUENCE cinema.t_poster_poster_id_seq OWNED BY cinema.t_poster.poster_id;


--
-- Name: t_session; Type: TABLE; Schema: cinema; Owner: sammy
--

CREATE TABLE cinema.t_session (
                                  session_id integer NOT NULL,
                                  film integer,
                                  hall integer,
                                  cost numeric(8,2)
);


ALTER TABLE cinema.t_session OWNER TO sammy;

--
-- Name: t_session_session_id_seq; Type: SEQUENCE; Schema: cinema; Owner: sammy
--

CREATE SEQUENCE cinema.t_session_session_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cinema.t_session_session_id_seq OWNER TO sammy;

--
-- Name: t_session_session_id_seq; Type: SEQUENCE OWNED BY; Schema: cinema; Owner: sammy
--

ALTER SEQUENCE cinema.t_session_session_id_seq OWNED BY cinema.t_session.session_id;


--
-- Name: t_film film_id; Type: DEFAULT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_film ALTER COLUMN film_id SET DEFAULT nextval('cinema.t_film_film_id_seq'::regclass);


--
-- Name: t_hall hall_id; Type: DEFAULT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_hall ALTER COLUMN hall_id SET DEFAULT nextval('cinema.t_hall_hall_id_seq'::regclass);


--
-- Name: t_poster poster_id; Type: DEFAULT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_poster ALTER COLUMN poster_id SET DEFAULT nextval('cinema.t_poster_poster_id_seq'::regclass);


--
-- Name: t_session session_id; Type: DEFAULT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_session ALTER COLUMN session_id SET DEFAULT nextval('cinema.t_session_session_id_seq'::regclass);


--
-- Data for Name: t_film; Type: TABLE DATA; Schema: cinema; Owner: sammy
--



--
-- Data for Name: t_hall; Type: TABLE DATA; Schema: cinema; Owner: sammy
--



--
-- Data for Name: t_poster; Type: TABLE DATA; Schema: cinema; Owner: sammy
--



--
-- Data for Name: t_session; Type: TABLE DATA; Schema: cinema; Owner: sammy
--



--
-- Name: t_film_film_id_seq; Type: SEQUENCE SET; Schema: cinema; Owner: sammy
--

SELECT pg_catalog.setval('cinema.t_film_film_id_seq', 1, false);


--
-- Name: t_hall_hall_id_seq; Type: SEQUENCE SET; Schema: cinema; Owner: sammy
--

SELECT pg_catalog.setval('cinema.t_hall_hall_id_seq', 1, false);


--
-- Name: t_poster_poster_id_seq; Type: SEQUENCE SET; Schema: cinema; Owner: sammy
--

SELECT pg_catalog.setval('cinema.t_poster_poster_id_seq', 1, false);


--
-- Name: t_session_session_id_seq; Type: SEQUENCE SET; Schema: cinema; Owner: sammy
--

SELECT pg_catalog.setval('cinema.t_session_session_id_seq', 1, false);


--
-- Name: t_film t_film_pk; Type: CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_film
    ADD CONSTRAINT t_film_pk PRIMARY KEY (film_id);


--
-- Name: t_hall t_hall_pk; Type: CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_hall
    ADD CONSTRAINT t_hall_pk PRIMARY KEY (hall_id);


--
-- Name: t_poster t_poster_pk; Type: CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_poster
    ADD CONSTRAINT t_poster_pk PRIMARY KEY (poster_id);


--
-- Name: t_session t_session_pk; Type: CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_session
    ADD CONSTRAINT t_session_pk PRIMARY KEY (session_id);


--
-- Name: t_film_film_id_uindex; Type: INDEX; Schema: cinema; Owner: sammy
--

CREATE UNIQUE INDEX t_film_film_id_uindex ON cinema.t_film USING btree (film_id);


--
-- Name: t_hall_hall_id_uindex; Type: INDEX; Schema: cinema; Owner: sammy
--

CREATE UNIQUE INDEX t_hall_hall_id_uindex ON cinema.t_hall USING btree (hall_id);


--
-- Name: t_poster_poster_id_uindex; Type: INDEX; Schema: cinema; Owner: sammy
--

CREATE UNIQUE INDEX t_poster_poster_id_uindex ON cinema.t_poster USING btree (poster_id);


--
-- Name: t_session_session_id_uindex; Type: INDEX; Schema: cinema; Owner: sammy
--

CREATE UNIQUE INDEX t_session_session_id_uindex ON cinema.t_session USING btree (session_id);


--
-- Name: t_poster t_poster_t_film_film_id_fk; Type: FK CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_poster
    ADD CONSTRAINT t_poster_t_film_film_id_fk FOREIGN KEY (film) REFERENCES cinema.t_film(film_id);


--
-- Name: t_session t_session_t_film_film_id_fk; Type: FK CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_session
    ADD CONSTRAINT t_session_t_film_film_id_fk FOREIGN KEY (film) REFERENCES cinema.t_film(film_id);


--
-- Name: t_session t_session_t_hall_hall_id_fk; Type: FK CONSTRAINT; Schema: cinema; Owner: sammy
--

ALTER TABLE ONLY cinema.t_session
    ADD CONSTRAINT t_session_t_hall_hall_id_fk FOREIGN KEY (hall) REFERENCES cinema.t_hall(hall_id);


--
-- PostgreSQL database dump complete
--

