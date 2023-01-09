package com.uniyaz.store.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilter;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class StoreDao {
    public List<Store> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select store From Store store");
        List<Store> storeList = query.list();
        return storeList;
    }

    public List<Store> findAllByQueryFilterDto(StoreQueryFilter storeQueryFilter) {

        String hql =
                "Select store " +
                        "From Store store " +
                        "Left Join fetch store.address district " +
                        "where 1=1 ";

        if (storeQueryFilter.getId() != null) {
            hql += " and store.id = :storeId";
        }

        if (storeQueryFilter.getAddress() != null) {
            hql += " and store.address.district = :district";
        }



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (storeQueryFilter.getId() != null) {
            query.setParameter("storeId", storeQueryFilter.getId());
        }

        if (storeQueryFilter.getAddress() != null) {
            query.setParameter("district", storeQueryFilter.getAddress().getDistrict());
        }



        List<Store> storeList = query.list();
        return storeList;
    }


}
