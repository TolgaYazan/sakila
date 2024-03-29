package com.uniyaz.film.queryfilterdto;

import com.uniyaz.filmcategory.domain.FilmCategory;
import com.uniyaz.language.domain.Language;

public class FilmQueryFilterDto {

    private Long id;

    private String title;

    private Language language;

    private FilmCategory filmCategory;

    public Long getId() {
        return id;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
