-- workstations.sql
-- column type differs Desktop/Console/VR, rest is nullable
CREATE TABLE workstations (
    id              UUID PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    type            VARCHAR(20)  NOT NULL,  -- 'DESKTOP', 'CONSOLE', 'VR'
    price_per_hour  DECIMAL(6,2),
    is_occupied     BOOLEAN DEFAULT FALSE,
    current_user_id UUID REFERENCES clients(id),
    -- Desktop specific
    gpu             VARCHAR(100),
    cpu             VARCHAR(100),
    ram             VARCHAR(50),
    -- Console specific
    console_type        VARCHAR(50),
    controllers_count   INTEGER,
    -- VR specific
    headset_count   INTEGER
);