package tsygvintsev;

import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.stream.Collectors;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        int choice;
        int taskNum;
        int n;

        System.out.println("Для перехода обратно в меню и выхода вводите '-1'");
        do {
            System.out.println("Введите номер задачи (от 1 до 7): ");
            System.out.println("1 - Дробь, 2 - Количество мяуканий, 3 - Список, 4 - Логины");
            System.out.println("5 - Файл, 6 - Очередь, 7 - Координаты, 8 - Имена");
            try {
                taskNum = sc.nextInt();
                switch (taskNum) {
                    case 1:
                        do {
                            System.out.println("Выберите действие: 1 - создать дробь и вывести значение, 2 - проверить equals");
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
                        int meowCount = sc.nextInt();

                        Funs.meowsCare(countingCat, meowCount);

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
                        System.out.print("Введите количество учеников N (≤ 100): ");
                        int N = sc.nextInt();
                        sc.nextLine();

                        if (N <= 0 || N > 100) {
                            System.out.println("Ошибка: N должно быть от 1 до 100.");
                            break;
                        }

                        Map<String, Integer> surnameCount = new HashMap<>();
                        List<String> logins = new ArrayList<>();

                        System.out.println("Введите " + N + " строк в формате: Фамилия Имя");
                        for (int i = 0; i < N; i++) {
                            String line = sc.nextLine().trim();
                            if (line.isEmpty()) {
                                System.out.println("Пропущена строка " + (i + 1) + ", повторите ввод:");
                                i--;
                                continue;
                            }

                            int spaceIndex = line.indexOf(' ');
                            if (spaceIndex == -1) {
                                System.out.println("Ошибка в строке " + (i + 1) + ": нет пробела. Введите заново.");
                                i--;
                                continue;
                            }

                            String surname = line.substring(0, spaceIndex).trim();

                            if (surname.length() > 20) {
                                System.out.println("Предупреждение: фамилия > 20 символов — обрезана до 20.");
                                surname = surname.substring(0, 20);
                            }

                            int count = surnameCount.getOrDefault(surname, 0);
                            surnameCount.put(surname, count + 1);

                            String login = count == 0 ? surname : surname + (count + 1);
                            logins.add(login);
                        }

                        System.out.println("\nСгенерированные логины:");
                        for (int i = 0; i < logins.size(); i++) {
                            System.out.println((i + 1) + ". " + logins.get(i));
                        }
                        break;
                    case 5:
                        String text = "";
                        try {
                            System.out.println("Введите название файла: ");
                            sc.nextLine();
                            String fileName = sc.nextLine();
                            Path path = Paths.get(fileName);
                            text = Files.readString(path, StandardCharsets.UTF_8);

                            List<Character> result = VoicedLettersExtractor.extract(text);

                            System.out.println("\nРезультат:");
                            if (result.isEmpty()) {
                                System.out.println("Не найдено звонких согласных.");
                            } else {
                                System.out.print("Звонкие согласные: ");
                                for (int i = 0; i < result.size(); i++) {
                                    if (i > 0) System.out.print(", ");
                                    System.out.print(result.get(i));
                                }
                                System.out.println();
                            }

                        } catch (IOException e) {
                            System.out.println("Ошибка чтения файла: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                        System.out.println();
                        break;
                    case 6:
                        System.out.print("Введите количество элементов в очереди L1: ");
                        n = sc.nextInt();
                        if (n <= 0) {
                            System.out.println("Ошибка: очередь должна быть непустой.");
                            break;
                        }

                        Queue<Integer> L1 = new LinkedList<>();
                        System.out.println("Введите " + n + " целых чисел (через Enter):");
                        for (int i = 0; i < n; i++) {
                            L1.add(sc.nextInt());
                        }

                        Stack<Integer> stack = new Stack<>();
                        while (!L1.isEmpty()) {
                            stack.push(L1.poll());
                        }

                        Queue<Integer> L2 = new LinkedList<>();
                        while (!stack.isEmpty()) {
                            L2.add(stack.pop());
                        }

                        System.out.println("Новая очередь L2 (обратный порядок): " + L2);

                        System.out.println();
                        break;
                    case 7:
                        System.out.print("Введите количество точек: ");
                        n = sc.nextInt();
                        if (n <= 0) {
                            System.out.println("Должна быть хотя бы одна точка.");
                            break;
                        }

                        List<Point> points = new ArrayList<>();
                        System.out.println("Введите " + n + " точек в формате: X Y (через пробел или Enter)");
                        for (int i = 0; i < n; i++) {
                            System.out.print("Точка " + (i + 1) + ": ");
                            double x = sc.nextDouble();
                            double y = sc.nextDouble();
                            points.add(new Point(x, y));
                        }

                        System.out.println("\nИсходные точки:");
                        points.forEach(p -> System.out.println("  " + p));

                        Polyline polyline = points.stream()
                                .map(Point::withPositiveY)
                                .distinct()
                                .sorted(Comparator.comparing(Point::getX))
                                .collect(Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        Polyline::new
                                ));

                        System.out.println("\nРезультат:");
                        System.out.println(polyline);
                        System.out.println();
                        break;
                    case 8:
                        System.out.print("Введите имя файла: ");
                        sc.nextLine();
                        String fileName = sc.nextLine();

                        try {
                            Map<Integer, List<String>> map = new TreeMap<>();

                            Files.lines(Paths.get(fileName))
                                    .map(String::trim)
                                    .filter(line -> line.contains(":"))
                                    .map(line -> line.split(":", 2))
                                    .filter(parts -> !parts[1].trim().isEmpty())
                                    .forEach(parts -> {
                                        String propperCaseName = toProperCase(parts[0].trim());
                                        int num = Integer.parseInt(parts[1].trim());
                                        map.computeIfAbsent(num, k -> new ArrayList<>()).add(propperCaseName);
                                    });

                            System.out.print("[");
                            System.out.print(map.entrySet().stream()
                                    .map(e -> e.getKey() + ":[" + String.join(", ", e.getValue()) + "]")
                                    .collect(Collectors.joining(", ")));
                            System.out.println("]");

                        } catch (Exception e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                        System.out.println();
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

    public static String toProperCase(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() +
                name.substring(1).toLowerCase();
    }

    public static void printIntegerList(List<Integer> list) {
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

}