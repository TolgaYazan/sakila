package com.uniyaz.language.service;


import com.uniyaz.customer.domain.Customer;
import com.uniyaz.language.domain.Language;
import com.uniyaz.language.queryfilterdto.LanguageQueryFilterDto;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import com.uniyaz.rental.service.RentalService;
import org.junit.Test;

import java.util.List;

public class LanguageServiceTest {

    @Test
    public void findAllTest() {

        LanguageService languageService = new LanguageService();
        List<Language> languageList = languageService.findAll();
        for (Language language : languageList) {
            System.out.println(language);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        LanguageService languageService = new LanguageService();
        LanguageQueryFilterDto languageQueryFilterDto = new LanguageQueryFilterDto();
        languageQueryFilterDto.setId(1L);
        List<Language> languageList = languageService.findAllByQueryFilterDto(languageQueryFilterDto);
        for (Language language : languageList) {
            System.out.println(language);
        }
    }
}
