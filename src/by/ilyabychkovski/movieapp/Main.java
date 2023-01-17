package by.ilyabychkovski.movieapp;

import by.ilyabychkovski.movieapp.console.Console;
import by.ilyabychkovski.movieapp.console.ConsoleEngine;
import by.ilyabychkovski.movieapp.data.MovieData;
import by.ilyabychkovski.movieapp.service.MovieService;

public class Main {

    public static void main(String[] args) {
        MovieData movieData = new MovieData();
        MovieService movieService = new MovieService(movieData);
        Console console = new Console(movieService);

        new ConsoleEngine(console).run();
    }
}
