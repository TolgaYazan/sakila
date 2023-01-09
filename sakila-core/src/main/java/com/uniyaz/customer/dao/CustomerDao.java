package com.uniyaz.customer.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CustomerDao {
    public List<Customer> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select customer From Customer customer");
        List<Customer> customerList = query.list();
        return customerList;
    }

    public List<Customer> findAllByQueryFilterDto(CustomerQueryFilter customerQueryFilter) {

        String hql =
                "Select customer " +
                        "From Customer customer " +
                        "Left Join fetch customer.store id " +
                        "Left Join fetch customer.address district " +
                        "where 1=1 ";

        if (customerQueryFilter.getId() != null) {
            hql += " and customer.id = :id";
        }

        if (customerQueryFilter.getFirstName() != null) {
            hql += " and customer.firstName = :firstName";
        }

        if(customerQueryFilter.getAddress()!=null){
            hql += " and customer.address.district = :district";
        }

        if(customerQueryFilter.getStore()!=null){
            hql += " and customer.store.id = :store_id";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (customerQueryFilter.getId() != null) {
            query.setParameter("id", customerQueryFilter.getId());
        }

        if (customerQueryFilter.getFirstName() != null) {
            query.setParameter("firstName", customerQueryFilter.getFirstName());
        }

        if (customerQueryFilter.getStore() != null) {
            query.setParameter("store_id", customerQueryFilter.getStore().getId());
        }

        if (customerQueryFilter.getAddress() != null) {
            query.setParameter("district", customerQueryFilter.getAddress().getDistrict());
        }

        List<Customer> customerList = query.list();
        return customerList;
    }
}
