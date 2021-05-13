package site.teamo.sword.o2;

public class LazySingleThreadSafeBaseInnerClass {

    private static class InnerClass {
        private static final LazySingleThreadSafeBaseInnerClass INSTANCE = new LazySingleThreadSafeBaseInnerClass();
    }

    private LazySingleThreadSafeBaseInnerClass() {
    }

    public static LazySingleThreadSafeBaseInnerClass getInstance() {
        return InnerClass.INSTANCE;
    }
}
