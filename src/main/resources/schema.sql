CREATE TABLE IF NOT EXISTS TAXI_LOG (
    id       VARCHAR(60)  PRIMARY KEY,
    time     TIME      NOT NULL,
    driver     VARCHAR      NOT NULL,
    customer     VARCHAR,
    message     VARCHAR      NOT NULL
    );

CREATE TABLE IF NOT EXISTS TAXI_DRIVERS (
    id       VARCHAR(60)  PRIMARY KEY,
    name     VARCHAR      NOT NULL,
    vehicle_id     VARCHAR      NOT NULL
    );