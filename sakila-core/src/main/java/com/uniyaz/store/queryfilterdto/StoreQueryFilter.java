package com.uniyaz.store.queryfilterdto;

import com.uniyaz.adress.domain.Address;

public class StoreQueryFilter {
    private Long id;

    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
