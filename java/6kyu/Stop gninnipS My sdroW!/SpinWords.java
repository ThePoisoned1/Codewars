public class SpinWords {

    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        String out = "";
        for (String word : words) {
            out += word.length() >= 5 ? new StringBuilder(word).reverse() + " " : word + " ";
        }
        return out.trim();
    }
}
