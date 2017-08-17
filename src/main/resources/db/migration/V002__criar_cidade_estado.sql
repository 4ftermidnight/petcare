CREATE SEQUENCE estado_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.estado
(
  codigo bigint NOT NULL DEFAULT nextval('estado_codigo_seq'::regclass),
  nome character varying(50) NOT NULL,
  sigla character varying(2) NOT NULL,
  CONSTRAINT estado_pkey PRIMARY KEY (codigo)
);


CREATE SEQUENCE cidade_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.cidade
(
  codigo bigint NOT NULL DEFAULT nextval('cidade_codigo_seq'::regclass),
  nome character varying(255) NOT NULL,
  codigo_estado bigint,
  CONSTRAINT cidade_pkey PRIMARY KEY (codigo),
  CONSTRAINT fk_cidade_codigo_estado FOREIGN KEY (codigo_estado)
      REFERENCES public.estado (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);