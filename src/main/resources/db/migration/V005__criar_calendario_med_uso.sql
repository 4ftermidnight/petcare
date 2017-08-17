CREATE SEQUENCE calendario_med_uso_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.calendario_med_uso
(
  codigo bigint NOT NULL DEFAULT nextval('calendario_med_uso_codigo_seq'::regclass),
  administrado boolean,
  data_uso date,
  codigo_med_uso bigint NOT NULL,
  CONSTRAINT calendario_med_uso_pkey PRIMARY KEY (codigo),
  CONSTRAINT fk1naulm96132fi881letc6mulb FOREIGN KEY (codigo)
      REFERENCES public.medicamentouso (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkaxci837fbwo0038kvhdc75xnp FOREIGN KEY (codigo_med_uso)
      REFERENCES public.medicamentouso (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
)