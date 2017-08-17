CREATE SEQUENCE cliente_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

    
CREATE TABLE public.cliente
(
  codigo bigint NOT NULL DEFAULT nextval('cliente_codigo_seq'::regclass),
  cpf_cnpj character varying(255) NOT NULL,
  email character varying(255),
  cep character varying(255),
  complemento character varying(255),
  logradouro character varying(255),
  numero character varying(255),
  facebook character varying(255),
  instagram character varying(255),
  nome character varying(255) NOT NULL,
  telefone character varying(255),
  tipo_pessoa character varying(255) NOT NULL,
  codigo_cidade bigint,
  CONSTRAINT cliente_pkey PRIMARY KEY (codigo),
  CONSTRAINT fk_cliente_codigo_cidade FOREIGN KEY (codigo_cidade)
      REFERENCES public.cidade (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE SEQUENCE animal_codigo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
CREATE TABLE public.animal
(
  codigo bigint NOT NULL DEFAULT nextval('animal_codigo_seq'::regclass),
  content_type character varying(255),
  data_nascimento date,
  descricao character varying(200),
  foto character varying(255),
  nome character varying(255) NOT NULL,
  tipo_animal character varying(255),
  codigo_dono bigint NOT NULL,
  CONSTRAINT animal_pkey PRIMARY KEY (codigo),
  CONSTRAINT fk_animal_codigo_dono FOREIGN KEY (codigo_dono)
      REFERENCES public.cliente (codigo) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
)   
 
