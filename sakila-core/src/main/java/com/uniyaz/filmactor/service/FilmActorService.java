package com.uniyaz.filmactor.service;

import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmactor.dao.FilmActorDao;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmcategory.dao.FilmCategoryDao;
import com.uniyaz.filmcategory.domain.FilmCategory;

import java.util.List;

public class FilmActorService {

    public List<FilmActor> findAll() {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.findAll();
    }

    public FilmActor save(FilmActor filmActor) {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.save(filmActor);
    }

    public void delete(FilmActor filmActor) {
        FilmActorDao filmActorDao = new FilmActorDao();
        filmActorDao.delete(filmActor);
    }

    public List<FilmActor> actorToFilmAllByQueryFilterDto(ActorQueryFilterDto actorQueryFilterDto) {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.actorToFilmFindByQueryFilter(actorQueryFilterDto);
    }

    public List<FilmActor> filmToActorAllByQueryFilterDto(ActorQueryFilterDto actorQueryFilterDto) {
        FilmActorDao filmActorDao = new FilmActorDao();
        return filmActorDao.filmToActorFindByQueryFilter(actorQueryFilterDto);
    }
}