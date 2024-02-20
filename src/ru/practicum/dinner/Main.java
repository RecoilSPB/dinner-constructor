package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Недопустимая команда");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
//        initMock();

        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        ArrayList<String> dish = dc.getDishByType(dishType);
        dish.add(dishName);
        dc.menuDishes.put(dishType, dish);// добавьте новое блюдо
    }



    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        ArrayList<String> selectedDishTypes = new ArrayList<>();

        // Ввод типов блюд
        while (true) {
            String dishType = scanner.nextLine();
            if (dishType.isEmpty()) {
                break;
            }
            if (!dc.checkType(dishType)) {
                System.out.println("Такого типа блюда не существует. Пожалуйста, введите другой тип:");
                continue;
            }
            selectedDishTypes.add(dishType);
        }

        Random random = new Random();
        // Генерация комбинаций блюд и вывод на экран
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (String dishType : selectedDishTypes) {
                ArrayList<String> dishes = dc.getDishByType(dishType);
                String randomDish = dishes.get(random.nextInt(dishes.size()));
                combo.add(randomDish);
            }
            System.out.println(combo);
        }
    }
}
