package com.uniyaz.adress.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.adress.domain.Address;
import com.uniyaz.adress.queryfilterdto.AddressQueryFilterDto;
import com.uniyaz.city.domain.City;
import com.uniyaz.city.queryfilterdto.CityQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public class AddressDao {

    public List<Address> findAll() {
        SessionFactory sessionFAddressy = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFAddressy.openSession();
        Query query = currentSession.createQuery("Select address From Address address");
        List<Address> AddressList = query.list();
        return AddressList;
    }

    public List<Address> findAllByQueryFilterDto(AddressQueryFilterDto addressQueryFilterDto) {

        String hql =
                "Select address " +
                        "From Address address " +
                        "Left Join fetch address.city city " +
                        "where 1=1 ";

        if (addressQueryFilterDto.getId() != null) {
            hql += " and address.id = :addressId";
        }

        if (addressQueryFilterDto.getDistrict()!= null) {
            hql += " and address.district = :district";
        }
        if (addressQueryFilterDto.getAddress()!= null) {
            hql += " and address.address = :address";
        }


        if (addressQueryFilterDto.getCity() != null) {
            hql += " and address.city.city = :city ";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (addressQueryFilterDto.getId() != null) {
            query.setParameter("addressId", addressQueryFilterDto.getId());
        }

        if (addressQueryFilterDto.getDistrict() != null) {
            query.setParameter("district", addressQueryFilterDto.getDistrict());
        }

        if (addressQueryFilterDto.getAddress()!= null) {
            query.setParameter("address", addressQueryFilterDto.getAddress());
        }

        if (addressQueryFilterDto.getCity() != null) {
            query.setParameter("city", addressQueryFilterDto.getCity().getCity());
        }

        List<Address> addressesList = query.list();
        return addressesList;
    }
}
