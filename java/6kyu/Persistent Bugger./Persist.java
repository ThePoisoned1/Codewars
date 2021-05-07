class Persist {
    public static int persistence(long n) {
        int per = 0;
        String num;
        while (n >= 10) {
            num = Long.toString(n);
            n = 1;
            for (int i = 0; i < num.length(); i++) {
                n *= Character.getNumericValue(num.charAt(i));
            }
            per++;
        }
        return per;
    }
}