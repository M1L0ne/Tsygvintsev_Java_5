# Цыгвинцев Олег Сергеевич Лабораторная №5

# Задание 1
## Задача 1
### Текст задачи
В	класс	Дробь,	добавить	интерфейс	на	два	метода:	получение	вещественного	значения,	установка
числителя	и	установка	знаменателя.
Сгенерировать	такую	версию	дроби,	которая	будет	кэшировать	вычисление	вещественного
значения.
Если	раннее	в	вашем	варианте	не	было	Дроби,	то	создайте	сущность Дробь	со	следующими
особенностями:
• Имеет	числитель:	целое	число
• Имеет	знаменатель:	целое	число
• Дробь	может	быть	создана	с	указанием	числителя	и	знаменателя		
• Может	вернуть	строковое	представление	вида	“числитель/знаменатель”
• Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может
быть отрицательным. 	
• Переопределите	метод	сравнения	объектов	по	состоянию	таким	образом,	чтобы	две	дроби
считались	одинаковыми	тогда,	когда	у	них	одинаковые	значения	числителя	и	знаменателя.
### Алгоритм решения
    package tsygvintsev;
    
    public interface NumericFraction {
        double getValue();
        void setNumeratorAndDenominator(int numerator, int denominator);
    }

    package tsygvintsev;
    
    import java.util.Objects;
    
    public class Fraction implements NumericFraction {
        private int numerator;
        private int denominator;
        private Double cachedValue;
    
        public Fraction(int numerator, int denominator) {
            setNumeratorAndDenominator(numerator, denominator);
        }
    
        @Override
        public double getValue() {
            if (cachedValue == null) {
                cachedValue = (double) numerator / denominator;
            }
            return cachedValue;
        }
    
        @Override
        public void setNumeratorAndDenominator(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть 0!");
            }
    
            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }
            this.numerator = numerator;
            this.denominator = denominator;
            this.cachedValue = null;
        }
    
        public int getNumerator() {
            return numerator;
        }
    
        public int getDenominator() {
            return denominator;
        }
    
        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Fraction fraction = (Fraction) o;
            return numerator == fraction.numerator &&
                    denominator == fraction.denominator;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(numerator, denominator);
        }
    }


# Задание 2
## Задача 1
### Текст задачи
Количество мяуканий.  
Необходимо воспользоваться классом Кот и методом принимающим всех мяукающих из задачи 2.5.4.
Необходимо таким образом передать кота в указанный метод, что бы после окончания его работы
узнать сколько раз мяукал кот за время его работы. На рисунке показан пример работы. Перед вызовом
метода создаем кота, отправляем ссылку на кота в метод, после окончания его работы выводим
количество мяуканий на экран. Кота изменять нельзя.

Если	раннее	в	вашем	варианте	не	было	Кота,	то	создайте
1. сущность	Кот,	которая	описывается	следующим	образом:
   • Имеет	Имя	(строка)
   • Для	создания	необходимо	указать	имя	кота.
   • Может	быть	приведен	к	текстовой	форме	вида:	“кот:	Имя”
   • Может	помяукать,	что	приводит	к	выводу	на	экран	следующего	текста:	“Имя:	мяу!”,
   вызвать	мяуканье	можно	без	параметров.
2. интерфейс	Мяуканье: разработайте метод, который принимает набор объектов способных
   мяукать и вызывает мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со
   следующей сигнатурой:
   public void meow();
### Алгоритм решения
    package tsygvintsev;
    
    public interface Meowable {
        void meow();
    }

    package tsygvintsev;
    
    public class Cat implements Meowable{
        private final String name;
    
        public Cat(String name) {
            this.name = name;
        }
    
        public void meow() {
            System.out.println(name + ": мяу!");
        }
    
        @Override
        public String toString() {
            return "кот: " + name;
        }
    
        public String getName() {
            return name;
        }
    }

    package tsygvintsev;
    
    public class CountingMeowable implements Meowable {
        private final Cat cat;
        private int count = 0;
    
        public CountingMeowable(Cat cat) {
            this.cat = cat;
        }
    
        @Override
        public void meow() {
            cat.meow();
            count++;
        }
    
        public int getCount() {
            return count;
        }
    
        public String getCatName() {
            return cat.getName();
        }
    }

    package tsygvintsev;
    
    public class Funs {
        public static void meowsCare(Meowable meower, int mewCount) {
            for (int i = 0; i < mewCount; i++) {
                meower.meow();
            }
        }
    }

# Задание 3
## Задача 1
### Текст задачи
Составить	программу,	которая	удаляет	из	списка	L	все	элементы	E,	если	такие	есть.
### Алгоритм решения
    List<Integer> list = readIntegerList();

    System.out.print("Введите элемент E для удаления: ");
    int E = sc.nextInt();

    System.out.println("Исходный список:");
    printIntegerList(list);

    list.removeIf(x -> x.equals(E));

    System.out.println("После удаления всех вхождений " + E);
    printIntegerList(list);

