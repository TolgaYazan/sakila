package com.uniyaz.store.domain;

import com.uniyaz.adress.domain.Address;
import com.uniyaz.common.domain.BaseEntity;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="store")
@Audited
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;
;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    @ForeignKey(name = "fk_store_address")
    private Address address;


    @Column(name = "manager_staff_id", length = 50)
    private String managerStaffId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;


    @Override
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

    public String getCreateDate() {
        return managerStaffId;
    }

    public void setCreateDate(String createDate) {
        this.managerStaffId = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", address=" + address +
                ", createDate='" + managerStaffId + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
