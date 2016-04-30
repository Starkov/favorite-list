# movie_list schema

# --- !Ups

CREATE TABLE IF NOT EXISTS movie_list (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

# --- !Downs

DROP TABLE movie_list;