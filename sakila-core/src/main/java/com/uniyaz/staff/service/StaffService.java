package com.uniyaz.staff.service;

import com.uniyaz.city.dao.CityDao;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.staff.dao.StaffDao;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;

import java.util.List;

public class StaffService {

    public List<Staff> findAll() {
        StaffDao staffDao = new StaffDao();
        return staffDao.findAll();
    }

    public List<Staff> findAllByQueryFilterDto(StaffQueryFilterDto staffQueryFilterDto) {
        StaffDao staffDao = new StaffDao();
        return staffDao.findAllByQueryFilterDto(staffQueryFilterDto);
    }
}
