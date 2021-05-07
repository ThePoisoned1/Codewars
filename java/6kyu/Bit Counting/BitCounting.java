public class BitCounting {

    public static String toBinary(int num) {
        return Integer.toBinaryString(num);

    }

    public static int countBits(int n) {
        int num1s = 0;
        String num = toBinary(n);
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1') {
                num1s++;
            }
        }
        return num1s;
    }

}
