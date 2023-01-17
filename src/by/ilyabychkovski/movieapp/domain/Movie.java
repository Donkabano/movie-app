package by.ilyabychkovski.movieapp.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {

    private Long id;
    private String name;
    private LocalDate publishingDate;

    public Movie(Long id,
                 String name,
                 LocalDate publishingDate) {
        this.id = id;
        this.name = name;
        this.publishingDate = publishingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) && Objects.equals(publishingDate, movie.publishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, publishingDate);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }
}
