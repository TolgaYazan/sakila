package com.uniyaz.inventory.service;

import com.uniyaz.inventory.dao.InventoryDao;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.dao.InventoryDao;
import com.uniyaz.inventory.domain.Inventory;

import com.uniyaz.inventory.queryfilterdto.InventroyQueryFilterDto;

import java.util.List;

public class InventoryService {
    public List<Inventory> findAll() {
        InventoryDao inventoryDao = new InventoryDao();
        return inventoryDao.findAll();
    }

    public List<Inventory> findAllByQueryFilterDto(InventroyQueryFilterDto inventoryQueryFilter) {
        InventoryDao inventoryDao = new InventoryDao();
        return inventoryDao.findAllByQueryFilterDto(inventoryQueryFilter);
    }
}
