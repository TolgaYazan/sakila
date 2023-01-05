package com.uniyaz.actor.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.actor.queryfilterdto.ActorQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ActorDao {

    public List<Actor> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select actor From Actor actor");
        List<Actor> actorList = query.list();
        return actorList;
    }

    public Actor save(Actor actor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        actor = (Actor) currentSession.merge(actor);
        transaction.commit();
        return actor;
    }

    public void delete(Actor actor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(actor);
        transaction.commit();
    }

    public List<Actor> findAllByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select actor From Actor actor where actor.firstName = :name ");
        query.setParameter("name", name);
        List<Actor> actorList = query.list();
        return actorList;
    }

    public List<Actor> findAllByQueryFilterDto(ActorQueryFilterDto actorQueryFilterDto) {

        String hql =
                "Select actor " +
                "From Actor actor " +
                "where 1=1 ";

        if (actorQueryFilterDto.getId() != null) {
            hql += " and actor.id = :actorId";
        }

        if (actorQueryFilterDto.getFirstName() != null) {
            hql += " and actor.firstName = :firstName";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (actorQueryFilterDto.getId() != null) {
            query.setParameter("actorId", actorQueryFilterDto.getId());
        }

        if (actorQueryFilterDto.getFirstName() != null) {
            query.setParameter("firstName", actorQueryFilterDto.getFirstName());
        }

        List<Actor> actorList = query.list();
        return actorList;
    }
}