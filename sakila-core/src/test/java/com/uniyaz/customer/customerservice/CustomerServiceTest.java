package com.uniyaz.customer.customerservice;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.city.service.CityService;
import com.uniyaz.country.domain.Country;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.customer.queryfilterdto.CustomerQueryFilter;
import com.uniyaz.customer.service.CustomerService;
import org.junit.Test;

import java.util.List;

public class CustomerServiceTest {
    @Test
    public void findAllTest() {

        CustomerService customerService = new CustomerService();
        List<Customer> customerList = customerService.findAll();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        CustomerService customerService = new CustomerService();
        CustomerQueryFilter customerQueryFilter = new CustomerQueryFilter();

        Address address = new Address();
        address.setDistrict("Nagasaki");

        customerQueryFilter.setAddress(address);
        customerQueryFilter.setFirstName("MARY");
        //paymentQueryFilter.setCustomer(customer);
        //paymentQueryFilter.setId(1L);
        List<Customer> customerList = customerService.findAllByQueryFilterDto(customerQueryFilter);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
