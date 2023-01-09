package com.uniyaz.store.service;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.customer.domain.Customer;
import com.uniyaz.rental.domain.Rental;
import com.uniyaz.rental.queryfilterdto.RentalQueryFilter;
import com.uniyaz.rental.service.RentalService;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilter;
import org.junit.Test;

import java.util.List;

public class StoreServiceTest {

    @Test
    public void findAllTest() {

        StoreService storeService = new StoreService();
        List<Store> storeList = storeService.findAll();
        for (Store store : storeList) {
            System.out.println(store);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        StoreService storeService = new StoreService();
        StoreQueryFilter storeQueryFilter = new StoreQueryFilter();
        Address address = new Address();
      address.setDistrict("Alberta");
        storeQueryFilter.setAddress(address);
         storeQueryFilter.setId(1L);
        List<Store> storeList = storeService.findAllByQueryFilterDto(storeQueryFilter);
        for (Store store : storeList) {
            System.out.println(store);
        }
    }
}
