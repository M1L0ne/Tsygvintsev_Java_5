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