public class CountingDuplicates {
    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        String aux = "", duped = "";
        String pos;
        for (int i = 0; i < text.length(); i++) {
            pos = Character.toString(text.charAt(i));
            if (aux.contains(pos) && !duped.contains(pos)) {
                duped += pos;
            } else if (!aux.contains(pos)) {
                aux += pos;
            }
        }
        return duped.length();
    }
}