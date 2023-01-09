package com.uniyaz.filmactor.service;

import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.category.domain.Category;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmcategory.domain.FilmCategory;
import com.uniyaz.filmcategory.service.FilmCategoryService;
import org.junit.Test;

import java.util.List;


public class FilmActorServiceTest {

    @Test
    public void findAllTest() {

        FilmActorService filmActorService = new FilmActorService();
        List<FilmActor> filmActorList = filmActorService.findAll();
        for (FilmActor filmActor : filmActorList) {
            System.out.println(filmActor);
        }
    }

    @Test
    public void actorToFilmfindAllTestQueryFilter() {

        FilmActorService filmActorService = new FilmActorService();
        ActorQueryFilterDto actorQueryFilterDto = new ActorQueryFilterDto();

        Actor actor = new Actor();
        actor.setFirstName("NICK");

        FilmActor filmActor  =new FilmActor();
        filmActor.setActor(actor);

        actorQueryFilterDto.setFilmActor(filmActor);
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<FilmActor> filmActorList = filmActorService.actorToFilmAllByQueryFilterDto(actorQueryFilterDto);
        for (FilmActor filmActor1 : filmActorList) {
            System.out.println(filmActor1);
        }
    }


    @Test
    public void filmToActorfindAllTestQueryFilter() {

        FilmActorService filmActorService = new FilmActorService();
        ActorQueryFilterDto actorQueryFilterDto = new ActorQueryFilterDto();

        Film film = new Film();
        film.setTitle("ACADEMY DINOSAUR");

        FilmActor filmActor = new FilmActor();
        filmActor.setFilm(film);

        actorQueryFilterDto.setFilmActor(filmActor);


        List<FilmActor> filmActorList = filmActorService.filmToActorAllByQueryFilterDto(actorQueryFilterDto);
        for (FilmActor filmActor1 : filmActorList) {
            System.out.println(filmActor1);
        }
    }
}