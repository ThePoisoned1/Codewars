public class isogram {
    public static boolean isIsogram(String str) {
        String letters = "";
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (letters.contains(Character.toString(str.charAt(i)))) {
                return false;
            }
            letters += str.charAt(i);
        }
        return true;
    }
}
