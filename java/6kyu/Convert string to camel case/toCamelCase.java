import java.lang.StringBuilder;

class Solution {

    static String toCamelCase(String s) {
        StringBuilder phrase = new StringBuilder(s);
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == '-' || phrase.charAt(i) == '_') {
                phrase.setCharAt(i + 1, Character.toUpperCase(phrase.charAt(i + 1)));
                phrase.deleteCharAt(i);
            }
        }
        return phrase.toString();
    }
}