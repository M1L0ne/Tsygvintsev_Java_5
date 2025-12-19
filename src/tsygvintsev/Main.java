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
                            System.out.println("Выберите действие: 1 - добавить коробку, 2 - найти максимум");
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
                    case 2:
                        do {
                            System.out.println("Выберите действие: 1 - добавить коробку, 2 - найти максимум");
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
                    case 3:
                        do {
                            System.out.println("Выберите действие: 1 - перевести строки в их длину");
                            System.out.println("2 - поменять отрицательные числа на положительные");
                            System.out.println("3 - получить максимальные значения из массивов");
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
        System.out.println("Полученный список: ");
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printIntegerList(List<Integer> list) {
        System.out.println("Полученный список: ");
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}