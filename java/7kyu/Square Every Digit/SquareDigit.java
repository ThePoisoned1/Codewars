public class SquareDigit {

    public int squareDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        String out = "";
        for (int i = 0; i < digits.length; i++) {
            out += Character.getNumericValue(digits[i]) * Character.getNumericValue(digits[i]);
        }
        return Integer.valueOf(out.trim());
    }

}