package site.teamo.sword.o2;

public class HungerSingle {
    private static final HungerSingle INSTANCE = new HungerSingle();

    private HungerSingle() {
    }

    public static HungerSingle getInstance() {
        return INSTANCE;
    }
}
