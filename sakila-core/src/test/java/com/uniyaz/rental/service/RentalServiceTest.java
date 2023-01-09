package com.uniyaz.rental.service;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.adress.service.AddressService;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import org.junit.Test;

import java.util.List;

public class RentalServiceTest {
    @Test
    public void findAllTest() {

        RentalService rentalService = new RentalService();
        List<Rental> rentalList = rentalService.findAll();
        for (Rental rental : rentalList) {
            System.out.println(rental);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        RentalService rentalService = new RentalService();
        RentalQueryFilter rentalQueryFilter = new RentalQueryFilter();
      Customer customer = new Customer();
        customer.setFirstName("MARY");
        rentalQueryFilter.setCustomer(customer);
       rentalQueryFilter.setId(1L);
        List<Rental> rentalList = rentalService.findAllByQueryFilterDto(rentalQueryFilter);
        for (Rental rental : rentalList) {
            System.out.println(rental);
        }
    }


}
