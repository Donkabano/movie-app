package by.ilyabychkovski.movieapp.service;

import java.text.MessageFormat;

public class NoSuchMovieException extends RuntimeException {

    public NoSuchMovieException(String templateMessage, Object... params) {
        super(MessageFormat.format(templateMessage, params));
    }

    public NoSuchMovieException(long id) {
        super(MessageFormat.format("Фильма с индетификатором {0} нет в системе.", id));
    }
}
