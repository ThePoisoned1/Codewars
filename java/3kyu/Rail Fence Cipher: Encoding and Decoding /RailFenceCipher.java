import java.util.ArrayList;
import java.util.List;

public class RailFenceCipher {
    
    static String encode(String message, int n) {
        if (message.length() <= n) { // msg is not long enough to be coded
            return message;
        }
        List<StringBuilder> coded = new ArrayList<>();
        String out = "";
        for (int i = 0; i < n; i++) {
            coded.add(new StringBuilder());
        }
        int linea = 0, direccion = 1;
        for (int i = 0; i < message.length(); i++) {
            coded.get(linea).append(message.charAt(i));
            linea += direccion;
            if (linea >= n - 1 || linea <= 0) {
                direccion = -direccion;
            }
        }
        for (StringBuilder fila : coded) {
            out += fila.toString();
        }
        return out;
    }

    static String decode(String message, int n) {
        if (message.length() <= n) { // msg is not long enough to be decoded
            return message;
        }
        List<StringBuilder> coded = new ArrayList<>();
        int cycles = Math.floorDiv(message.length(), (n - 1) * 2); // ammount of times it went down and up again
        int extraChars = message.length() % ((n - 1) * 2); // characters left (not enough to finish a cycle)
        int pos = 0;
        coded.add(new StringBuilder());
        coded.get(0).append(message.substring(0, cycles + 1));
        pos += cycles;
        if (extraChars > 0) { // only one of the extra characters can belong to the first rail
            coded.get(0).append(message.charAt(pos - 1));
            pos++;
            extraChars--;
        }
        for (int i = 1; i < n - 1; i++) {
            coded.add(new StringBuilder());
            coded.get(i).append(message.substring(pos, pos + cycles * 2)); // inner rails have at least twice the
                                                                           // letters of the outter ones

            pos += (cycles * 2);
            if (extraChars > 0) { // one or two of the extra characters can belong to a inner rail
                if (extraChars >= 2 * (n - i - 1) + 1) { // if there is enough extra charas left for it to have 2
                    coded.get(i).append(message.charAt(pos));
                    pos++;
                    extraChars--;
                }
                coded.get(i).append(message.charAt(pos));
                pos++;
                extraChars--;
            }
        }
        coded.add(new StringBuilder());
        coded.get(coded.size() - 1).append(message.substring(pos)); // last rail its the end of the coded msg
        return railRead(coded, n, message.length());
    }

    private static String railRead(List<StringBuilder> coded, int numRails, int msgLength) {
        String out = "";
        int linea = 0, direccion = 1;
        for (int i = 0; i < msgLength; i++) {
            out += coded.get(linea).charAt(0);
            coded.get(linea).deleteCharAt(0);
            linea += direccion;
            if (linea >= numRails - 1 || linea <= 0) {
                direccion = -direccion;
            }
        }
        return out;
    }
}