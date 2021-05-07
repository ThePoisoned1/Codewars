import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static <T> List<T> josephusPermutation(List<T> items, final int k) {
        List<T> output = new ArrayList<>();
        int pos = 0;
        while (items.size() >= 1) {
            pos = (pos + k - 1) % items.size();
            output.add(items.get(pos));
            items.remove(pos);
        }
        return output;
    }
}
