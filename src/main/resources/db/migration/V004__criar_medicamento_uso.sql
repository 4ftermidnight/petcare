CREATE SEQUENCE medicamentouso_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.medicamentouso
(
  codigo bigint NOT NULL DEFAULT nextval('medicamentouso_codigo_seq'::regclass),
  data_registro date,
  motivo character varying(255) NOT NULL,
  nome character varying(255) NOT NULL,
  observacao character varying(255),
  codigo_animal bigint NOT NULL,
  CONSTRAINT medicamentouso_pkey PRIMARY KEY (codigo),
  CONSTRAINT fk_medicamentouso_animal FOREIGN KEY (codigo)
      REFERENCES public.animal (codigo) MATCH SIMPLE  ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_medicamentouso_codigo_animal FOREIGN KEY (codigo_animal)
      REFERENCES public.animal (codigo) MATCH SIMPLE  ON UPDATE NO ACTION ON DELETE NO ACTION
);