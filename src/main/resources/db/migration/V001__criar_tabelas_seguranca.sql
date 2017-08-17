CREATE SEQUENCE usuario_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.usuario
(
  codigo bigint NOT NULL DEFAULT nextval('usuario_codigo_seq'::regclass),
  ativo boolean,
  data_nascimento date,
  email character varying(255) NOT NULL,
  nome character varying(255) NOT NULL,
  senha character varying(255),
  CONSTRAINT usuario_pkey PRIMARY KEY (codigo)
  );

    
CREATE SEQUENCE grupo_codigo_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	NO MAXVALUE
	CACHE 1;

CREATE TABLE public.grupo
(
  codigo bigint NOT NULL DEFAULT nextval('grupo_codigo_seq'::regclass),
  nome character varying(255),
  CONSTRAINT grupo_pkey PRIMARY KEY (codigo)
);

CREATE SEQUENCE permissao_codigo_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	NO MAXVALUE
	CACHE 1;
	
CREATE TABLE public.permissao
(
  codigo bigint NOT NULL DEFAULT nextval('permissao_codigo_seq'::regclass),
  nome character varying(255),
  CONSTRAINT permissao_pkey PRIMARY KEY (codigo)
);


CREATE TABLE public.usuario_grupo
(
  codigo_usuario bigint NOT NULL,
  codigo_grupo bigint NOT NULL,
  CONSTRAINT usuario_grupo_pkey PRIMARY KEY (codigo_grupo, codigo_usuario),
  CONSTRAINT fk4yweq9u2sokki6o060mejfw8r FOREIGN KEY (codigo_grupo)
      REFERENCES public.grupo (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkcx5f61jsftmpnlu4ec8fyndg3 FOREIGN KEY (codigo_usuario)
      REFERENCES public.usuario (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE public.grupo_permissao
(
  codigo_grupo bigint NOT NULL,
  codigo_permissao bigint NOT NULL,
  CONSTRAINT fkfp14wb9mt832y4jlw2rx3pf6p FOREIGN KEY (codigo_permissao)
      REFERENCES public.permissao (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkh1lvrl72de4u5xhr1u3jvo0rq FOREIGN KEY (codigo_grupo)
      REFERENCES public.grupo (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
)

INSERT INTO public.usuario(codigo, ativo, data_nascimento, email, nome, senha)
    VALUES (1, TRUE, null, 'admin', 'admin', '$2a$10$tUs8O7dNLFzfB95.xDh00.wSEyt3/smxo2O7ND36UIBVCcosxz33i');

