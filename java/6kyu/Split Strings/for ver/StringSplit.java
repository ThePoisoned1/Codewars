public class StringSplit {
    public static String[] solution(String s) {
        if (s.length() % 2 != 0) {
            s += "_";
        }
        String[] out = new String[Math.floorDiv(s.length(), 2)];
        int pos = 0;
        for (int i = 0; i < s.length(); i += 2) {
            out[pos] = s.substring(i, i + 2);
            pos++;
        }
        return out;
    }
}