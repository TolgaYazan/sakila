package com.uniyaz.inventory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.queryfilterdto.InventroyQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InventoryDao {
    public List<Inventory> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery("Select inventory From Inventory inventory");
        List<Inventory> inventoryList = query.list();
        return inventoryList;
    }

    public List<Inventory> findAllByQueryFilterDto(InventroyQueryFilterDto inventoryQueryFilter) {

        String hql =
                "Select inventory " +
                        "From Inventory inventory " +
                        "Left Join fetch inventory.film title " +
                        "Left Join fetch inventory.store id " +
                        "where 1=1 ";

        if (inventoryQueryFilter.getId() != null) {
            hql += " and inventory.id = :id";
        }

        if(inventoryQueryFilter.getStore() !=null){
            hql += " and inventory.store.id = :store";
        }

        if(inventoryQueryFilter.getFilm() !=null){
            hql += " and inventory.film.title = :title";
        }


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (inventoryQueryFilter.getId() != null) {
            query.setParameter("id", inventoryQueryFilter.getId());
        }

        if (inventoryQueryFilter.getStore() != null) {
            query.setParameter("store", inventoryQueryFilter.getStore().getId());
        }

        if (inventoryQueryFilter.getFilm() != null) {
            query.setParameter("title", inventoryQueryFilter.getFilm().getTitle());
        }



        List<Inventory> inventoryList = query.list();
        return inventoryList;
    }


}
