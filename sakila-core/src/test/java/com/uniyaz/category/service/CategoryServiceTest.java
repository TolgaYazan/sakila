package com.uniyaz.category.service;

import com.uniyaz.category.domain.Category;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmactor.service.FilmActorService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CategoryServiceTest {
    @Test
    public void findAllTest() {

        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.findAll();
        for (Category category : categoryList) {
            System.out.println(category);
        }
    }


    @Test
    public void saveTest() {

        Category category = new Category();
        category.setname("Korku");
        category.setLastUpdate(new Date());

        CategoryService categoryService  = new CategoryService();
        categoryService.save(category);
        System.out.println("Kayıt Eklendi");
    }

    @Test
    public void searchByName() {

        CategoryService categoryService  = new CategoryService();
        List<Category> categorylist = categoryService.findAllByName("Korku");
        for(Category category:categorylist){
            System.out.println(category);
        }

    }
}


