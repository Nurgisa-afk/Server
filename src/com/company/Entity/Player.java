package com.company.Entity;

import java.io.Serializable;

public class Player implements Serializable {
    private String fullName;
    private int age;
    private String clubName;
    private String position;
    private double price;
    private int point;

    public Player(String fullName, int age, String clubName, String position, double price, int point) {
        this.fullName = fullName;
        this.age = age;
        this.clubName = clubName;
        this.position = position;
        this.price = price;
        this.point = point;
    }

    public Player() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", clubName='" + clubName + '\'' +
                ", position='" + position + '\'' +
                ", price=" + price +
                ", point=" + point +
                '}';
    }
}
