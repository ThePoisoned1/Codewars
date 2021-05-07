import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        List<String> symbols = new ArrayList<>(Arrays.asList(commentSymbols));
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                if (symbols.contains(Character.toString(lines[i].charAt(j)))) {
                    lines[i] = lines[i].substring(0, j);
                    break;
                }

            }
            lines[i] = lines[i].replaceAll("\\s++$", "");
        }
        return String.join("\n", lines);
    }

}