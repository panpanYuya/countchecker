DROP TABLE IF EXISTS constipation;

CREATE TABLE IF NOT EXISTS constipation (
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  user_id VARCHAR(100) NOT NULL UNIQUE,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  PRIMARY KEY(id,user_id)
);
