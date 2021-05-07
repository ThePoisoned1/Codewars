public class Kata{
    public static String expandedForm(int num) {
        StringBuilder out = new StringBuilder();
        int max = Integer.toString(num).length();
        int pos = 0;
        for (char digit : Integer.toString(num).toCharArray()) {
            if (digit != '0') {
                out.append(digit);
                for (int i = pos; i < max - 1; i++) {
                    out.append('0');
                }
                out.append(" + ");
            }
            pos++;
        }
        if (out.substring(out.length() - 3).equals(" + ")) {
            out.setLength(out.length() - 3);
        }
        return out.toString();
    }
}
