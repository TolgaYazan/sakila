package com.uniyaz.inventory.service;

import com.uniyaz.film.domain.Film;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.queryfilterdto.InventroyQueryFilterDto;
import com.uniyaz.inventory.service.InventoryService;
import com.uniyaz.country.domain.Country;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.service.InventoryService;
import com.uniyaz.filmactor.domain.FilmActor;
import com.uniyaz.filmactor.service.FilmActorService;
import com.uniyaz.store.domain.Store;
import org.junit.Test;

import java.util.List;

public class InventoryServiceTest {

    @Test
    public void findAllTest() {

        InventoryService inventoryService = new InventoryService();
        List<Inventory> inventoryList = inventoryService.findAll();
        for (Inventory inventory : inventoryList) {
            System.out.println(inventory);
        }
    }

    @Test
    public void findAllTestQueryFilter() {

        InventoryService inventoryService = new InventoryService();
        InventroyQueryFilterDto inventoryQueryFilterDto = new InventroyQueryFilterDto();
        Film film = new Film();
        film.setTitle("ACADEMY DINOSAUR");

        Store store = new Store();
        store.setId(2L);

        inventoryQueryFilterDto.setFilm(film);
        inventoryQueryFilterDto.setStore(store);
        List<Inventory> inventoryList = inventoryService.findAllByQueryFilterDto(inventoryQueryFilterDto);
        for (Inventory inventory1 : inventoryList) {
            System.out.println(inventory1);
        }
    }
}
