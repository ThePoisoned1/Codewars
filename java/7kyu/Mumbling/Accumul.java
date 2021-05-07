public class Accumul {
    
    public static String accum(String s) {
        s = s.toLowerCase();
        String out = "" + Character.toUpperCase(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            out += "-" + Character.toUpperCase(s.charAt(i));
            for (int j = 0; j < i; j++) {
                out += s.charAt(i);
            }
        }
        return out;
    }
}