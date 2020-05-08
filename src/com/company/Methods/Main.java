package com.company.Methods;

public class Main {
    public static DBManagerInterface dataBase;

    public static void main(String[] args) {

        dataBase = new DBManager();
        dataBase.connect();


    }
}
