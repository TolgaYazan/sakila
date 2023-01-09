package com.uniyaz.payment.service;

import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.film.dao.FilmDao;
import com.uniyaz.film.domain.Film;
import com.uniyaz.payment.dao.PaymentDao;
import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.queryfilterdto.PaymentQueryFilter;
import com.uniyaz.rental.dao.RentalDao;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;

import java.util.List;

public class PaymentService {


    public List<Payment> findAll() {
        PaymentDao paymentDao = new PaymentDao();
        return paymentDao.findAll();
    }
   public List<Payment> findAllByQueryFilterDto(PaymentQueryFilter paymentQueryFilter) {
        PaymentDao paymentDao = new PaymentDao();
        return paymentDao.findAllByQueryFilterDto(paymentQueryFilter);
    }

    public List<Payment> findAllByQueryFilterDtoCriteria(PaymentQueryFilter paymentQueryFilter) {
        PaymentDao paymentDao = new PaymentDao();
        return paymentDao.findAllByQueryFilterDtoCriteria(paymentQueryFilter);
    }
}
