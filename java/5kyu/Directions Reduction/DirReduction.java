import java.util.ArrayList;
import java.util.Collections;

public class DirReduction {
    public static String[] dirReduc(String[] arr) {
        ArrayList<String> dirs = new ArrayList<>();
        Collections.addAll(dirs, arr);
        int pos = 0;
        while (pos < dirs.size()) {
            if (pos < dirs.size() - 1 && (dirs.get(pos).equals("NORTH") && dirs.get(pos + 1).equals("SOUTH")
                    || dirs.get(pos).equals("SOUTH") && dirs.get(pos + 1).equals("NORTH")
                    || dirs.get(pos).equals("WEST") && dirs.get(pos + 1).equals("EAST")
                    || dirs.get(pos).equals("EAST") && dirs.get(pos + 1).equals("WEST"))) {
                dirs.remove(pos + 1);
                dirs.remove(pos);
            } else if (pos > 0 && (dirs.get(pos).equals("NORTH") && dirs.get(pos - 1).equals("SOUTH")
                    || dirs.get(pos).equals("SOUTH") && dirs.get(pos - 1).equals("NORTH")
                    || dirs.get(pos).equals("WEST") && dirs.get(pos - 1).equals("EAST")
                    || dirs.get(pos).equals("EAST") && dirs.get(pos - 1).equals("WEST"))) {
                dirs.remove(pos);
                dirs.remove(pos - 1);
                pos--;

            } else {
                pos++;
            }
        }
        return dirs.toArray(String[]::new);
    }
}