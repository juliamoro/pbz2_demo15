package com.company.controller;

import com.company.model.City;
import com.company.model.Owner;
import com.company.model.Popularity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PopularityConnection {

    public final String url = "jdbc:postgresql://localhost:5432/";
    public final String databaseName = "popularity";// изменить
    public final String username = "postgres";
    public final String password = "1111";

    private final List<Popularity> listPopularity = new ArrayList<>();
    public Scanner scanner = new Scanner(System.in);

    public PopularityConnection() {
    }

    public void addPopularity() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                Popularity p = new Popularity();
                System.out.println("Добавление инф о популярности объекта");
                System.out.println("Введите имя объект");
                p.setCity(scanner.nextLine());
                while (p.getCity().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    p.setCity(scanner.nextLine());
                }

                String name = p.getCity();// имя объекта

                boolean isCol = true;
                int col = 0;
                while (isCol) {
                    System.out.println("Новое кол мест в объекте (от 1 до 10)");
                    col = scanner.nextInt();
                    scanner.nextLine();
                    if (col >= 1 && col <= 10) {
                        System.out.println("Введено");
                        p.setPoint(col);
                        isCol = false;
                    } else {
                        System.out.println("Неверно введены данные");
                    }
                }

                int numberSeats = col;// кол мест объекта

                listPopularity.add(p);

                System.out.println("Объект добавлен в список");

                System.out.println("Владелец добавлен в таблицу...");
                int rows = statement.executeUpdate("INSERT INTO popularity (Name,Place) VALUES ('" + name + "'," + numberSeats + ")");
                System.out.printf("Added %d rows", rows);//(+)
            }

        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void viewPopularity() {
        for (Popularity p : listPopularity) {
            System.out.println("Объект : " + p.getCity() + " " + p.getPoint());
        }
    }

    public void editingPopularity() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                System.out.println("Изменить владельца?");
                System.out.println("Введите номер владельца");
                String num = scanner.nextLine();
                String name = null;
                int col = 0, numberSeats = 0;
                for (Popularity p : listPopularity) {
                    if (p.getCity().equals(num)) {
                        System.out.println("Новое имя объекта");
                        p.setCity(scanner.nextLine());
                        while (p.getCity().isEmpty()) {
                            System.out.println("Введите данные!!!");
                            p.setCity(scanner.nextLine());
                        }
                        name = p.getCity();// имя объекта
                        boolean isCol = true;
                        while (isCol) {
                            System.out.println("Новое кол мест в объекте (от 1 до 10)");
                            col = scanner.nextInt();
                            scanner.nextLine();
                            if (col >= 1 && col <= 10) {
                                System.out.println("Введено");
                                p.setPoint(col);
                                isCol = false;
                            } else {
                                System.out.println("Неверно введены данные");
                            }
                        }
                        numberSeats = col;// кол мест объекта
                    }
                }

                System.out.println("Данные поменялись!");
                System.out.println("Владелец  в таблицу...");
                int rows = statement.executeUpdate("UPDATE popularity SET Name = '" + name + "', Place = " + numberSeats + ";");
                System.out.printf("Added %d rows", rows);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void deletePopularity() {

        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {
                Statement statement = conn.createStatement();
                System.out.println("Удаление -_- :");
                Popularity p = new Popularity();
                System.out.println("Добавление инф о популярности объекта");
                System.out.println("Введите имя объект");
                p.setCity(scanner.nextLine());
                while (p.getCity().isEmpty()) {
                    System.out.println("Введите данные!!!");
                    p.setCity(scanner.nextLine());
                }
                String name = p.getCity();// имя объекта
                boolean isCol = true;
                int col = 0;
                while (isCol) {
                    System.out.println("Новое кол мест в объекте (от 1 до 10)");
                    col = scanner.nextInt();
                    scanner.nextLine();
                    if (col >= 1 && col <= 10) {
                        System.out.println("Введено");
                        p.setPoint(col);
                        isCol = false;
                    } else {
                        System.out.println("Неверно введены данные");
                    }
                }

                int numberSeats = col;// кол мест объекта
                listPopularity.removeIf(del -> del.equals(p));
                System.out.println("Объект удален из списка");
                int rows = statement.executeUpdate("DELETE FROM popularity WHERE Name = '" + name + "';");
                System.out.println("Объект удален из таблицы");
                System.out.printf("Updated %d rows", rows);

            }

        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }

    }

    //вывод метод добавляет данные которые уже хранятся в таблице

    public void tablePopularity() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();
                Popularity p = new Popularity();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM popularity");
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    p.setCity(name);
                    int numberSeats = resultSet.getInt(2);
                    p.setPoint(numberSeats);
                    System.out.println("Добавлен");
                    listPopularity.add(p);
                    System.out.printf(" %s - %d \n", name, numberSeats);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

    public void inquiryPopularity() {
        try {

            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();

            try (Connection conn = DriverManager.getConnection(url + databaseName, username, password)) {

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM popularity WHERE Place ~'10'"); // ПРИДУМАТЬ ЗАПРОС
                while (resultSet.next()) {

                    String name = resultSet.getString(1);
                    int faceType = resultSet.getInt(2);
                    System.out.printf(" %s - %d \n", name, faceType);
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка подключения ...");
            System.out.println(ex);
        }
    }

}
