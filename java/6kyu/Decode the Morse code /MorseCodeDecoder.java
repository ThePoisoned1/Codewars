public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse
        // code table through MorseCode.get(code)
        String decoded = "";
        String[] letras = morseCode.split(" ");
        for (int i = 0; i < letras.length; i++) {
            if (letras[i].length() > 0) {
                // decoded += MorseCode.get(letras[i]); // uncomment this
            } else {
                if (decoded.length() > 0 && decoded.charAt(decoded.length() - 1) != ' ') {
                    decoded += " ";
                }
            }
        }
        return decoded;
    }
}