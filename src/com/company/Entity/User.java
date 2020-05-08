package com.company.Entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int id;
    private String clubName;
    private String country;
    private String city;


    public User(String name, int id, String clubName, String country, String city) {
        this.name = name;
        this.id = id;
        this.clubName = clubName;
        this.country = country;
        this.city = city;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name+" "+id+" "+clubName+" "+country+" "+city;
    }
}
