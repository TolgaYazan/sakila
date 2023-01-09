package com.uniyaz.rental.service;

import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.film.dao.FilmDao;
import com.uniyaz.film.domain.Film;
import com.uniyaz.rental.dao.RentalDao;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;

import java.util.List;

public class RentalService {
    public List<Rental> findAll() {
        RentalDao rentalDao = new RentalDao();
        return rentalDao.findAll();
    }
    public List<Rental> findAllByQueryFilterDto(RentalQueryFilter rentalQueryFilter) {
        RentalDao rentalDao = new RentalDao();
        return rentalDao.findAllByQueryFilterDto(rentalQueryFilter);
    }
}
