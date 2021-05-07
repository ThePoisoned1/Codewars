import java.math.*;

public class Fibonacci {

    public static BigInteger fib(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) {
            n = n.negate();
            if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) == 0) {
                return Calculatefib(n).negate();
            }
        }
        return Calculatefib(n);
    }

    public static BigInteger Calculatefib(BigInteger n) {
        BigInteger aRes = BigInteger.ZERO;
        BigInteger bRes = BigInteger.ONE; // data of previous Matrix (1 1),(1 0) or (c b),(b a)
        BigInteger cRes = BigInteger.ONE; // a is n, b in n+1 and c is n+2 in the Fibonacci sequence
        BigInteger aBase = BigInteger.ZERO;
        BigInteger bBase = BigInteger.ONE; // data of the Matrix
        BigInteger cBase = BigInteger.ONE;
        BigInteger temp1;
        BigInteger temp2; // data of the calculated matrix
        BigInteger temp3;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ONE) == 0) {
                temp1 = aRes.multiply(aBase).add(bRes.multiply(bBase));
                temp2 = aBase.multiply(bRes).add(bBase.multiply(cRes)); // matrix multiplication
                temp3 = bBase.multiply(bRes).add(cBase.multiply(cRes));
                aRes = temp1;
                bRes = temp2; // set the values for the new previous matrix
                cRes = temp3;
            }
            n = n.shiftRight(1); // if the number is even it gets halfed. If odd its gets 1 unit removed and then
                                 // halfed since we delete the last binnary digit
            temp1 = aBase.multiply(aBase).add(bBase.multiply(bBase));
            temp2 = aBase.multiply(bBase).add(bBase.multiply(cBase)); // matrix gets squared
            temp3 = bBase.multiply(bBase).add(cBase.multiply(cBase));
            aBase = temp1;
            bBase = temp2; // set the values for the new actual matrix
            cBase = temp3;
        }
        return aRes;
    }
}