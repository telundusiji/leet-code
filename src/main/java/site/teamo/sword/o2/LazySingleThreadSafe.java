package site.teamo.sword.o2;

public class LazySingleThreadSafe {
    private static volatile LazySingleThreadSafe instance = null;

    private LazySingleThreadSafe() {
    }

    public static LazySingleThreadSafe getInstance() {
        if (instance == null) {
            synchronized (LazySingleThreadSafe.class) {
                if (instance == null) {
                    instance = new LazySingleThreadSafe();
                }
            }
        }
        return instance;
    }
}
