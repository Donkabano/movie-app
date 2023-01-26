package by.ilyabychkovski.movieapp.console;

import by.ilyabychkovski.movieapp.domain.Movie;
import by.ilyabychkovski.movieapp.service.MovieService;
import by.ilyabychkovski.movieapp.service.NoSuchMovieException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleClient {

    private final MovieService movieService;
    private final Scanner scanner;

    public ConsoleClient(MovieService movieService, Scanner scanner) {
        this.movieService = movieService;
        this.scanner = scanner;
    }

    public void addMovie() {
        String name = performName(scanner);
        LocalDate publishing = performDate(scanner);

        Movie movie = new Movie(null, name, publishing);
        movieService.add(movie);
    }

    public void updateMovie() {
        printMovies();

        long id = performId(scanner);
        String name = performName(scanner);
        LocalDate publishing = performDate(scanner);
        Movie movie = new Movie(id, name, publishing);

        try {
            movieService.update(movie);
            System.out.println("Фильм с id " + id + " был обновлен.");
        } catch (NoSuchMovieException e) {
            System.err.println(e.getMessage());
        }
    }

    public void printMovie() {
        long id = performId(scanner);
        Optional<Movie> movie = movieService.find(id);

        if (movie.isPresent()) {
            System.out.println(movie.get());
        } else {
            System.out.println("Фильм с id " + id + " не найден.");
        }
    }

    public void printMovies() {
        List<Movie> movies = movieService.findAll();
        if (!movies.isEmpty()) {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        } else {
            System.out.println("Фильмы не найдены.");
        }
    }

    public void deleteMovie() {
        long id = performId(scanner);

        try {
            movieService.delete(id);
            System.out.println("Фильм с id " + id + " был удален.");
        } catch (NoSuchMovieException e) {
            System.err.println(e.getMessage());
        }
    }

    private long performId(Scanner scanner) {
        System.out.println("Введите id фильма:");
        return scanner.hasNextLong() ? scanner.nextLong() : performId(scanner);
    }

    private String performName(Scanner scanner) {
        System.out.println("Введите название фильма:");
        return scanner.next();
    }

    private LocalDate performDate(Scanner scanner) {
        System.out.println("Введите дату выспуска фильма:");
        return LocalDate.parse(scanner.next());
    }
}
