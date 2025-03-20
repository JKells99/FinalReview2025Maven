CREATE TABLE IF NOT EXISTS public.users
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    username character varying(50) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    role character varying(20) COLLATE pg_catalog."default" NOT NULL,
    sector character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT users_email_key UNIQUE (email),
    CONSTRAINT users_username_key UNIQUE (username),
    CONSTRAINT users_role_check CHECK (role::text = ANY (ARRAY['Commander'::character varying, 'Engineer'::character varying, 'Scientist'::character varying]::text[]))
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;

CREATE TABLE missions (
                          mission_id SERIAL PRIMARY KEY,
                          mission_name VARCHAR(100) NOT NULL,
                          mission_type VARCHAR(50) NOT NULL,
                          assigned_to_user_id INT REFERENCES users(user_id),
                          status VARCHAR(20) CHECK (status IN ('Pending', 'In Progress', 'Completed')) NOT NULL
);