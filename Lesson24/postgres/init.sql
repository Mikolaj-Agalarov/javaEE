CREATE TABLE users
(
    id         BIGSERIAL NOT NULL UNIQUE,
    name       VARCHAR   NOT NULL UNIQUE,
    password   VARCHAR   NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

INSERT INTO users (name, password)
VALUES ('Andrey', '12345');
INSERT INTO users (name, password)
VALUES ('Mikolaj', '123');
