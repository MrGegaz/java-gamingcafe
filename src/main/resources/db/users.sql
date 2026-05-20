CREATE TABLE users (
    id           UUID         PRIMARY KEY,
    user_type    VARCHAR(10)  NOT NULL CHECK (user_type IN ('CLIENT', 'STAFF')),
    first_name   VARCHAR(50)  NOT NULL,
    last_name    VARCHAR(50)  NOT NULL,
    email        VARCHAR(100) NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    birthday     DATE,
    -- CLIENT only
    gamer_tag    VARCHAR(50),
    is_member    BOOLEAN      DEFAULT FALSE,
    client_level VARCHAR(20)  DEFAULT 'NEWBIE',
    -- STAFF only
    staff_role   VARCHAR(20),
    salary       DECIMAL(10,2)
);