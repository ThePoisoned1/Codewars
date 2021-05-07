import java.math.BigInteger;
public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return new BigInteger("4");
        }
        if (n.equals(BigInteger.TWO)) {
            return new BigInteger("8");
        }
        BigInteger a = BigInteger.ONE, b = BigInteger.ONE, c;
        BigInteger sum = BigInteger.valueOf(2);
        while (n.compareTo(BigInteger.TWO) >= 0) {
            c = a.add(b);
            a = b;
            b = c;
            sum = sum.add(c);
            n = n.subtract(BigInteger.ONE);
        }
        return sum.multiply(BigInteger.valueOf(4));
    }
}
