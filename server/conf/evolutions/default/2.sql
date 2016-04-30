# movie schema

# --- !Ups

CREATE TABLE IF NOT EXISTS movie (
  movie_id          INT UNSIGNED     NOT NULL AUTO_INCREMENT,
  foreign_sys_id    INT UNSIGNED     NOT NULL,
  adult             TINYINT(1)       NOT NULL,
  backdrop_path     VARCHAR(45),
  original_language VARCHAR(5),
  original_title    VARCHAR(45),
  overview          VARCHAR(1000),
  release_date      DATE,
  poster_path       VARCHAR(45),
  popularity        FLOAT,
  title             VARCHAR(45),
  video             TINYINT(1),
  vote_average      FLOAT,
  vote_count        FLOAT,
  movie_list_id     INTEGER UNSIGNED NOT NULL,
  PRIMARY KEY (`movie_id`),
  INDEX idx_MovieList (movie_list_id),
  FOREIGN KEY (movie_list_id)
  REFERENCES movie_list(id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

# --- !Downs

DROP TABLE IF EXISTS movie;