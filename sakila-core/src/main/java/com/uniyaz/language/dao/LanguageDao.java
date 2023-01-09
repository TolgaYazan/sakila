package com.uniyaz.language.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.language.domain.Language;
import com.uniyaz.language.queryfilterdto.LanguageQueryFilterDto;
import com.uniyaz.language.domain.Language;
import com.uniyaz.language.domain.Language;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LanguageDao {

    public List<Language> findAll() {
        SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = SessionFactory.openSession();
        Query query = currentSession.createQuery("Select Language From Language language");
        List<Language> LanguageList = query.list();
        return LanguageList;
    }

    public List<Language> findAllByQueryFilterDto(LanguageQueryFilterDto languageQueryFilterDto) {

        String hql =
                "Select Language " +
                        "From Language Language " +
                        "where 1=1 ";

        if (languageQueryFilterDto.getId() != null) {
            hql += " and Language.id = :LanguageId";
        }

        if (languageQueryFilterDto.getName() != null) {
            hql += " and Language.firstName = :firstName";
        }

        SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = SessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (languageQueryFilterDto.getId() != null) {
            query.setParameter("LanguageId", languageQueryFilterDto.getId());
        }

        if (languageQueryFilterDto.getName() != null) {
            query.setParameter("firstName", languageQueryFilterDto.getName());
        }

        List<Language> LanguageList = query.list();
        return LanguageList;
    }
}
