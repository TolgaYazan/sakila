package com.uniyaz.staff.service;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;
import com.uniyaz.store.domain.Store;
import com.uniyaz.store.queryfilterdto.StoreQueryFilter;
import com.uniyaz.store.service.StoreService;
import org.junit.Test;

import java.util.List;

public class StaffServiceTest {
    @Test
    public void findAllTest() {

        StaffService staffService = new StaffService();
        List<Staff> staffList = staffService.findAll();
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }
    @Test
    public void findAllTestQueryFilter() {

        StaffService staffService = new StaffService();
        StaffQueryFilterDto staffQueryFilterDto = new StaffQueryFilterDto();
        Address address = new Address();
        address.setDistrict("Alberta");
        staffQueryFilterDto.setAddress(address);
      //  staffQueryFilterDto.setId(2L);
        List<Staff> storeList = staffService.findAllByQueryFilterDto(staffQueryFilterDto);
        for (Staff staff : storeList) {
            System.out.println(staff);
        }
    }

}
