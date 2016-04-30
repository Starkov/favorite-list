package services.impl;

import dao.impl.MovieListDAOImpl;
import dto.MovieDTO;
import dto.MovieListDTO;
import entities.MovieListEntity;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class MovieListServiceImplTest {

    private MovieListDAOImpl dao = mock(MovieListDAOImpl.class);

    private MovieListServiceImpl service = spy(new MovieListServiceImpl(dao));

    @Test
    public void findAll() throws Exception {
        when(dao.findAll()).thenReturn(asList(new MovieListEntity("test")));
        List<MovieListDTO> result = service.findAll();
        assertFalse(result.isEmpty());
        assertEquals("test", result.get(0).getName());
    }

    @Test
    public void findAllDAOReturnNull() {
        List<MovieListDTO> result = service.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    public void getById() throws Exception {
        when(dao.getById(anyObject())).thenReturn(new MovieListEntity("test"));
        MovieListDTO movieListDTO = service.getById(1);
        assertNotNull(movieListDTO);
        assertEquals("test", movieListDTO.getName());
    }

    @Test
    public void getByIdDAOReturnNull() throws Exception {
        MovieListDTO movieListDTO = service.getById(1);
        assertNull(movieListDTO);
    }

    @Test
    public void saveOrUpdate() throws Exception {
        MovieListEntity entity = new MovieListEntity("test");
        entity.setId(1);
        MovieListDTO dto = new MovieListDTO("test");
        when(dao.saveOrUpdate(any(MovieListEntity.class))).thenReturn(entity);

        Integer id = service.saveOrUpdate(dto);

        assertNotNull(id);
        assertEquals(Integer.valueOf(1),id);
    }

    @Test
    public void saveOrUpdateDAOReturnNull() throws Exception {
        Integer id = service.saveOrUpdate(new MovieListDTO("test"));
        assertNull(id);
    }



    @Test
    public void remove() throws Exception {
        MovieListDTO movieListDTO = new MovieListDTO("test");
        movieListDTO.setId(1);
        service.remove(movieListDTO);
        verify(dao).remove(any(MovieListEntity.class));
    }

}