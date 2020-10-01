CREATE TABLE tasks(
    id uuid NOT NULL PRIMARY KEY,
    title VARCHAR(256) NOT NULL,
    description TEXT,
    status VARCHAR(128) NOT NULL
)