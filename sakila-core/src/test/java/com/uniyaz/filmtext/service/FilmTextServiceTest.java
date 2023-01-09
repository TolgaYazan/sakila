package com.uniyaz.filmtext.service;

import com.uniyaz.filmtext.domain.FilmText;
import com.uniyaz.filmtext.queryfilterdto.FilmTextQueryFilter;
import org.junit.Test;

import java.util.List;

public class FilmTextServiceTest {

    @Test
    public void findAllTest() {

        FilmTextService filmTextService = new FilmTextService();
        List<FilmText> filmTextList = filmTextService.findAll();
        for (FilmText filmText : filmTextList) {
            System.out.println(filmText);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        FilmTextService filmTextService = new FilmTextService();
        FilmTextQueryFilter filmTextQueryFilter = new FilmTextQueryFilter();
        //filmTextQueryFilter.setId(1L);
        filmTextQueryFilter.setTitle("ACADEMY DINOSAUR");
        List<FilmText> filmTextList = filmTextService.findAllByQueryFilterDto(filmTextQueryFilter);
        for (FilmText filmText : filmTextList) {
            System.out.println(filmText);
        }
    }
}
