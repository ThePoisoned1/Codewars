public class Solution {

    public int solution(int number) {
        int sum = 0;
        for (int i = 3; i < number; i += 3) {
            if (i % 5 != 0) {
                sum += i;
            }
        }
        for (int i = 0; i < number; i += 5) {
            sum += i;
        }
        return sum;
    }
}