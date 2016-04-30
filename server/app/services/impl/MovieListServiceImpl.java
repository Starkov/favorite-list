package services.impl;

import dao.MovieListDAO;
import dto.MovieListDTO;
import entities.MovieEntity;
import entities.MovieListEntity;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import services.MovieListService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Singleton
public class MovieListServiceImpl implements MovieListService {
    private static final Mapper MAPPER = new DozerBeanMapper();

    private MovieListDAO movieListDAO;

    @Inject
    public MovieListServiceImpl(MovieListDAO movieListDAO) {
        this.movieListDAO = movieListDAO;
    }

    public List<MovieListDTO> findAll() {
        List<MovieListDTO> result = new ArrayList<>();
        List<MovieListEntity> movieListEntities = movieListDAO.findAll();
        for (MovieListEntity entity : emptyIfNull(movieListEntities)) {
            result.add(MAPPER.map(entity, MovieListDTO.class));
        }
        return result;
    }

    @Override
    public MovieListDTO getById(Integer id) {
        MovieListEntity entity = movieListDAO.getById(id);
        return entity != null ? MAPPER.map(entity, MovieListDTO.class) : null;
    }

    @Override
    public Integer saveOrUpdate(MovieListDTO dto) {
        MovieListEntity entity = MAPPER.map(dto, MovieListEntity.class);
        for(MovieEntity movie : emptyIfNull(entity.getMovies())){
            movie.setMovieList(entity);
        }
        entity = movieListDAO.saveOrUpdate(entity);
        return entity != null ? entity.getId() : null;
    }

    @Override
    public void remove(MovieListDTO dto) {
        MovieListEntity entity = MAPPER.map(dto, MovieListEntity.class);
        movieListDAO.remove(entity);
    }


}
