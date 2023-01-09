package com.uniyaz.film.service;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.category.domain.Category;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilter;
import com.uniyaz.customer.service.CustomerService;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmcategory.domain.FilmCategory;
import com.uniyaz.language.domain.Language;
import org.junit.Test;

import java.util.List;

public class FilmServiceTest {
    @Test
    public void findAllTest() {

        FilmService filmService = new FilmService();
        List<Film> filmList = filmService.findAll();
        for (Film film : filmList) {
            System.out.println(film);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        FilmService filmService = new FilmService();
        FilmQueryFilterDto filmQueryFilterDto = new FilmQueryFilterDto();

     //   Language language = new Language();
     //   language.setName("English");

        Category category = new Category();
        category.setname("Action");

     //   FilmCategory filmCategory = new FilmCategory();
       // filmCategory.setCategory(category);

        //filmQueryFilterDto.setFilmCategory(filmCategory);

      //  filmQueryFilterDto.setTitle("ACADEMY DINOSAUR");
      //  filmQueryFilterDto.setLanguage(language);
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<Film> filmList = filmService.findAllByQueryFilterDto(filmQueryFilterDto);
        for (Film film : filmList) {
            System.out.println(film);
        }
    }
}
