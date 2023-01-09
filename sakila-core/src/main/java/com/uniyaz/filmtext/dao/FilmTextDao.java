package com.uniyaz.filmtext.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.filmtext.domain.FilmText;
import com.uniyaz.filmtext.queryfilterdto.FilmTextQueryFilter;
import com.uniyaz.filmtext.queryfilterdto.FilmTextQueryFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FilmTextDao {
    public List<FilmText> findAll() {
        SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = SessionFactory.openSession();
        Query query = currentSession.createQuery("Select filmText From FilmText filmText");
        List<FilmText> filmTextList = query.list();
        return filmTextList;
    }

    public List<FilmText> findAllByQueryFilterDto(FilmTextQueryFilter filmTextQueryFilterDto) {

        String hql =
                "Select filmText " +
                        "From FilmText filmText " +
                        "where 1=1 ";

        if (filmTextQueryFilterDto.getId() != null) {
            hql += " and filmText.id = :filmTextId";
        }

        if (filmTextQueryFilterDto.getTitle() != null) {
            hql += " and filmText.title = :title";
        }

        SessionFactory SessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = SessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmTextQueryFilterDto.getId() != null) {
            query.setParameter("filmTextId", filmTextQueryFilterDto.getId());
        }

        if (filmTextQueryFilterDto.getTitle() != null) {
            query.setParameter("title", filmTextQueryFilterDto.getTitle());
        }

        List<FilmText> filmTextList = query.list();
        return filmTextList;
    }
}
