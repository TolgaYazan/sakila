package com.uniyaz.city.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CityDao {

    public List<City> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select city From City city");
        List<City> cityList = query.list();
        return cityList;
    }

    public City save(City city) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        city = (City) currentSession.merge(city);
        transaction.commit();
        return city;
    }

    public void delete(City city) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Transaction transaction = currentSession.beginTransaction();
        currentSession.delete(city);
        transaction.commit();
    }

    public List<City> findAllByQueryFilterDto(CityQueryFilterDto cityQueryFilterDto) {

        String hql =
                "Select city " +
                "From City city " +
                "where 1=1 ";

        if (cityQueryFilterDto.getId() != null) {
            hql += " and city.id = :cityId";
        }

        if (cityQueryFilterDto.getCity() != null) {
            hql += " and city.city = :city";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (cityQueryFilterDto.getId() != null) {
            query.setParameter("cityId", cityQueryFilterDto.getId());
        }

        if (cityQueryFilterDto.getCity() != null) {
            query.setParameter("city", cityQueryFilterDto.getCity());
        }

        List<City> cityList = query.list();
        return cityList;
    }


    public List<City> findAllByQueryFilterDtoCriteria(CityQueryFilterDto cityQueryFilterDto) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(City.class);

        if (cityQueryFilterDto.getId() != null) {
            criteria.add(Restrictions.eq("id", cityQueryFilterDto.getId()));
        }

        if (cityQueryFilterDto.getCity() != null) {
            criteria.add(Restrictions.eq("city", cityQueryFilterDto.getCity()));
        }

        List<City> cityList = criteria.list();
        return cityList;
    }
}