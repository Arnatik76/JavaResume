package com.prj;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private static Socket socket;
    private static ObjectInputStream inputStream;
    private static ObjectOutputStream outputStream;
    public static void connect() {
        try {
            socket = new Socket("127.0.0.1", 12975);
            System.out.println("Connected to server!");
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            closeResources();
            e.printStackTrace();
        }
    }

    public static boolean checkPasswordAndLogin(String nickName, String password) {
        try {
            outputStream.writeObject(new PackageData(0, new User(nickName, password)));
            PackageData packageData = (PackageData) inputStream.readObject();
            if (packageData.getOperationType() == 3) {
                return false;
            }
            String storedNickName = packageData.getUser().getNickName();
            String storedPassword = packageData.getUser().getPassword();

            if (storedPassword == null)
                return false;

            return storedPassword.equals(password) && storedNickName.equals(nickName);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        return false;
    }

    public static boolean addUser(String nickName, String password) {
        try {
            outputStream.writeObject(new PackageData(1, new User(nickName, password)));
            PackageData packageData = (PackageData) inputStream.readObject();

            return packageData.getOperationType() == 2;
        } catch (Exception e) {}

        return false;
    }

    public static ArrayList<String> getGenreList() {
        ArrayList<String> list = new ArrayList<>();
        try {
            outputStream.writeObject(new PackageData(4));
            return (ArrayList<String>) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    private static void closeResources() {
        try {
            if (socket != null) {
                socket.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
