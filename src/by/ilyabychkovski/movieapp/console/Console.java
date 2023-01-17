package by.ilyabychkovski.movieapp.console;

import by.ilyabychkovski.movieapp.domain.Movie;
import by.ilyabychkovski.movieapp.service.MovieService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Console {

    private final MovieService movieService;

    public Console(MovieService movieService) {
        this.movieService = movieService;
    }

    public void addMovie() {
        Scanner console = new Scanner(System.in);

        String name = performName(console);
        LocalDate publishing = performPublishing(console);

        Movie movie = new Movie(null, name, publishing);
        movieService.add(movie);

        console.close();
    }

    public void updateMovie() {
        printMovies();
        Scanner console = new Scanner(System.in);

        long id = performId(console);
        String name = performName(console);
        LocalDate publishing = performPublishing(console);

        Movie movie = new Movie(id, name, publishing);
        movieService.update(movie);

        console.close();
    }

    public void printMovie() {
        Scanner console = new Scanner(System.in);

        long id = performId(console);
        Optional<Movie> movie = movieService.find(id);

        if (movie.isPresent()) {
            System.out.println(movie.get());
        } else {
            System.out.println("Фильм с id " + id + " не найден.");
        }

        console.close();
    }

    public void printMovies() {
        Scanner console = new Scanner(System.in);

        List<Movie> movies = movieService.findAll();
        if (!movies.isEmpty()) {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        } else {
            System.out.println("Фильмы не найдены.");
        }

        console.close();
    }

    public void deleteMovie() {
        Scanner console = new Scanner(System.in);

        long id = performId(console);
        movieService.delete(id);
        System.out.println("Фильм с id " + id + " был удален.");

        console.close();
    }

    private long performId(Scanner console) {
        System.out.println("Введите id фильма:");
        return console.hasNextLong() ? console.nextLong() : performId(console);
    }

    private String performName(Scanner console) {
        System.out.println("Введите название фильма:");
        return console.next();
    }

    private LocalDate performPublishing(Scanner console) {
        System.out.println("Введите дату выспуска фильма:");
        return LocalDate.parse(console.next());
    }
}
