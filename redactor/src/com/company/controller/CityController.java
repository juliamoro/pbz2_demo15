package com.company.controller;

import com.company.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityController {

    private final List<City> listCity = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public final String url = "jdbc:postgresql://localhost:5432/";
    public final String databaseName = "city";
    public final String username = "postgres";
    public final String password = "1111";

    public CityController() {
    }

    public void addCity() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();

                City city = new City();
                System.out.println("Добавление нового объекта");
                System.out.println("Введите имя объект");
                city.setName(scanner.nextLine());
                while (city.getName().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setName(scanner.nextLine());
                }

                String name = city.getName();// имя объекта

                System.out.println("Введите тип объекта");
                city.setType(scanner.nextLine());
                while (city.getType().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setType(scanner.nextLine());
                }

                String type = city.getType();// тип объекта

                System.out.println("Введите адрес объекта");
                city.setAddress(scanner.nextLine());
                while (city.getAddress().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setAddress(scanner.nextLine());
                }

                String address = city.getAddress();// адрес объекта

                boolean isCol = true;
                int col = 0;
                while (isCol){
                    System.out.println("Новое кол мест в объекте (от 10 до 300)");
                    col = scanner.nextInt();
                    scanner.nextLine();
                    if(col >= 10 && col <= 300){
                        System.out.println("Введено");
                        city.setNumberSeats(col);
                        isCol = false;
                    }
                    else {
                        System.out.println("Неверно введены данные");
                    }
                }

                int numberSeats = col;// кол мест объекта

                System.out.println("Введите дата открытия объекта");
                city.setOpening(scanner.nextLine());
                while (city.getOpening().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setOpening(scanner.nextLine());
                }

                String opening = city.getOpening(); // дата открытия объекта

                System.out.println("Введите сезон объекта");
                city.setSeasonOpen(scanner.nextLine());
                while (city.getSeasonOpen().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setSeasonOpen(scanner.nextLine());
                }

                String seasonOpen = city.getSeasonOpen(); // сезон объекта

                System.out.println("Введите владельца объекта");
                city.setOwner(scanner.nextLine());
                while (city.getOwner().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setOwner(scanner.nextLine());
                }

                String оw = city.getOwner(); // сезон объекта

                listCity.add(city);

                System.out.println("Объект добавлен в список");

                System.out.println("Владелец добавлен в таблицу...");
                int rows = statement.executeUpdate("INSERT INTO city (Name,Type,Address,Place,Data,Season,Owner) VALUES ('" + name + "','" + type + "','" + address + "'," + numberSeats + ",'" + opening + "','" + seasonOpen + "','" + оw + "')");
                System.out.printf("Added %d rows", rows);//(+)
            }

        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }

    }

    public void viewCity() {
        for (City city : listCity) {
            System.out.println("Объект : " + city.getName() + " " + city.getType() + " " + city.getAddress() + " " + city.getNumberSeats() + " " + city.getOpening() + " " + city.getSeasonOpen() +
                    " " + city.getOwner());
        }
    }

    public void editingCity() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                System.out.println("Изменить владельца?");
                System.out.println("Введите  владельца");
                String num = scanner.nextLine();
                String name = null,
                        type = null,
                        address = null,
                        opening = null,
                        seasonOpen = null,
                        оw = null;
                int numberSeats = 0;
                for (City c : listCity) {
                    if (c.getOwner().equals(num)) {
                        System.out.println("Новое имя объект");
                        c.setName(scanner.nextLine());
                        while (c.getName().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            c.setName(scanner.nextLine());
                        }

                        name = c.getName();// имя объекта

                        System.out.println("Новое тип объекта");
                        c.setType(scanner.nextLine());
                        while (c.getType().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            c.setType(scanner.nextLine());
                        }

                        type = c.getType();// тип объекта

                        System.out.println("Новое адрес объекта");
                        c.setAddress(scanner.nextLine());
                        while (c.getAddress().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            c.setAddress(scanner.nextLine());
                        }

                        address = c.getAddress();// адрес объекта

                        boolean isCol = true;
                        int col = 0;
                        while (isCol){
                            System.out.println("Новое кол мест в объекте (от 10 до 300)");
                            col = scanner.nextInt();
                            scanner.nextLine();
                            if(col >= 10 && col <= 300){
                                System.out.println("Введено");
                                c.setNumberSeats(col);
                                isCol = false;
                            }
                            else {
                                System.out.println("Неверно введены данные");
                            }
                        }

                        numberSeats = c.getNumberSeats();// кол мест объекта

                        System.out.println("Новое дата открытия объекта");
                        c.setOpening(scanner.nextLine());
                        while (c.getOpening().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            c.setOpening(scanner.nextLine());
                        }

                        opening = c.getOpening(); // дата открытия объекта

                        System.out.println("Новое сезон объекта");
                        c.setSeasonOpen(scanner.nextLine());
                        while (c.getSeasonOpen().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            c.setSeasonOpen(scanner.nextLine());
                        }

                        seasonOpen = c.getSeasonOpen(); // сезон объекта

                        System.out.println("Новое владельца объекта");
                        c.setOwner(scanner.nextLine());
                        while (c.getOwner().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            c.setOwner(scanner.nextLine());
                        }

                        оw = c.getOwner(); // сезон объекта

                    }
                }

                System.out.println("Данные поменялись!");
                System.out.println("Владелец  в таблицу...");
                int rows = statement.executeUpdate("UPDATE city SET Name = '" + name + "', Type = '" + type + "', Address = '" + address + "', Place = " + numberSeats + ", Data = '" + opening + "', Season = '" + seasonOpen + "', Owner = '" + оw + "' WHERE Owner = '" + num + "';");
                System.out.printf("Added %d rows", rows);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void deleteCity() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {
                Statement statement = conn.createStatement();
                System.out.println("Удаление -_- :");
                City city = new City();
                System.out.println("Введите имя объект");
                city.setName(scanner.nextLine());
                while (city.getName().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setName(scanner.nextLine());
                }

                String name = city.getName();// имя объекта

                System.out.println("Введите тип объекта");
                city.setType(scanner.nextLine());
                while (city.getType().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setType(scanner.nextLine());
                }

                System.out.println("Введите адрес объекта");
                city.setAddress(scanner.nextLine());
                while (city.getAddress().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setAddress(scanner.nextLine());
                }

                boolean isCol = true;
                int col = 0;
                while (isCol){
                    System.out.println("Новое кол мест в объекте (от 10 до 300)");
                    col = scanner.nextInt();
                    scanner.nextLine();
                    if(col >= 10 && col <= 300){
                        System.out.println("Введено");
                        city.setNumberSeats(col);
                        isCol = false;
                    }
                    else {
                        System.out.println("Неверно введены данные");
                    }
                }

                System.out.println("Введите дата открытия объекта");
                city.setOpening(scanner.nextLine());
                while (city.getOpening().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setOpening(scanner.nextLine());
                }

                System.out.println("Введите сезон объекта");
                city.setSeasonOpen(scanner.nextLine());
                while (city.getSeasonOpen().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setSeasonOpen(scanner.nextLine());
                }

                System.out.println("Введите владельца объекта");
                city.setOwner(scanner.nextLine());
                while (city.getOwner().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    city.setOwner(scanner.nextLine());
                }

                String оw = city.getOwner(); // сезон объекта

                listCity.removeIf(del -> del.equals(city));
                System.out.println("Объект удален из списка");
                int rows = statement.executeUpdate("DELETE FROM city WHERE Name = '" + name + "' AND Owner = '" + оw + "';");// (+)
                System.out.println("Объект удален из таблицы");
                System.out.printf("Updated %d rows", rows);

            }

        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }

    }

    public void tableCity() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                City city = new City();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM city");//(+)
                while (resultSet.next()) {

                    String name = resultSet.getString(1);
                    city.setName(name);
                    String type = resultSet.getString(2);
                    city.setType(type);
                    String address = resultSet.getString(3);
                    city.setAddress(address);
                    int price = resultSet.getInt(4);
                    city.setNumberSeats(price);
                    String opening = resultSet.getString(5);
                    city.setOpening(opening);
                    String seasonOpen = resultSet.getString(6);
                    city.setSeasonOpen(seasonOpen);
                    String owner = resultSet.getString(7);
                    city.setOwner(owner);

                    System.out.println("Добавлен");
                    listCity.add(city);
                    System.out.printf(" %s - %s - %s - %d - %s - %s - %s  \n", name, type, address, price, opening, seasonOpen, owner);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void inquiryCity() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM city WHERE Place BETWEEN 50 AND 150;"); // ПРИДУМАТЬ ЗАПРОС
                while (resultSet.next()) {

                    String name = resultSet.getString(1);
                    String type = resultSet.getString(2);
                    String address = resultSet.getString(3);
                    int price = resultSet.getInt(4);
                    String opening = resultSet.getString(5);
                    String seasonOpen = resultSet.getString(6);
                    String owner = resultSet.getString(7);
                    System.out.printf(" %s - %s - %s - %d - %s - %s - %s  \n", name, type, address, price, opening, seasonOpen, owner);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }
}
