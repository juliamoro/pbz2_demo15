package com.company.view;

import com.company.controller.CityController;
import com.company.controller.OwnerController;
import com.company.controller.PopularityConnection;

import java.util.Scanner;

public class View {

    public Scanner s = new Scanner(System.in);

    public View() {
    }

    public void main() {
        boolean isWork = true;
        while (isWork) {
            textMenu();
            int ch = s.nextInt();
            s.nextLine();
            switch (ch) {
                case 1:
                    mainCity();
                    break;
                case 2:
                    mainOwner();
                    break;
                case 3:
                    mainPopularity();
                    break;
                case 4:
                    isWork = false;
                    System.out.println("Выход !");
                    break;
                default:
                    System.out.println(" Неверный ввод данных ! Введите еще раз !");
                    textMenu();
            }
        }
    }

    public void textMenu() {
        System.out.println("-------------------");
        System.out.println("1) Объекты города ");
        System.out.println("2) Владельцы ");
        System.out.println("3) Популярность объектов ");
        System.out.println("4) Выход ");
        System.out.println("-------------------");
    }

    public void textCity() {
        System.out.println("-----------------------------");
        System.out.println(" * Функции Объекта города * ");
        System.out.println("1) Добавление ");
        System.out.println("2) Редактирование ");
        System.out.println("3) Удаление");
        System.out.println("4) Запрос 1");
        System.out.println("5) Демонстрация данных");
        System.out.println("6) Выход ");
        System.out.println("-----------------------------");
    }

    public void textOwner() {
        System.out.println("-----------------------------");
        System.out.println(" * Функции Владельца * ");
        System.out.println("1) Добавление ");
        System.out.println("2) Редактирование ");
        System.out.println("3) Удаление");
        System.out.println("4) Запрос 2");
        System.out.println("5) Демонстрация данных");
        System.out.println("6) Выход ");
        System.out.println("-----------------------------");
    }

    public void textPopularity() {
        System.out.println("-----------------------------");
        System.out.println(" * Функции Популярности объекта * ");
        System.out.println("1) Добавление ");
        System.out.println("2) Редактирование ");
        System.out.println("3) Удаление");
        System.out.println("4) Запрос 3");
        System.out.println("5) Демонстрация данных");
        System.out.println("6) Выход ");
        System.out.println("-----------------------------");
    }

    public void mainCity() {
        CityController city = new CityController();
        System.out.println("Вызов метода для взятия данных из таблицы");
        city.tableCity();
        textCity();
        boolean isWork = true;
        while (isWork) {
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    city.addCity();
                    break;
                case 2:
                    city.editingCity();
                    break;
                case 3:
                    city.deleteCity();
                    break;
                case 4:
                    city.inquiryCity();
                    break;
                case 5:
                    city.viewCity();
                    break;
                case 6:
                    isWork = false;
                    System.out.println("Выход !");
                    break;
                default:
                    System.out.println(" Неверный ввод данных ! Введите еще раз !");
                    textCity();
            }
        }
        main();
    }

    public void mainOwner() {
        OwnerController owner = new OwnerController();
        System.out.println("Вызов метода для взятия данных из таблицы");
        owner.tableOwner();
        textOwner();
        boolean isWork = true;
        while (isWork) {
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    owner.addOwner();
                    break;
                case 2:
                    owner.editingOwner();
                    break;
                case 3:
                    owner.deleteOwner();
                    break;
                case 4:
                    owner.inquiryOwner();
                    break;
                case 5:
                    owner.viewOwner();
                    break;
                case 6:
                    isWork = false;
                    System.out.println("Выход !");
                    break;
                default:
                    System.out.println(" Неверный ввод данных ! Введите еще раз !");
                    textOwner();
            }
        }
        main();
    }

    public void mainPopularity() {
        PopularityConnection popularity = new PopularityConnection();
        System.out.println("Вызов метода для взятия данных из таблицы");
        popularity.tablePopularity();
        textPopularity();
        boolean isWork = true;
        while (isWork) {
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    popularity.addPopularity();
                    break;
                case 2:
                    popularity.editingPopularity();
                    break;
                case 3:
                    popularity.deletePopularity();
                    break;
                case 4:
                    popularity.inquiryPopularity();
                    break;
                case 5:
                    popularity.viewPopularity();
                    break;
                case 6:
                    isWork = false;
                    System.out.println("Выход !");
                    break;
                default:
                    System.out.println(" Неверный ввод данных ! Введите еще раз !");
                    textPopularity();
            }
        }
        main();
    }

}
