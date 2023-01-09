package com.uniyaz.adress.service;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.adress.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.category.domain.Category;
import com.uniyaz.category.service.CategoryService;
import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilter;
import com.uniyaz.customer.service.CustomerService;
import org.junit.Test;

import java.util.List;

public class AddressServiceTest {

    @Test
    public void findAllTest() {

        AddressService addressService = new AddressService();
        List<Address> addressesList = addressService.findAll();
        for (Address address : addressesList) {
            System.out.println(address);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        AddressService addressService = new AddressService();
        AddressQueryFilterDto addressQueryFilterDto = new AddressQueryFilterDto();

        City city = new City();
        city.setCity("Kingstown");

        addressQueryFilterDto.setDistrict("St George");
        addressQueryFilterDto.setCity(city);
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<Address> addressList = addressService.findAllByQueryFilterDto(addressQueryFilterDto);
        for (Address address : addressList) {
            System.out.println(address);
        }
    }





}
