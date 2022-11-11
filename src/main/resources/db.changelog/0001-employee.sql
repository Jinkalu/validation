--liquibase formatted sql
--changeset Jinkalu:change_0001

CREATE TABLE employee (id BIGINT NOT NULL,
                         name VARCHAR(50),
                         email VARCHAR(50),

                         PRIMARY KEY(id));

--changeset Jinkalu:change_0002

CREATE SEQUENCE id_seq INCREMENT BY 1 START WITH 1 OWNED BY employee.id;

ALTER TABLE employee ALTER COLUMN id SET DEFAULT nextval('id_seq');