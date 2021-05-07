public class Xbonacci {

    public double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }
        double[] tribonacci = new double[n];
        if (n <= 3) {
            System.arraycopy(s, 0, tribonacci, 0, n);
        } else {
            System.arraycopy(s, 0, tribonacci, 0, 3);
        }
        for (int i = 3; i < n; i++) {
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }
        return tribonacci;
    }
}
