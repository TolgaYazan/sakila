package com.uniyaz.actor.queryfilterdto;

import com.uniyaz.film.domain.Film;
import com.uniyaz.filmactor.domain.FilmActor;

public class ActorQueryFilterDto {

    private Long id;
    private String firstName;
    private FilmActor filmActor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public FilmActor getFilmActor() {
        return filmActor;
    }

    public void setFilmActor(FilmActor filmActor) {
        this.filmActor = filmActor;
    }

    @Override
    public String toString() {
        return "ActorQueryFilterDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", filmActor=" + filmActor +
                '}';
    }
}