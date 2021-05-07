import java.util.ArrayList;

class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {
        int in = 0, out = 0;
        for (int[] stop : stops) {
            in += stop[0];
            out += stop[1];
        }
        return in - out;
    }
}