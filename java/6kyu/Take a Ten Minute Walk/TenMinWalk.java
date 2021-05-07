public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int s = 0, n = 0, e = 0, w = 0;
        for (int i = 0; i < walk.length; i++) {
            switch (walk[i]) {
                case 's':
                    s++;
                    break;
                case 'n':
                    n++;
                    break;
                case 'e':
                    e++;
                    break;
                case 'w':
                    w++;
                    break;
                default:
                    break;
            }
        }
        return (s == n && e == w);
    }
}