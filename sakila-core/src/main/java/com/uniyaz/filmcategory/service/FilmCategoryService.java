package com.uniyaz.filmcategory.service;

import com.uniyaz.film.dao.FilmDao;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmcategory.dao.FilmCategoryDao;
import com.uniyaz.filmcategory.domain.FilmCategory;

import java.util.List;

public class FilmCategoryService {
    public List<FilmCategory> findAll() {
        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
        return filmCategoryDao.findAll();
    }

    public FilmCategory save(FilmCategory filmCategory) {
        FilmCategoryDao FilmCategoryDao = new FilmCategoryDao();
        return FilmCategoryDao.save(filmCategory);
    }

    public void delete(FilmCategory FilmCategory) {
        FilmCategoryDao FilmCategoryDao = new FilmCategoryDao();
        FilmCategoryDao.delete(FilmCategory);
    }

    public List<FilmCategory> categoryToFilmAllByQueryFilterDto(FilmQueryFilterDto filmQueryFilterDto) {
        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
        return filmCategoryDao.categoryToFilmFindByQuetFilter(filmQueryFilterDto);
    }

    public List<FilmCategory> filmToCategoryAllByQueryFilterDto(FilmQueryFilterDto filmQueryFilterDto) {
        FilmCategoryDao filmCategoryDao = new FilmCategoryDao();
        return filmCategoryDao.filmToCategoryFindByQuetFilter(filmQueryFilterDto);
    }
}
