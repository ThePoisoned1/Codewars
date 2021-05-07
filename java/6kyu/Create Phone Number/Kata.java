public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        String phone = "(";
        for (int i = 0; i < 3; i++) {
            phone += numbers[i];
        }
        phone += ") ";
        for (int i = 3; i < 6; i++) {
            phone += numbers[i];
        }
        phone += "-";
        for (int i = 6; i < 10; i++) {
            phone += numbers[i];
        }
        return phone;
    }
}