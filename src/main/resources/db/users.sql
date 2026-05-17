--clients
CREATE TABLE clients (
    id UUID PRIMARY KEY,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE,
    password        VARCHAR(255) NOT NULL,
    birthday        DATE,
    gamer_tag       VARCHAR(50),
    is_member       BOOLEAN DEFAULT FALSE,
    client_level    VARCHAR(20) DEFAULT 'NEWBIE'
);

--staff
CREATE TABLE staff (
    id          UUID PRIMARY KEY,
    first_name  VARCHAR(50)  NOT NULL,
    last_name   VARCHAR(50)  NOT NULL,
    email       VARCHAR(100) NOT NULL UNIQUE,
    password    VARCHAR(255) NOT NULL,
    birthday    DATE,
    staff_role  VARCHAR(20),
    salary      DECIMAL(10,2)
);