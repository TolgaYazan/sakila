package com.uniyaz.staff.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import com.uniyaz.staff.domain.Staff;
import com.uniyaz.staff.queryfilterdto.StaffQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StaffDao {
    public List<Staff> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select staff From Staff staff");
        List<Staff> staffList = query.list();
        return staffList;
    }

    public List<Staff> findAllByQueryFilterDto(StaffQueryFilterDto staffQueryFilterDto) {

        String hql =
                "Select staff " +
                        "From Staff staff " +
                        "Left Join fetch staff.address district " +
                        "where 1=1 ";

        if (staffQueryFilterDto.getId() != null) {
            hql += " and staff.id = :staffId";
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            hql += " and staff.firstName = :firstName";
        }

        if (staffQueryFilterDto.getLastName() != null) {
            hql += " and staff.lastName = :lastName";
        }

        if (staffQueryFilterDto.getAddress() != null) {
            hql += " and staff.address.district = :district ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (staffQueryFilterDto.getId() != null) {
            query.setParameter("staffId", staffQueryFilterDto.getId());
        }

        if (staffQueryFilterDto.getFirstName() != null) {
            query.setParameter("firstName", staffQueryFilterDto.getFirstName());
        }

        if (staffQueryFilterDto.getLastName() != null) {
            query.setParameter("lastName", staffQueryFilterDto.getLastName());
        }

        if (staffQueryFilterDto.getAddress() != null) {
            query.setParameter("district", staffQueryFilterDto.getAddress().getDistrict());
        }

        List<Staff> staffList = query.list();
        return staffList;
    }

}
