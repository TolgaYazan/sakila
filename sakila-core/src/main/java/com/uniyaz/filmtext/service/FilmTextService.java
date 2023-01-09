package com.uniyaz.filmtext.service;

import com.uniyaz.filmtext.dao.FilmTextDao;
import com.uniyaz.filmtext.domain.FilmText;
import com.uniyaz.filmtext.queryfilterdto.FilmTextQueryFilter;
import com.uniyaz.filmtext.queryfilterdto.FilmTextQueryFilter;
import com.uniyaz.filmtext.domain.FilmText;

import java.util.List;

public class FilmTextService {

    public List<FilmText> findAll() {
        FilmTextDao filmTextDao = new FilmTextDao();
        return filmTextDao.findAll();
    }
    public List<FilmText> findAllByQueryFilterDto(FilmTextQueryFilter filmTextQueryFilterDto) {
        FilmTextDao filmTextDao = new FilmTextDao();
        return filmTextDao.findAllByQueryFilterDto(filmTextQueryFilterDto);
    }
}
