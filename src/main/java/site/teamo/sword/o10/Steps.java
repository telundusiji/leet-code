package site.teamo.sword.o10;

public class Steps {

    int[] ways = new int[101];

    {
        ways[0] = 1;
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i < ways.length; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % 1000000007;
        }
    }

    public int numWays(int n) {
        return ways[n];
    }
}
