public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int min = (int) Math.floor(seconds / 60);
        seconds = seconds % 60;
        int hour = (int) Math.floor(min / 60);
        min = min % 60;
        return String.format("%02d:%02d:%02d", hour, min, seconds);
    }
}