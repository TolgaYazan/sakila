package com.uniyaz.filmcategory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmcategory.domain.FilmCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FilmCategoryDao {

    public List<FilmCategory> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select filmCategory From FilmCategory filmCategory");
        List<FilmCategory> filmCategoryList = query.list();
        return filmCategoryList;
    }

    public FilmCategory save(FilmCategory filmCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        filmCategory = (FilmCategory) currentSession.merge(filmCategory);
        transaction.commit();
        return filmCategory;
    }

    public void delete(FilmCategory filmCategory) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(filmCategory);
        transaction.commit();
    }

    public List<FilmCategory> categoryToFilmFindByQuetFilter(FilmQueryFilterDto filmQueryFilterDto) {

        String hql =
                "Select filmCategory " +
                        "From FilmCategory filmCategory " +
                        "Left Join fetch filmCategory.category category " +
                        "Left Join fetch filmCategory.film title " +
                        "where 1=1 ";



        if(filmQueryFilterDto.getFilmCategory()!=null){
            hql += " and filmCategory.category.name = :category";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmQueryFilterDto.getFilmCategory() != null) {
            query.setParameter("category", filmQueryFilterDto.getFilmCategory().getCategory().getname());
        }

        List<FilmCategory> filmList = query.list();
        return filmList;
    }

    public List<FilmCategory> filmToCategoryFindByQuetFilter(FilmQueryFilterDto filmQueryFilterDto) {

        String hql =
                "Select filmCategory " +
                        "From FilmCategory filmCategory " +
                        "Left Join fetch filmCategory.film title " +
                        "Left Join fetch filmCategory.category name " +
                        "where 1=1 ";



        if(filmQueryFilterDto.getFilmCategory()!=null){
            hql += " and filmCategory.film.title = :title";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmQueryFilterDto.getFilmCategory() != null) {
            query.setParameter("title", filmQueryFilterDto.getFilmCategory().getFilm().getTitle());
        }




        List<FilmCategory> filmList = query.list();
        return filmList;

    }
}
