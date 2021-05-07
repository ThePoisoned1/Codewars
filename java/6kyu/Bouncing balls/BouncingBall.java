public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || bounce >= 1 || bounce <= 0 || window >= h) {
            return -1;
        }
        int count = 0;
        while (h > window) {
            h *= bounce;
            count++;
            if (h > window) {
                count++;
            }
        }
        return count;
    }
}
