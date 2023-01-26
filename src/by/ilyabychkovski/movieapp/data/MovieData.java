package by.ilyabychkovski.movieapp.data;

import by.ilyabychkovski.movieapp.data.entity.MovieEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MovieData {

    private Map<Long, MovieEntity> moviesMap = new HashMap<>();
    private int movieIndex = 0;

    public Optional<MovieEntity> find(long id) {
        return Optional.ofNullable(moviesMap.get(id));
    }

    public List<MovieEntity> findAll() {
        return new ArrayList<>(moviesMap.values());
    }

    public MovieEntity add(MovieEntity movie) {
        movie.setId(movieIndex);
        moviesMap.put(movie.getId(), movie);
        movieIndex++;
        
        return movie;
    }

    public MovieEntity update(MovieEntity movie) {
        return moviesMap.replace(movie.getId(), movie);
    }

    public void delete(long id) {
        moviesMap.remove(id);
    }
}
