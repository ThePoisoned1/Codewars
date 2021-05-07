import java.util.TreeSet;

public class TwoToOne {

    public static String longest(String s1, String s2) {
        TreeSet<Character> letters = new TreeSet<>();
        int count = 0;
        String out = "";
        while (s1.length() > count || s2.length() > count) {
            if (s1.length() > count) {
                letters.add(s1.charAt(count));
            }
            if (s2.length() > count) {
                letters.add(s2.charAt(count));
            }
            count++;
        }
        for (Character letter : letters) {
            out += letter;
        }
        return out;
    }
}