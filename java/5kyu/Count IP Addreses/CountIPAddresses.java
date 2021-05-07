import java.math.BigInteger;

public class CountIPAddresses {

    static String toHexadecimal(int num) {
        String hex = Integer.toHexString(num);
        if (hex.length() < 2) {
            hex = 0 + hex;
        }
        return hex;
    }

    public static long ipsBetween(String a, String b) {
        String[] start = a.split("\\.");
        String min = "";
        for (String i : start) {
            min += toHexadecimal(Integer.parseInt(i));
        }
        String max = "";
        String[] end = b.split("\\.");
        for (String i : end) {
            max += toHexadecimal(Integer.parseInt(i));
        }
        BigInteger minuend = new BigInteger(max, 16);
        BigInteger subtrahend = new BigInteger(min, 16);
        BigInteger diff = minuend.subtract(subtrahend);

        return Integer.parseInt(diff.toString());
    }
}