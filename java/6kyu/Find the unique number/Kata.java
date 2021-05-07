public class Kata {
    static double findCopied(double arr[]) {
        if (arr[0] == arr[1] || arr[0] == arr[2]) {
            return arr[0];
        }
        return arr[1];
    }

    public static double findUniq(double arr[]) {
        double copied = findCopied(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != copied) {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }
}