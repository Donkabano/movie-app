package by.ilyabychkovski.movieapp.data.entity;

import java.time.LocalDate;
import java.util.Objects;

public class MovieEntity {

    private long id;
    private String name;
    private LocalDate publishingDate;

    public MovieEntity(long id, String name, LocalDate publishingDate) {
        this.id = id;
        this.name = name;
        this.publishingDate = publishingDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        MovieEntity that = (MovieEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(publishingDate, that.publishingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, publishingDate);
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishingDate=" + publishingDate +
                '}';
    }
}
