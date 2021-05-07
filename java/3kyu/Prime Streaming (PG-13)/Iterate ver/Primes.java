import java.util.stream.IntStream;

public class Primes {

    public static IntStream stream() {
        return IntStream.iterate(primeAfter(1), Primes::primeAfter);
    }

    private static int primeAfter(final int number) {
        return isPrime(number + 1) ? number + 1 : primeAfter(number + 1);
    }

    public static boolean isPrime(final int number) {
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0 || number < 2) {
            return false;
        }
        for (int divisor = 3; divisor <= (int) Math.sqrt(number); divisor += 2) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
