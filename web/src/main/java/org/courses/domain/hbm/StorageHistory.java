package org.courses.domain.hbm;

import org.courses.data.DAO.hbm.EntityWithID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class StorageHistory implements EntityWithID {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "socks")
    private int socks;

    @Column(name = "storage")
    private int storage;

    @Column(name = "put_on")
    private String putOn;

    @Column(name = "take_off")
    private String takeOff;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getPutOn() {
        return putOn;
    }

    public void setPutOn(String putOn) {
        this.putOn = putOn;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getSocks() {
        return socks;
    }

    public void setSocks(int socks) {
        this.socks = socks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
