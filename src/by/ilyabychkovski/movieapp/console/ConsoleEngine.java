package by.ilyabychkovski.movieapp.console;

import java.util.Scanner;

public class ConsoleEngine {

    private final Console console;

    public ConsoleEngine(Console console) {
        this.console = console;
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

            Scanner scanner = new Scanner(System.in);

            int action = scanner.hasNextInt() ? scanner.nextInt() : 0;
            switch (action) {
                case 1:
                    console.addMovie();
                    break;
                case 2:
                    console.updateMovie();
                    break;
                case 3:
                    console.printMovies();
                    break;
                case 4:
                    console.printMovie();
                    break;
                case 5:
                    console.deleteMovie();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Вы ввели некорректную команду.");
            }
        }
    }
}
