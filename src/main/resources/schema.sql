CREATE TABLE IF NOT EXISTS TAXI_LOG (
    id       VARCHAR(60)  PRIMARY KEY,
    time     TIME      NOT NULL,
    driver     VARCHAR      NOT NULL,
    customer     VARCHAR      NOT NULL,
    message     VARCHAR      NOT NULL
    );