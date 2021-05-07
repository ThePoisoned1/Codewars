import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> sol = new ArrayList<>();
        long sum = n * (1 + n) / 2;
        long b;
        for (long a = n / 2; a < n; a++) {
            b = (sum - a) / (a + 1);
            if (sum - a - b == b * a) {
                sol.add(new long[] { a, b });
            }
        }
        return sol;
    }
}