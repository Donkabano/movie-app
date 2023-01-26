package by.ilyabychkovski.movieapp.service;

import by.ilyabychkovski.movieapp.data.MovieData;
import by.ilyabychkovski.movieapp.data.entity.MovieEntity;
import by.ilyabychkovski.movieapp.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieService {

    private final MovieData movieData;

    public MovieService(MovieData movieData) {
        this.movieData = movieData;
    }

    public Optional<Movie> find(long id) {
        Optional<MovieEntity> entity = movieData.find(id);
        if (entity.isPresent()) {
            return Optional.of(constructMovie(entity.get()));
        }
        return Optional.empty();
    }

    public List<Movie> findAll() {
        List<MovieEntity> entities = movieData.findAll();
        List<Movie> movies = new ArrayList<>(entities.size());
        for (int i = 0; i < entities.size(); i++) {
            movies.add(constructMovie(entities.get(i)));
        }

        return movies;
    }

    public Movie update(Movie movie) {
        checkMovieOnNotExisting(movie.getId());
        return constructMovie(movieData.update(constructMovieEntity(movie)));
    }

    public void delete(long id) {
        checkMovieOnNotExisting(id);
        movieData.delete(id);
    }

    public Movie add(Movie movie) {
        return constructMovie(movieData.add(constructMovieEntity(movie)));
    }

    private Movie constructMovie(MovieEntity entity) {
        return new Movie(entity.getId(), entity.getName(), entity.getPublishingDate());
    }

    private MovieEntity constructMovieEntity(Movie movie) {
        return new MovieEntity(movie.getId(), movie.getName(), movie.getPublishingDate());
    }

    private void checkMovieOnNotExisting(long id) {
        Optional<Movie> maybeMovie = find(id);
        if (maybeMovie.isEmpty()) {
            throw new NoSuchMovieException(id);
        }
    }
}
