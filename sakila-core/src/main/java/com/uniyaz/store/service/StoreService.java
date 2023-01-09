package com.uniyaz.store.service;

import com.uniyaz.rental.dao.RentalDao;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import com.uniyaz.store.dao.StoreDao;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilter;

import java.util.List;

public class StoreService {
    public List<Store> findAll() {
        StoreDao storeDao = new StoreDao();
        return storeDao.findAll();
    }

    public List<Store> findAllByQueryFilterDto(StoreQueryFilter storeQueryFilter) {
        StoreDao storeDao = new StoreDao();
        return storeDao.findAllByQueryFilterDto(storeQueryFilter);
    }
}
