package services;


import dto.MovieListDTO;

import java.util.List;

public interface MovieListService {

    List<MovieListDTO> findAll();

    MovieListDTO getById(Integer id);

    Integer saveOrUpdate(MovieListDTO dto);

    void remove(MovieListDTO dto);
}
