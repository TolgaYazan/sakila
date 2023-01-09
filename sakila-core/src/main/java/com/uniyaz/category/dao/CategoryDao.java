package com.uniyaz.category.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.actor.domain.Actor;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.queryfilterdto.CategoryQueryFilterDto;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDao {
    public List<Category> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select category From Category category");
        List<Category> categoryList = query.list();
        return categoryList;
    }

    public Category save(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        category = (Category) currentSession.merge(category);
        transaction.commit();
        return category;
    }

    public void delete(Category category) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(category);
        transaction.commit();
    }
    public List<Category> findAllByName(String name) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select category From Category category where category.name = :name ");
        query.setParameter("name", name);
        List<Category> categoryList = query.list();
        return categoryList;
    }

    public List<Category> findAllByQueryFilterDto(CategoryQueryFilterDto categoryQueryFilterDto) {

        String hql =
                "Select category " +
                        "From Category category " +
                        "JOIN category.film f" +
                        "where 1=1 ";

        if (categoryQueryFilterDto.getId() != null) {
            hql += " and category.id = :cityId";
        }

        if (categoryQueryFilterDto.getName() != null) {
            hql += " and name.city = :name";
        }

        if (categoryQueryFilterDto.getFilmCategory() != null) {
            hql += " and city.country  = :country ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (categoryQueryFilterDto.getId() != null) {
            query.setParameter("cityId", categoryQueryFilterDto.getId());
        }

        if (categoryQueryFilterDto.getFilmCategory() != null) {
            query.setParameter("city", categoryQueryFilterDto.getFilmCategory());
        }

      /*  if (categoryQueryFilterDto.getCountry() != null) {
            query.setParameter("country", categoryQueryFilterDto.getCountry());
        }*/

        List<Category> categoryList = query.list();
        return categoryList;
    }
}
