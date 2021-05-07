public class PigLatin {
    public static String pigIt(String str) {
        String out = "";
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (Character.isAlphabetic(words[i].charAt(0))) {
                out += words[i].substring(1) + words[i].charAt(0) + "ay ";
            } else {
                out += words[i];
            }
        }
        return out.trim();
    }
}
