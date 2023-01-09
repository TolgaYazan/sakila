package com.uniyaz.adress.service;

import com.uniyaz.adress.dao.AddressDao;
import com.uniyaz.adress.domain.Address;
import com.uniyaz.adress.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;

import java.util.List;

public class AddressService {
    public List<Address> findAll() {
        AddressDao addressDao  =new AddressDao();
        return addressDao.findAll();
    }
    public List<Address> findAllByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {
        AddressDao addressDao  =new AddressDao();
        return addressDao.findAllByQueryFilterDto(addressQueryFilterDto);
    }
}
