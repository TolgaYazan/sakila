package com.uniyaz.filmcategory.service;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.adress.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.adress.service.AddressService;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.service.CategoryService;
import com.uniyaz.city.domain.City;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmcategory.domain.FilmCategory;
import com.uniyaz.filmcategory.service.FilmCategoryService;
import com.uniyaz.filmcategory.domain.FilmCategory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class FilmCategoryServiceTest {
    @Test
    public void findAllTest() {

        FilmCategoryService filmFilmCategoryService = new FilmCategoryService();
        List<FilmCategory> filmFilmCategoryList = filmFilmCategoryService.findAll();
        for (FilmCategory filmCategory : filmFilmCategoryList) {
            System.out.println(filmCategory);
        }
    }

    @Test
    public void categoryToFilmfindAllTestQueryFilter() {

        FilmCategoryService filmCategoryService = new FilmCategoryService();
        FilmQueryFilterDto filmQueryFilterDto = new FilmQueryFilterDto();

        Category category = new Category();
        category.setname("Action");

        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setCategory(category);

        filmQueryFilterDto.setFilmCategory(filmCategory);
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<FilmCategory> filmCategoryList = filmCategoryService.categoryToFilmAllByQueryFilterDto(filmQueryFilterDto);
        for (FilmCategory filmCategory1 : filmCategoryList) {
            System.out.println(filmCategory1);
        }
    }

    @Test
    public void filmToCategoryfindAllTestQueryFilter() {
        FilmCategoryService filmCategoryService = new FilmCategoryService();
        FilmQueryFilterDto filmQueryFilterDto = new FilmQueryFilterDto();

        Film film = new Film();
        film.setTitle("ACADEMY DINOSAUR");

        FilmCategory filmCategory = new FilmCategory();
        filmCategory.setFilm(film);

        filmQueryFilterDto.setFilmCategory(filmCategory);
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<FilmCategory> filmCategoryList = filmCategoryService.filmToCategoryAllByQueryFilterDto(filmQueryFilterDto);
        for (FilmCategory filmCategory1 : filmCategoryList) {
            System.out.println(filmCategory1);
        }
    }


}
