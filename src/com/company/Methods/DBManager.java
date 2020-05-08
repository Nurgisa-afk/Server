package com.company.Methods;

import com.company.Entity.Player;
import com.company.Entity.User;
import com.company.Entity.Userforbudget;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class DBManager implements DBManagerInterface{
    private Connection connection;

    public DBManager() {
    }

    public void connect() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("config.txt"));
            String driver = bufferedReader.readLine();
            String hostName = bufferedReader.readLine();
            String port = bufferedReader.readLine();
            String DBName = bufferedReader.readLine();
            String parameters = bufferedReader.readLine();
            String username = bufferedReader.readLine();
            String pass = bufferedReader.readLine();

            Class.forName(driver);

            connection = DriverManager.getConnection(hostName + port + "/" + DBName + "?" + parameters, username, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean registrationForm(String user_name) {
        String name = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_name=?");
            statement.setString(1, user_name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                return false;


            }
            resultSet.close();
            statement.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;
    }

    public void useradd(User user, String password) {

        try {


            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id,password, user_name, country, position,club_name, budget) " +
                    "VALUES( null,?, ?, ?, ?, ?, ?)");

            statement.setString(1, password);
            statement.setString(2, user.getName());
            statement.setString(3, user.getCountry());
            statement.setString(4, "user");
            statement.setString(5, user.getCity());
            statement.setInt(6, 100);//when adding a student we will not specify group->group_id is null


            statement.executeUpdate();

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void userUpdate(User user){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET country=?, club_name=? WHERE user_name=?");
            statement.setString(1,user.getCountry());
            statement.setString(2,user.getClubName());
            statement.setString(3,user.getName());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkLoginForm(String user_name, String password) {
        String name = null;
        String pass = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_name=?");
            statement.setString(1, user_name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                name = resultSet.getString("user_name");
                pass = resultSet.getString("password");

                resultSet.close();
                statement.close();

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user_name.equals(name)&&password.equals(pass);
    }

    public Userforbudget getOneUser(String name){

        Userforbudget userforbudget = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_name=?");
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                String namee = resultSet.getString("user_name");
                int id = resultSet.getInt("id");
                int budget = resultSet.getInt("budget");
                String country = resultSet.getString("country");
                String clubName = resultSet.getString("club_name");
            userforbudget = new Userforbudget(namee,id,clubName,country,"almaty",budget);
            }


            resultSet.close();
            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }

        return userforbudget;
    }
        public ArrayList<Player> getPlayer(String positions){
        ArrayList<Player> players = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM players WHERE position=?");
            statement.setString(1,positions);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                players.add(new Player(resultSet.getString("full name"),resultSet.getInt("age"),resultSet.getString("club name"),resultSet.getString("position"),
                        resultSet.getDouble("price"),resultSet.getInt("total points")));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return players;
        }


}
