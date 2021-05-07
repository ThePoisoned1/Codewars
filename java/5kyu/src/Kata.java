public class Kata {

    public static String encrypt(String text, final int n) {
        if (text == null) return null;       
        if (text.length() <= 1) return text;  
            System.out.println(n + " c " + text);     
        String tocrypt = text, crypted = text;
      int limit = n <= (text.length() + 1) ? n : n % (text.length() + 1);
        for (int i = 0; i < limit; i++) {
            crypted = "";  
            for (int j = 1; j < tocrypt.length(); j += 2) crypted += tocrypt.charAt(j);
            for (int j = 0; j < tocrypt.length(); j += 2) crypted += tocrypt.charAt(j);
            tocrypt = crypted; 
        }
        return crypted;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null) return null;
        if (encryptedText.length() <= 1) return encryptedText;
      System.out.println(n + " d " + encryptedText); 
        String[] halfs = new String[2];
        String decrypted = encryptedText, toDecrypt = encryptedText;
        int mid = Math.floorDiv(encryptedText.length(), 2); 
      int limit = n <= (encryptedText.length() + 1) ? n : n % (encryptedText.length() + 1);
        for (int i = 0; i < limit; i++) {
            decrypted = "";
            halfs[0] = toDecrypt.substring(0, mid);
            halfs[1] = toDecrypt.substring(mid);
            for (int j = 0; j < halfs[0].length(); j++) {
                decrypted += halfs[1].charAt(j);
                decrypted += halfs[0].charAt(j);
            }
            if (halfs[1].length() > halfs[0].length()) decrypted += halfs[1].charAt(halfs[1].length() - 1);
            toDecrypt = decrypted;
        }
        return decrypted;
    }
  
}
