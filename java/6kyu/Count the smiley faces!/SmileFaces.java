import java.util.*;

public class SmileFaces {

    static boolean isSmiley(String emoji) {
        if (emoji.length() > 3) {
            return false;
        }
        if (emoji.charAt(0) != ':' && emoji.charAt(0) != ';') {
            return false;
        }
        if (emoji.charAt(emoji.length() - 1) != ')' && emoji.charAt(emoji.length() - 1) != 'D') {
            return false;
        }
        if (emoji.length() == 3) {
            if (emoji.charAt(1) != '-' && emoji.charAt(1) != '~') {
                return false;
            }
        }
        return true;
    }

    public static int countSmileys(List<String> arr) {
        int numSimley = 0;
        for (String emoji : arr) {
            if (isSmiley(emoji)) {
                numSimley++;
            }
        }

        return numSimley;
    }
}