--liquibase formatted sql
--changeset A-10232:change_0002

CREATE SEQUENCE id_seq INCREMENT BY 1 START WITH 1 OWNED BY employee.id;

ALTER TABLE employee ALTER COLUMN id SET DEFAULT nextval('id_seq');

