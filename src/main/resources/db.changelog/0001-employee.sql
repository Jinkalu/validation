--liquibase formatted sql
--changeset A-10232:change_0001

CREATE TABLE employee (id BIGINT NOT NULL,
                         name VARCHAR(50),
                         email VARCHAR(50),

                         PRIMARY KEY(id));