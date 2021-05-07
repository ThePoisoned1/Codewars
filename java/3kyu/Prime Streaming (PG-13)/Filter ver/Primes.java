import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Primes {
    static List<Integer> primes;

    public static IntStream stream() {
        primes = new ArrayList<>();
        primes.add(2);
        return IntStream.rangeClosed(2, Integer.MAX_VALUE).filter(Primes::isPrime);
    }

    public static boolean isPrime(final int number) {
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
