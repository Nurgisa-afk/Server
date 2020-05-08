package com.company.Methods;

import com.company.Entity.Request;
import com.company.Entity.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DBManagerInterface dataBase = new DBManager();
        dataBase.connect();
        try(ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            Request request;
            while ((request = (Request) inputStream.readObject()) != null){
                System.out.println("CLIENT REQUESTS: " + request.getFuncName());
                switch (request.getFuncName()) {
                    case "registrationForm":
                        outputStream.writeObject(dataBase.registrationForm(request.getSt1()));
                        break;
                    case "useradd":
                        dataBase.useradd((User) request.getObject1(), request.getSt1());
                        break;
                    case "userUpdate":
                        dataBase.userUpdate((User) request.getObject1());
                        break;
                    case "checkLoginForm":
                        outputStream.writeObject(dataBase.checkLoginForm(request.getSt1(), request.getSt2()));
                        break;
                    case "getOneUser":
                        outputStream.writeObject(dataBase.getOneUser(request.getSt1()));
                        break;
                    case "getPlayer":
                        outputStream.writeObject(dataBase.getPlayer(request.getSt1()));
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

