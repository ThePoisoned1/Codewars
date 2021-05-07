import java.util.Arrays;
import java.util.stream.Collectors;

public class WeightSort {
  
    public static String orderWeight(String strng) {
        return Arrays.stream(strng.split(" ")).sorted((String n1, String n2) -> {
            int w1 = String.valueOf(n1).chars().map(Character::getNumericValue).sum();
            int w2 = String.valueOf(n2).chars().map(Character::getNumericValue).sum();
            if (w1 < w2) {
                return -1;
            } else if (w1 == w2) {
                return n1.compareTo(n2);
            } else {
                return 1;
            }
        }).collect(Collectors.joining(" "));
    }
}
