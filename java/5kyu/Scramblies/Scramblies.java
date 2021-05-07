public class Scramblies {

    public static boolean scramble(String mixedFragment, String word) {
        StringBuffer mix = new StringBuffer(mixedFragment);
        int pos;
        for (int i = 0; i < word.length(); i++) {
            pos = mix.indexOf(Character.toString(word.charAt(i)));
            if (pos < 0) {
                return false;
            }
            mix.deleteCharAt(pos);
        }
        return true;
    }
}