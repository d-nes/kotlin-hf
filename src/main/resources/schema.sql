CREATE TABLE IF NOT EXISTS TAXI_LOG (
    id       VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    time     TIME      NOT NULL,
    date     DATE      NOT NULL,
    driver     VARCHAR      NOT NULL,
    customer     VARCHAR,
    message     VARCHAR      NOT NULL
    );

CREATE TABLE IF NOT EXISTS TAXI_DRIVERS (
    id       VARCHAR(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name     VARCHAR      NOT NULL,
    vehicle_id     VARCHAR      NOT NULL
    );