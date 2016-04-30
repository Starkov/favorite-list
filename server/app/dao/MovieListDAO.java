package dao;


import entities.MovieListEntity;

import java.util.List;

public interface MovieListDAO {

    List<MovieListEntity> findAll();
    MovieListEntity getById(final Integer id);
    MovieListEntity saveOrUpdate(MovieListEntity entity);
    void remove(MovieListEntity entity);

}
