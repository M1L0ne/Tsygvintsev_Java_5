package tsygvintsev;

public class CountingMeowable implements Meowable {
    private final Cat cat;
    private int count = 0;

    public CountingMeowable(Cat cat) {
        this.cat = cat;
    }

    @Override
    public void meow() {
        cat.meow(); // настоящий мяу
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getCatName() {
        return cat.getName();
    }
}