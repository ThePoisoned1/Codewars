import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        List<String> out = new ArrayList<>();
        int years = seconds / 31536000, days = (seconds / 86400) % 365, hours = (seconds / 3600) % 24,
                minutes = (seconds / 60) % 60;
        seconds = seconds % 60;
        if (years > 0)
            out.add(formatTime("year", years));
        if (days > 0)
            out.add(formatTime("day", days));
        if (hours > 0)
            out.add(formatTime("hour", hours));
        if (minutes > 0)
            out.add(formatTime("minute", minutes));
        if (seconds > 0)
            out.add(formatTime("second", seconds));
        return addMarks(out);
    }

    static String formatTime(String unit, int time) {
        return Integer.toString(time) + " " + unit + (time == 1 ? "" : "s");
    }

    static String addMarks(List<String> times) {
        if (times.size() < 1) {
            return "now";
        } else if (times.size() == 1) {
            return times.get(0);
        }
        String out = times.get(0);
        for (int i = 1; i < times.size() - 1; i++) {
            out += ", " + times.get(i);
        }
        return out += " and " + times.get(times.size() - 1);
    }
}