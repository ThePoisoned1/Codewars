import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Kata {
    public static long nextBiggerNumber(long n) {
        String num = Long.toString(n);
        String out;
        ArrayList<Character> ending = new ArrayList<>();
        for (int i = num.length() - 1; i >= 1; i--) {
            if (Character.getNumericValue(num.charAt(i)) > Character.getNumericValue(num.charAt(i - 1))) {
                out = num.substring(0, i - 1);
                Collections.addAll(ending, num.substring(i).chars().mapToObj(c -> (char) c).toArray(Character[]::new));
                Collections.sort(ending);
                ending.add(0, num.charAt(i - 1));
                for (int j = 1; j < ending.size(); j++) {
                    if (ending.get(j) > ending.get(0)) {
                        out += ending.get(j);
                        ending.remove(j);
                        break;
                    }
                }
                Collections.sort(ending);
                out += ending.stream().map(Object::toString).collect(Collectors.joining());
                return Long.parseLong(out);
            }
        }
        return -1;
    }
}