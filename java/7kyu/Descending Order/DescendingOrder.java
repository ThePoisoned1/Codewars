import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        String[] digits = Integer.toString(num).split("");
        Arrays.sort(digits, Collections.reverseOrder());
        return Integer.parseInt(String.join("", digits));
    }
}