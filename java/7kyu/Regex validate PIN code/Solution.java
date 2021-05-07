public class Solution {

    public static boolean validatePin(String pin) {
        if (pin.length() != 6 && pin.length() != 4)
            return false;
        for (char digit : pin.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
}
