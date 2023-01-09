package com.uniyaz.payment.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.film.domain.Film;
import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.queryfilterdto.PaymentQueryFilter;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class PaymentDao {

    public List<Payment> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select payment From Payment payment");
        List<Payment> paymentList = query.list();
        return paymentList;
    }

    public List<Payment> findAllByQueryFilterDto(PaymentQueryFilter paymentQueryFilter) {

        String hql =
                "Select payment " +
                        "From Payment payment " +
                        "Left Join fetch payment.rental id " +
                        "Left Join fetch payment.staff firstName " +
                        "Left Join fetch payment.customer firstName " +
                        "where 1=1 ";

        if (paymentQueryFilter.getId() != null) {
            hql += " and payment.id = :id";
        }

        if(paymentQueryFilter.getRental()!=null){
            hql += " and payment.rental.id = :rental";
        }

        if(paymentQueryFilter.getCustomer()!=null){
            hql += " and payment.customer.firstName = :customer";
        }

        if (paymentQueryFilter.getStaff() != null) {
            hql += " and payment.staff.firstName = :staff";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (paymentQueryFilter.getId() != null) {
            query.setParameter("id", paymentQueryFilter.getId());
        }

        if (paymentQueryFilter.getRental() != null) {
            query.setParameter("rental", paymentQueryFilter.getRental().getId());
        }

        if (paymentQueryFilter.getStaff() != null) {
            query.setParameter("staff", paymentQueryFilter.getStaff().getFirstName());
        }

        if (paymentQueryFilter.getCustomer() != null) {
            query.setParameter("customer", paymentQueryFilter.getCustomer().getFirstName());
        }

        List<Payment> paymentList = query.list();
        return paymentList;
    }
    public List<Payment> findAllByQueryFilterDtoCriteria(PaymentQueryFilter paymentQueryFilter) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Criteria criteria = currentSession.createCriteria(Payment.class);
        criteria.createAlias("rental", "rentalAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("staff", "staffAlias", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("customer", "customerAlias", JoinType.LEFT_OUTER_JOIN);


        if (paymentQueryFilter.getId() != null) {
            criteria.add(Restrictions.eq("id", paymentQueryFilter.getId()));
        }


        if (paymentQueryFilter.getCustomer() != null) {
            criteria.add(Restrictions.eq("customerAlias.customer", paymentQueryFilter.getCustomer().getFirstName()));
        }

        if (paymentQueryFilter.getRental() != null) {
            criteria.add(Restrictions.eq("rentalAlias.rental", paymentQueryFilter.getRental().getId()));
        }

        if (paymentQueryFilter.getStaff() != null) {
            criteria.add(Restrictions.eq("staffAlias.staff", paymentQueryFilter.getStaff().getId()));
        }



        List<Payment> paymentList = criteria.list();
        return paymentList;
    }


}
