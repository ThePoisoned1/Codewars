public class PangramChecker {
    public boolean check(String sentence) {
        String aux = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder alphabet = new StringBuilder(aux);
        int pos = 0;
        sentence = sentence.toLowerCase();
        for (int i = 0; i < sentence.length(); i++) {
            pos = alphabet.lastIndexOf(Character.toString(sentence.charAt(i)));
            if (pos >= 0) {
                alphabet.deleteCharAt(pos);
            }
            if (alphabet.length() <= 0) {
                return true;
            }
        }
        return false;
    }
}