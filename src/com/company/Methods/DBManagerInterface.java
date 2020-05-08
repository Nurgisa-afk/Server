package com.company.Methods;

import com.company.Entity.Player;
import com.company.Entity.User;
import com.company.Entity.Userforbudget;

import java.util.ArrayList;

public interface DBManagerInterface {
    public boolean registrationForm(String user_name);
    public void useradd(User user, String password);
    public void userUpdate(User user);
    public boolean checkLoginForm(String user_name, String password);
    public Userforbudget getOneUser(String name);
    public ArrayList<Player> getPlayer(String positions);
    public void connect();
}

