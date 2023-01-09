package com.uniyaz.category.queryfilterdto;

import com.uniyaz.filmcategory.domain.FilmCategory;

public class CategoryQueryFilterDto {

    private Long Id;

    private String name ;

    private FilmCategory filmCategory;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    @Override
    public String toString() {
        return "CategoryQueryFilterDto{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", filmCategory=" + filmCategory +
                '}';
    }
}
