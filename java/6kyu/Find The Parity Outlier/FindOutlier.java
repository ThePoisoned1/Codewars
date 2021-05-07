public class FindOutlier {
    static boolean findOdd(int[] integers) {
        return (integers[0] % 2 == 0 && integers[1] % 2 == 0) || (integers[0] % 2 == 0 && integers[2] % 2 == 0)
                || (integers[1] % 2 == 0 && integers[2] % 2 == 0);
    }

    static int find(int[] integers) {
        if (findOdd(integers)) {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] % 2 != 0) {
                    return integers[i];
                }
            }
        } else {
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] % 2 == 0) {
                    return integers[i];
                }
            }
        }
        return 0;
    }
}