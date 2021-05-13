package site.teamo.sword.o2;

public class LazySingleThreadUnsafe {
    private static LazySingleThreadUnsafe instance = null;

    private LazySingleThreadUnsafe() {
    }

    public static LazySingleThreadUnsafe getInstance() {
        if (instance == null) {
            instance = new LazySingleThreadUnsafe();
        }
        return instance;
    }
}