# Задание 4
## Задача 1
### Текст задачи
На	вход	программы	подаются	фамилии	и	имена	учеников.	Известно,	что	общее	количество
учеников	не	превосходит	100.	В	первой	строке	вводится	количество	учеников,	принимавших
участие	в	соревнованиях,	N.	Далее	следуют	N	строк,	имеющих	следующий	формат:
<Фамилия><Имя>
Здесь	<Фамилия>	–	строка,	состоящая	не	более	чем	из	20	символов;	<Имя>–	строка,	состоящая	не
более	чем	из	15	символов.	При	этом	<Фамилия>	и	<Имя>	разделены	одним	пробелом.	Примеры
входных	строк:		
Иванова	Мария
Петров	Сергей
Требуется	написать	программу,	которая	формирует	и	печатает	уникальный	логин	для	каждого
ученика	по	следующему	правилу:	если	фамилия	встречается	первый	раз,	то	логин	–	это	данная
фамилия,	если	фамилия	встречается	второй	раз,	то	логин	–	это	фамилия,	в	конец	которой
приписывается	число	2	и	т.д.	Например,	для	входной	последовательности:
Иванова	Мария
Петров	Сергей
Бойцова	Екатерина
Петров	Иван
Иванова	Наташа
будут	сформированы	следующие	логины:
Иванова
Петров
Бойцова
Петров2
Иванова2
### Алгоритм решения
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

# Задание 5
## Задача 1
### Текст задачи
Файл	содержит	текст	на	русском	языке.	Напечатать	в	алфавитном	порядке	все	звонкие
согласные	буквы,	которые	входят	хотя	бы	в	одно	слово.
### Алгоритм решения
    package tsygvintsev;

    import java.util.*;
    
    public class VoicedLettersExtractor {
    
        private static final Set<Character> VOICED_CONSONANTS = Set.of(
                'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'
        );
    
        public static List<Character> extract(String text) {
            if (text == null) {
                return Collections.emptyList();
            }
    
            Set<Character> found = new TreeSet<>();
    
            for (char c : text.toLowerCase().toCharArray()) {
                if (VOICED_CONSONANTS.contains(c)) {
                    found.add(c);
                }
            }
    
            return new ArrayList<>(found);
        }
    }

    Main
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


# Задание 6
## Задача 1
### Текст задачи
Напечатать	в	обратном	порядке	элементы	непустой	очереди	L.
### Алгоритм решения
    System.out.print("Введите количество элементов в очереди: ");
    int n = sc.nextInt();
    if (n <= 0) {
        System.out.println("Ошибка: очередь должна быть непустой.");
        break;
    }

    Queue<Integer> queue = new LinkedList<>();
    System.out.println("Введите " + n + " целых чисел (через Enter):");
    for (int i = 0; i < n; i++) {
        queue.add(sc.nextInt());
    }

    Stack<Integer> stack = new Stack<>();
    while (!queue.isEmpty()) {
        stack.push(queue.poll());
    }

    System.out.print("Элементы непустой очереди в обратном порядке: ");
    while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
    }

# Задание 7
## Задача 1
### Текст задачи
Необходимо	написать	стрим:
Дан	набор	объектов	типа	Point,	необходимо	взять	все	Point	в	разных	координатах,	убрать	с
одинаковыми	X,Y,	отсортировать	по	X,	отрицательные	Y	сделать	положительными	и	собрать	это
все	в	ломаную	(объект	типа	Polyline)
Если	раннее	в	вашем	варианте	не	было	задание	с	классом	Point	и	Polyline,	то	написать	их:
1. класс	Point:
   • Координата	Х:	число.			
   • Координата	Y:	число.
   • Может	возвращать	текстовое	представление	вида	“{X;Y}”.
2. класс	Line	(Линия),	расположенная	на	двумерной	плоскости,	которая	описывается:
   • Координата	начала:	Точка
   • Координата	конца:	Точка
   • Может	возвращать	текстовое	представление	вида	“Линия	от	{X1;Y1}	до	{X2;Y2}”
3. класс	Polyline	(Ломаная),	которая	будет	представлять	собой	ломаную	линию.	Ломаная
   линия	представляет	собой	набор	следующих	характеристик:			
   • Имеет	массив	Точек,	через	которые	линия	проходит.
   • Может	быть	приведена	к	строковой	форме	вида	“Линия	[Т1,T2,…,TN]”,	где	TN	–	это
   результат	приведения	к	строке	Точки	с	номером	N
### Алгоритм решения
    package tsygvintsev;

    import java.util.Objects;
    
    public class Point {
        private final double x;
        private final double y;
    
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    
        public double getX() { return x; }
        public double getY() { return y; }
    
        public Point withPositiveY() {
            return new Point(x, Math.abs(y));
        }
    
        @Override
        public String toString() {
            return "{" + x + ";" + y + "}";
        }
    
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Double.compare(point.x, x) == 0 &&
                    Double.compare(point.y, y) == 0;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    package tsygvintsev;
    
    public class Line {
    private final Point start;
    private final Point end;
    
        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }
    
        @Override
        public String toString() {
            return "Линия от " + start + " до " + end;
        }
    }

    package tsygvintsev;
    
    import java.util.*;
    import java.util.stream.Stream;
    
    public class Polyline {
    private final List<Point> points;
    
        public Polyline(List<Point> points) {
            this.points = new ArrayList<>(points);
        }
    
        @Override
        public String toString() {
            return "Линия [" + String.join(", ", points.stream()
                    .map(Point::toString)
                    .toList()) + "]";
        }
    }

    Main
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

# Задание 7
## Задача 2
### Текст задачи
Дан	текстовый	файл	со	строками,	содержащими	имя	человека	и	его	номер	в	следующей	форме:
Вася:5
Петя:3
Аня:5
Номера	людей	могут	повторяться.	У	каких-то	людей	может	не	быть	номера.
Необходимо	написать	стрим	выполняющую	следующее:
читаются	все	люди	из	файла,	все	имена	приводится	к	нижнему	регистру,	но	с	первой	буквой	в
верхнем	регистре,	убираем	из	перечня	всех	людей	без	номеров,	а	имена	оставшихся	группируются
по	их	номеру:
[5:[Вася,	Аня],	3:[Петя]]
### Алгоритм решения
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
