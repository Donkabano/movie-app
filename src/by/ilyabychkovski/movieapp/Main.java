package by.ilyabychkovski.movieapp;

import by.ilyabychkovski.movieapp.console.ConsoleClient;
import by.ilyabychkovski.movieapp.console.ConsoleEngine;
import by.ilyabychkovski.movieapp.data.MovieData;
import by.ilyabychkovski.movieapp.service.MovieService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MovieData movieData = new MovieData();
        MovieService movieService = new MovieService(movieData);

        Scanner scanner = new Scanner(System.in);
        ConsoleClient console = new ConsoleClient(movieService, scanner);
        new ConsoleEngine(console, scanner).run();

        scanner.close();
    }
}
