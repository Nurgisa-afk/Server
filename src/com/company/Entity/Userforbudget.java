package com.company.Entity;

import java.io.Serializable;

public class Userforbudget extends User implements Serializable {
    private int budget;

    public Userforbudget(String name, int id, String clubName, String country, String city, int budget) {
        super(name, id, clubName, country, city);
        this.budget = budget;
    }

    public Userforbudget(int budget) {
        this.budget = budget;
    }

    public Userforbudget() {
        super();
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
