package com.uniyaz.customer.service;

import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.customer.dao.CustomerDao;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilter;
import com.uniyaz.store.dao.StoreDao;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilter;

import java.util.List;

public class CustomerService {
    public List<Customer> findAll() {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.findAll();
    }

    public List<Customer> findAllByQueryFilterDto(CustomerQueryFilter customerQueryFilter) {
        CustomerDao customerDao = new CustomerDao();
        return customerDao.findAllByQueryFilterDto(customerQueryFilter);
    }
}
