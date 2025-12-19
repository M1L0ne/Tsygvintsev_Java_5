package tsygvintsev;

public class Funs {
    public static void meowsCare(Meowable meower, int mewCount) {
        for (int i = 0; i < mewCount; i++) {
            meower.meow();
        }
    }
}