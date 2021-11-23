package com.company.controller;

import com.company.model.Owner;

import java.sql.*;
import java.util.*;

public class OwnerController {

    private final List<Owner> listOwner = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public final String url = "jdbc:postgresql://localhost:5432/";
    public final String databaseName = "a";
    public final String username = "postgres";
    public final String password = "1111";

    public OwnerController() {
    }

    public void addOwner() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();

                Owner owner = new Owner();
                System.out.println("Добавление нового владельца");
                System.out.println("Введите имя владельца");
                owner.setName(scanner.nextLine());
                while (owner.getName().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    owner.setName(scanner.nextLine());
                }

                String name = owner.getName();// имя владельца

                System.out.println("Введите тип лица");
                owner.setFaceType(scanner.nextLine());
                while (owner.getFaceType().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    owner.setFaceType(scanner.nextLine());
                }

                String faceType = owner.getFaceType();// тип владельца
                System.out.println("Введите номер");
                Phone phoneBY = new Phone();
                Boolean isNum = true;
                while (isNum) {
                    System.out.println("Введите номер!");
                    String num = scanner.nextLine();
                    // phoneBY.validator(num);
                    if (phoneBY.validator(num) == false) {
                        System.out.println("Введите верно!");
                    } else {
                        owner.setNumber(num);
                        isNum = false;
                    }
                }

                String number = owner.getNumber();// номер владельца

                listOwner.add(owner);

                System.out.println("Владелец добавлен в список");

                System.out.println("Владелец добавлен в таблицу...");
                int rows = statement.executeUpdate("INSERT INTO owner (NameOwner,FaceType,Number) VALUES ('" + name + "','" + faceType + "','" + number + "')");
                System.out.printf("Added %d rows", rows);
            }

        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }

    }

    public void viewOwner() {
        for (Owner owner : listOwner) {
            System.out.println("Владелец : " + owner.getName() + " " + owner.getFaceType() + " " + owner.getNumber());
        }
    }

    public void editingOwner() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                System.out.println("Изменить владельца?");
                System.out.println("Введите номер владельца");
                String num = scanner.nextLine();
                String name = null,
                        faceType = null,
                        number = null;
                for (Owner o : listOwner) {
                    if (o.getNumber().equals(num)) {
                        System.out.println("Новое имя");
                        o.setName(scanner.nextLine());
                        while (o.getName().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            o.setName(scanner.nextLine());
                        }
                        name = o.getName();// имя владельца
                        System.out.println("Новое тип лица");
                        o.setFaceType(scanner.nextLine());
                        while (o.getFaceType().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            o.setFaceType(scanner.nextLine());
                        }
                        faceType = o.getFaceType();// тип владельца
                        System.out.println("Новый номер");
                        o.setNumber(scanner.nextLine());
                        while (o.getNumber().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            o.setNumber(scanner.nextLine());
                        }
                        number = o.getNumber();// номер владельца
                    }
                }

                System.out.println("Данные поменялись!");
                System.out.println("Владелец  в таблицу...");
                int rows = statement.executeUpdate("UPDATE owner SET NameOwner = '" + name + "', FaceType = '" + faceType + "', Number = '" + number + "' WHERE Number = '" + num + "';");
                System.out.printf("Added %d rows", rows);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void deleteOwner() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {
                Statement statement = conn.createStatement();
                System.out.println("Удаление -_- :");
                Owner ownerDelete = new Owner();
                System.out.println("Введите имя владельца");
                ownerDelete.setName(scanner.nextLine());
                while (ownerDelete.getName().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    ownerDelete.setName(scanner.nextLine());
                }

                System.out.println("Введите тип лица");
                ownerDelete.setFaceType(scanner.nextLine());
                while (ownerDelete.getFaceType().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    ownerDelete.setFaceType(scanner.nextLine());
                }

                System.out.println("Введите номер");
                ownerDelete.setNumber(scanner.nextLine());
                while (ownerDelete.getNumber().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    ownerDelete.setNumber(scanner.nextLine());
                }
                String number = ownerDelete.getNumber();// телефон
                listOwner.removeIf(del -> del.equals(ownerDelete));
                System.out.println("Объект удален из списка");
                int rows = statement.executeUpdate("DELETE FROM owner WHERE Number = '" + number + "';");
                System.out.println("Объект удален из таблицы");
                System.out.printf("Updated %d rows", rows);

            }

        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }

    }

    //вывод метод добавляет данные которые уже хранятся в таблице

    public void tableOwner() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                Owner owner = new Owner();
                int index = 0;
                ResultSet resultSet = statement.executeQuery("SELECT * FROM owner");
                while (resultSet.next()) {
                    ++index;
                    String name = resultSet.getString(1);
                    owner.setName(name);
                    String faceType = resultSet.getString(2);
                    owner.setFaceType(faceType);
                    String number = resultSet.getString(3);
                    owner.setNumber(number);
                    System.out.println("Добавлен");
                    listOwner.add(index,owner);
                    System.out.printf(" %s - %s - %s \n", name, faceType, number);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void inquiryOwner() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM owner WHERE Number ~'1'"); // ПРИДУМАТЬ ЗАПРОС
                while (resultSet.next()) {

                    String name = resultSet.getString(1);
                    String faceType = resultSet.getString(2);
                    String number = resultSet.getString(3);
                    System.out.printf(" %s - %s - %s \n", name, faceType, number);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }
}