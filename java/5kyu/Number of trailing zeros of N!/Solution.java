public class Solution {

    public static int zeros(int n) {
        int zeros = 0;
        while (n >= 5) {
            zeros += n / 5;
            n = n / 5;
        }
        return zeros;
    }
}