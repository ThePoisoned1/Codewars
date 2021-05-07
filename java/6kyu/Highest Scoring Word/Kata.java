public class Kata {

    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String high(String s) {
        String[] words = s.split(" ");
        String max = "";
        int maxPts = 0;
        int pts;
        for (String word : words) {
            pts = 0;
            for (int i = 0; i < word.length(); i++) {
                pts += alphabet.indexOf(Character.toString(word.charAt(i))) + 1;
            }
            if (pts > maxPts) {
                max = word;
                maxPts = pts;
            }
        }
        return max;
    }

}
