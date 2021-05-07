import java.util.TreeMap;

public class FindOdd {
    public static int findIt(int[] a) {
        TreeMap<Integer, Integer> nums = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (nums.containsKey(a[i])) {
                nums.put(a[i], nums.get(a[i]) + 1);
            } else {
                nums.put(a[i], 1);
            }
        }
        int odd = 0;
        for (int i : nums.keySet()) {
            if (nums.get(i) % 2 != 0) {
                odd = i;
                break;
            }
        }
        return odd;
    }
}