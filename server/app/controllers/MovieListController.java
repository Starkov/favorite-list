package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import dto.MovieListDTO;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.MovieListService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class MovieListController extends Controller {
    private static final String INVALID_JSON_DATA_MSG = "Invalid json data";
    private static final String CAN_NOT_FIND_WITH_ID_MSG = "Can't find with id: %s";
    private static final String EXPECTING_JSON_DATA = "Expecting Json data";
    private static final String BAD_INPUT_PARAMS = "bad input params";

    @Inject
    private MovieListService movieListService;

    public Result home(){
        return redirect("http://localhost:9000/#/favorite");
    }

    @Transactional
    public Result findAllMovies() {
        List<MovieListDTO> movieLists = movieListService.findAll();
        return ok(Json.toJson(movieLists));
    }

    @Transactional
    public Result find(Integer id) {
        badRequestIfNull(id);
        MovieListDTO movieList = movieListService.getById(id);
        if (movieList == null) {
            badRequest(String.format(CAN_NOT_FIND_WITH_ID_MSG, id));
        }
        return ok(Json.toJson(movieList));
    }

    @Transactional
    public Result save() {
        JsonNode json = request().body().asJson();
        badRequestIfNull(json);
        if (isNotValidFields(json, asList("name"))) {
            return badRequest(INVALID_JSON_DATA_MSG);
        }
        MovieListDTO dto = Json.fromJson(json, MovieListDTO.class);
        movieListService.saveOrUpdate(dto);
        return ok();
    }

    @Transactional
    public Result update() {
        JsonNode json = request().body().asJson();
        badRequestIfNull(json);
        if (isNotValidFields(json, asList("id", "name"))) {
            return badRequest(INVALID_JSON_DATA_MSG);
        }
        MovieListDTO dto = Json.fromJson(json, MovieListDTO.class);
        movieListService.saveOrUpdate(dto);
        return ok();
    }

    @Transactional
    public Result remove() {
        JsonNode json = request().body().asJson();
        badRequestIfNull(json);
        if (isNotValidFields(json, asList("id", "name"))) {
            return badRequest(INVALID_JSON_DATA_MSG);
        }
        MovieListDTO dto = Json.fromJson(json, MovieListDTO.class);
        movieListService.remove(dto);
        return ok();
    }

    private void badRequestIfNull(Object o) {
        if (o == null) {
            badRequest(EXPECTING_JSON_DATA);
        }
    }

    private boolean isNotValidFields(JsonNode json, List<String> fields) {
        if (json == null & fields.isEmpty()) {
            throw new IllegalStateException(BAD_INPUT_PARAMS);
        }
        for (String fieldName : fields) {
            JsonNode field = json.get(fieldName);
            if (field != null && field.isNumber()) {
                if (field.numberValue() == null) {
                    return true;
                }
            }
            if (field != null && field.isTextual()) {
                if (isBlank(field.textValue())) {
                    return true;
                }
            }
        }
        return false;
    }
}
