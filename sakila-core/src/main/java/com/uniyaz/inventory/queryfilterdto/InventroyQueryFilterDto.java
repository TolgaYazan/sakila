package com.uniyaz.inventory.queryfilterdto;

import com.uniyaz.film.domain.Film;
import com.uniyaz.store.domain.Store;

public class InventroyQueryFilterDto {

    private Long id;

    private Store store;

    private Film film;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
