package by.ilyabychkovski.movieapp.console;

import java.util.Scanner;

public class ConsoleEngine {

    private final ConsoleClient console;
    private final Scanner scanner;

    public ConsoleEngine(ConsoleClient console, Scanner scanner) {
        this.console = console;
        this.scanner = scanner;
    }

    public void run() {
        boolean isRunning = true;
        System.out.println("Добро пожаловать!");

        while (isRunning) {
            System.out.println("Если вы хотите добавить фильм, нажмите 1");
            System.out.println("Если вы хотите обновить фильм, нажмите 2");
            System.out.println("Если вы хотите просмотреть все фильмы, нажмите 3");
            System.out.println("Если вы хотите найти фильм, нажмите 4");
            System.out.println("Если вы хотите удалить фильм, нажмите 5");
            System.out.println("Если вы хотите выйти из приложения, нажмите 6");

            String action = scanner.hasNext() ? scanner.next() : "";
            switch (action) {
                case "1" -> console.addMovie();
                case "2" -> console.updateMovie();
                case "3" -> console.printMovies();
                case "4" -> console.printMovie();
                case "5" -> console.deleteMovie();
                case "6" -> isRunning = false;
                default -> System.out.println("Вы ввели некорректную команду.");
            }
        }
    }
}
