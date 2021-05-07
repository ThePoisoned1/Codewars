import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Primes {
    static List<Integer> primes;

    public static IntStream stream() {
        primes = new ArrayList<>();
        return IntStream.iterate(primeAfter(1), Primes::primeAfter);
    }

    private static int primeAfter(final int number) {
        return isPrime(number + 1) ? number + 1 : primeAfter(number + 1);
    }

    public static boolean isPrime(final int number) {
        if (number == 2) {
            primes.add(2);
            return true;
        }
        int limit = (int) Math.sqrt(number);
        for (Integer prime : primes) {
            if (prime > limit) {
                break;
            }
            if (number % prime == 0) {
                return false;
            }
        }
        primes.add(number);
        return true;
    }
}