package com.uniyaz.filmactor.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import com.uniyaz.film.queryfilterdto.FilmQueryFilterDto;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmcategory.domain.FilmCategory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class FilmActorDao {

    public List<FilmActor> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select filmActor From FilmActor filmActor");
        List<FilmActor> filmActorList = query.list();
        return filmActorList;
    }

    public FilmActor save(FilmActor filmActor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        filmActor = (FilmActor) currentSession.merge(filmActor);
        transaction.commit();
        return filmActor;
    }

    public void delete(FilmActor filmActor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(filmActor);
        transaction.commit();
    }


    public List<FilmActor> filmToActorFindByQueryFilter(ActorQueryFilterDto actorQueryFilterDto) {

        String hql =
                "Select filmActor " +
                        "From FilmActor filmActor " +
                        "Left Join fetch filmActor.film title " +
                        "Left Join fetch filmActor.actor firstName " +
                        "where 1=1 ";



        if(actorQueryFilterDto.getFilmActor()!=null){
            hql += " and filmActor.film.title = :title";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (actorQueryFilterDto.getFilmActor() != null) {
            query.setParameter("title", actorQueryFilterDto.getFilmActor().getFilm().getTitle());
        }

        List<FilmActor> filmList = query.list();
        return filmList;
    }

    public List<FilmActor> actorToFilmFindByQueryFilter(ActorQueryFilterDto actorQueryFilterDto) {

        String hql =
                "Select filmActor " +
                        "From FilmActor filmActor " +
                        "Left Join fetch filmActor.actor firstName " +
                        "Left Join fetch filmActor.film title " +
                        "where 1=1 ";



        if(actorQueryFilterDto.getFilmActor()!=null){
            hql += " and filmActor.actor.firstName = :firstName";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (actorQueryFilterDto.getFilmActor() != null) {
            query.setParameter("firstName", actorQueryFilterDto.getFilmActor().getActor().getFirstName());
        }

        List<FilmActor> filmList = query.list();
        return filmList;
    }

}