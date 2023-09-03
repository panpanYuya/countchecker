DROP TABLE IF EXISTS constipation;
DROP TABLE IF EXISTS m_status;
DROP TABLE IF EXISTS m_color;
DROP TABLE IF EXISTS m_smell;
DROP TABLE IF EXISTS m_quantity;
DROP TABLE IF EXISTS m_refresh_feel;

CREATE TABLE IF NOT EXISTS constipation (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    user_id int NOT NULL ,
    status_id int NOT NULL ,
    color_id int NOT NULL ,
    smell_id int NOT NULL ,
    quantity_id int NOT NULL ,
    refresh_feel_id int NOT NULL ,
    memo VARCHAR(255),
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS m_status (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    status  VARCHAR(100) NOT NULL ,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS m_color (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    color VARCHAR(100) NOT NULL ,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS m_smell (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    smell VARCHAR(100) NOT NULL ,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS m_quantity (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    quantity VARCHAR(100) NOT NULL ,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS m_refresh_feel (
    id MEDIUMINT NOT NULL AUTO_INCREMENT,
    refresh_feel VARCHAR(100) NOT NULL ,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY(id)
);
