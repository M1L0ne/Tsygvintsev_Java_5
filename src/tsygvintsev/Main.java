package tsygvintsev;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        int choice;
        int taskNum;
        List<Integer> newList;
        List<String> newStringList;
        HashMap<Integer, List<String>> newMapStringList;
        List<Integer[]> newArrList;

        System.out.println("Для перехода обратно в меню и выхода вводите '-1'");
        do {
            System.out.println("Введите номер задачи (от 1 до 7): ");
            System.out.println("1 - Обобщённая коробка, 2 - Поиск максимума, 3 - Функция");
            System.out.println("4 - Фильтр, 5 - Сокращение, 6 - Коллекционирование");
            try {
                taskNum = sc.nextInt();
                switch (taskNum) {
                    case 1:
                        do {
                            System.out.println("Выберите действие: 1 - создать дробь и вывести значение, 2 - проверить equals, 3 - изменить дробь");
                            choice = sc.nextInt();

                            Fraction f = null;

                            switch (choice) {
                                case 1:
                                    System.out.print("Введите числитель: ");
                                    int num1 = sc.nextInt();
                                    System.out.print("Введите знаменатель: ");
                                    int den1 = sc.nextInt();
                                    try {
                                        f = new Fraction(num1, den1);
                                        System.out.println("Дробь: " + f);
                                        System.out.println("Вещественное значение: " + f.getValue());
                                        System.out.println("(Повторный вызов getValue с кешем)");
                                        System.out.println("Вещественное значение (2-й вызов): " + f.getValue());
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Ошибка: " + e.getMessage());
                                    }
                                    break;

                                case 2:
                                    System.out.println("Создаём две дроби для сравнения.");
                                    System.out.print("Дробь 1 — числитель: ");
                                    int n1 = sc.nextInt();
                                    System.out.print("Дробь 1 — знаменатель: ");
                                    int d1 = sc.nextInt();
                                    System.out.print("Дробь 2 — числитель: ");
                                    int n2 = sc.nextInt();
                                    System.out.print("Дробь 2 — знаменатель: ");
                                    int d2 = sc.nextInt();

                                    try {
                                        Fraction f1 = new Fraction(n1, d1);
                                        Fraction f2 = new Fraction(n2, d2);
                                        System.out.println("f1 = " + f1 + ", f2 = " + f2);
                                        System.out.println("f1.equals(f2)? " + f1.equals(f2));
                                        System.out.println("f1.hashCode() = " + f1.hashCode() + ", f2.hashCode() = " + f2.hashCode());
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Ошибка: " + e.getMessage());
                                    }
                                    break;

                                case 3:
                                    System.out.print("Создаём дробь. Числитель: ");
                                    int n = sc.nextInt();
                                    System.out.print("Знаменатель: ");
                                    int d = sc.nextInt();
                                    try {
                                        f = new Fraction(n, d);
                                        System.out.println("Исходная дробь: " + f + " → " + f.getValue());

                                        System.out.print("Введите новый числитель: ");
                                        int newNum = sc.nextInt();
                                        System.out.print("Введите новый знаменатель: ");
                                        int newDen = sc.nextInt();

                                        f.setNumeratorAndDenominator(newNum, newDen);
                                        System.out.println("Обновлённая дробь: " + f + " → " + f.getValue());
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Ошибка: " + e.getMessage());
                                    }
                                    break;
                                case -1:
                                    System.out.println("Выход из задачи 1...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 2:
                        System.out.print("Введите имя кота: ");
                        String name = sc.next();

                        Cat cat = new Cat(name);
                        CountingMeowable countingCat = new CountingMeowable(cat);

                        System.out.print("Введите кол-во мяуканий: ");
                        int mewCount = sc.nextInt();

                        Funs.meowsCare(countingCat, mewCount);

                        System.out.println(name + " мяукнул " + countingCat.getCount() + " раз.");
                        System.out.println();
                        break;
                    case 3:
                        List<Integer> list = readIntegerList();

                        System.out.print("Введите элемент E для удаления: ");
                        int E = sc.nextInt();

                        System.out.println("Исходный список:");
                        printIntegerList(list);

                        list.removeIf(x -> x.equals(E));

                        System.out.println("После удаления всех вхождений " + E);
                        printIntegerList(list);
                        System.out.println();
                        break;
                    case 4:
                        do {
                            System.out.println("Выберите действие: 1 - отфильтровать строки длины меньше 3");
                            System.out.println("2 - отфильтровать положительные элементы");
                            System.out.println("3 - отфильтровать массивы положительных чисел");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 5:
                        do {
                            System.out.println("Выберите действие: 1 - сформировать 1 строчку из нескольких");
                            System.out.println("2 - вернуть сумму значений списка");
                            System.out.println("3 - получить общее кол-во элементов в списке");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 6:
                        do {
                            System.out.println("Выберите действие: 1 - разбить список чисел на положительные и отрицательные");
                            System.out.println("2 - разбить список строк на одинаковые длины");
                            System.out.println("3 - получить список без повторений");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case -1:
                        System.out.println("Выход...");
                        break;
                    default:
                        System.out.println("Ошибка: введено число вне диапазона");


                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено некорректное значение");
                return;
            }
        } while (taskNum != -1);

    }

    public static List<Integer> readIntegerList() {
        System.out.println("Введите кол-во чисел в массиве: ");
        int arrayLen = sc.nextInt();
        System.out.println("Вводите элементы массива через Enter:");
        List<Integer> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < arrayLen; i++) {
            list.add(sc.nextInt());
        }
        return list;
    }

    public static List<String> readStringList() {
        System.out.println("Введите кол-во строк в массиве: ");
        int arrayLen = sc.nextInt();
        System.out.println("Вводите элементы массива через Enter:");
        List<String> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < arrayLen; i++) {
            list.add(sc.nextLine());
        }
        return list;
    }

    public static List<Integer[]> readArrList() {
        List<Integer[]> arrList = new ArrayList<>();
        System.out.println("Введите кол-во массивов: ");
        int arrayLen = sc.nextInt();
        System.out.println("Вводите в каждой строчке элементы массива (целые числа):");
        sc.nextLine();

        for (int i = 0; i < arrayLen; i++) {
            String[] arrString = sc.nextLine().split(" ");

            Integer[] arrInteger = new Integer[arrString.length];

            try {
                for (int j = 0; j < arrString.length; j++) {
                    arrInteger[j] = Integer.parseInt(arrString[j]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число.");
                System.out.println();
                break;
            }

            arrList.add(arrInteger);
        }

        return arrList;
    }

    public static void printStringList(List<String> list) {
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printIntegerList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}