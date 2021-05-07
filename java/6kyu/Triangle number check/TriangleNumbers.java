public class TriangleNumbers {

    public static Boolean isTriangleNumber(long number) {
        int count = 0, height = 1;
        while (count < number) {
            count += height;
            height++;
        }
        return count == number;
    }
}