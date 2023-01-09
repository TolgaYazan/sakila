package com.uniyaz.city.service;

import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.country.domain.Country;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.payment.domain.Payment;
import com.uniyaz.payment.queryfilterdto.PaymentQueryFilter;
import com.uniyaz.payment.service.PaymentService;
import org.junit.Test;

import java.util.List;

public class CityServiceTest {

    @Test
    public void findAllTest() {

        CityService cityService = new CityService();
        List<City> cityList = cityService.findAll();
        for (City city : cityList) {
            System.out.println(city);
        }
    }
    @Test
    public void findAllTestQueryFilter() {

        CityService cityService = new CityService();
        CityQueryFilterDto cityQueryFilterDto = new CityQueryFilterDto();
        Country country = new Country();
        country.setCountry("Belarus");
        cityQueryFilterDto.setCountry(country);
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<City> cityList = cityService.findAllByQueryFilterDto(cityQueryFilterDto);
        for (City city1 : cityList) {
            System.out.println(city1);
        }
    }
}
