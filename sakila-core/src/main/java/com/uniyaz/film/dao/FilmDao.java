package com.uniyaz.film.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.film.domain.Film;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmcategory.domain.FilmCategory;
import com.uniyaz.filmtext.queryfilterdto.FilmTextQueryFilter;
import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.queryfilterdto.PaymentQueryFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FilmDao {

    public List<Film> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select film From Film film");
        List<Film> filmList = query.list();
        return filmList;
    }

    public Film save(Film film) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        film = (Film) currentSession.merge(film);
        transaction.commit();
        return film;
    }

    public void delete(Film film) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(film);
        transaction.commit();
    }

    public List<Film> findAllByQueryFilterDto(FilmQueryFilterDto filmQueryFilterDto) {

        String hql =
                "Select filmcategory " +
                        "From FilmCategory filmCategory " +
                        "Left Join fetch filmcategory.language name " +
                        "where 1=1 ";

        if (filmQueryFilterDto.getId() != null) {
            hql += " and film.id = :filmId";
        }

        if(filmQueryFilterDto.getTitle()!=null){
            hql += " and film.title = :title";
        }

        if(filmQueryFilterDto.getLanguage()!=null){
            hql += " and film.language.name = :name";
        }




        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (filmQueryFilterDto.getId() != null) {
            query.setParameter("filmId", filmQueryFilterDto.getId());
        }

        if (filmQueryFilterDto.getTitle() != null) {
            query.setParameter("title", filmQueryFilterDto.getTitle());
        }

        if (filmQueryFilterDto.getLanguage() != null) {
            query.setParameter("name", filmQueryFilterDto.getLanguage().getName());
        }



        List<Film> filmList = query.list();
        return filmList;

    }

}