package dao.impl;

import dao.MovieListDAO;
import entities.MovieListEntity;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
@Transactional
public class MovieListDAOImpl implements MovieListDAO {
    @Inject
    protected JPAApi jpa;

    public List<MovieListEntity> findAll() {
        return jpa.em().createQuery("from MovieListEntity").getResultList();
    }


    public MovieListEntity getById(Integer id) {
        return jpa.em().find(MovieListEntity.class, id);
    }

    public MovieListEntity saveOrUpdate(MovieListEntity entity) {
        if (entity.getId() == null) {
            jpa.em().persist(entity);
            jpa.em().refresh(entity);
        } else {
            jpa.em().merge(entity);
        }
        return entity;
    }

    public void remove(MovieListEntity entity) {
        jpa.em().remove(entity);
    }
}

