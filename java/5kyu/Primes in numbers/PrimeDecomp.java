import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;

public class PrimeDecomp {

    public static String factors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        int factor = 2;
        while (n > 1) {
            if (n % factor == 0) {
                n /= factor;
                if (factors.containsKey(factor)) {
                    factors.put(factor, factors.get(factor) + 1);
                } else {
                    factors.put(factor, 1);
                }
            } else {
                factor++;
            }
        }
        return getString(new TreeMap<>(factors));
    }

    private static String getString(Map<Integer, Integer> factors) {
        String out = "";
        for (int factor : factors.keySet()) {
            out += "(" + factor;
            if (factors.get(factor) > 1) {
                out += "**" + factors.get(factor);
            }
            out += ")";
        }
        return out;
    }
}
