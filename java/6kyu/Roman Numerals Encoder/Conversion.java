public class Conversion {

    final String[][] digits = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
            { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
            { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }, { "", "M", "MM", "MMM" } };

    public String solution(int n) {
        String num = Integer.toString(n);
        String out = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            out = digits[num.length() - i - 1][Character.getNumericValue(num.charAt(i))] + out;
        }
        return out;
    }
