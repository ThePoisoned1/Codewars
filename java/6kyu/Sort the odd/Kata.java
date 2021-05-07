import java.util.PriorityQueue;

public class Kata {
    public static int[] sortArray(int[] array) {
        PriorityQueue<Integer> odds = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                odds.add(array[i]);
                array[i] = -1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                array[i] = odds.poll();
            }
        }
        return array;
    }
}