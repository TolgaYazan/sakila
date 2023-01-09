package com.uniyaz.rental.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RentalDao {

    public List<Rental> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select rental From Rental rental");
        List<Rental> rentalList = query.list();
        return rentalList;
    }

    public List<Rental> findAllByQueryFilterDto(RentalQueryFilter rentalQueryFilter) {

        String hql =
                "Select rental " +
                        "From Rental rental " +
                        "Left Join fetch rental.inventory id " +
                        "Left Join fetch rental.staff  firstName " +
                        "Left Join fetch rental.customer  firstName " +
                        "where 1=1 ";

        if (rentalQueryFilter.getId() != null) {
            hql += " and rental.id = :rentalId";
        }

       if(rentalQueryFilter.getInventory() != null){
           hql += " and rental.inventory.id = :inventory";
       }

        if(rentalQueryFilter.getCustomer() != null){
            hql += " and rental.customer.firstName = :customer";
        }

        if (rentalQueryFilter.getStaff() != null) {
            hql += " and rental.staff.firstName = :staff";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (rentalQueryFilter.getId() != null) {
            query.setParameter("rentalId", rentalQueryFilter.getId());
        }

        if (rentalQueryFilter.getInventory() != null) {
            query.setParameter("inventory", rentalQueryFilter.getInventory().getId());
        }

        if (rentalQueryFilter.getStaff() != null) {
            query.setParameter("staff", rentalQueryFilter.getStaff().getFirstName());
        }

        if (rentalQueryFilter.getCustomer() != null) {
            query.setParameter("customer", rentalQueryFilter.getCustomer().getFirstName());
        }

        List<Rental> rentalList = query.list();
        return rentalList;
    }
}
