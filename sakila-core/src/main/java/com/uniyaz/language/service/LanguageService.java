package com.uniyaz.language.service;

import com.uniyaz.language.dao.LanguageDao;
import com.uniyaz.language.domain.Language;
import com.uniyaz.language.queryfilterdto.LanguageQueryFilterDto;
import com.uniyaz.staff.dao.StaffDao;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;

import java.util.List;

public class LanguageService {


    public List<Language> findAll() {
        LanguageDao languageDao = new LanguageDao();
        return languageDao.findAll();
    }
    public List<Language> findAllByQueryFilterDto(LanguageQueryFilterDto languageQueryFilterDto) {
        LanguageDao languageDao = new LanguageDao();
        return languageDao.findAllByQueryFilterDto(languageQueryFilterDto);
    }

}
