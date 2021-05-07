import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Permutations {

    static Set<String> combinations;

    public static List<String> singlePermutations(String s) {
        combinations = new TreeSet<>();
        recursivePermutations("", new StringBuilder(s));
        return new ArrayList<>(combinations);
    }

    private static void recursivePermutations(String done, StringBuilder letersLeft) {
        if (letersLeft.length() <= 0) {
            combinations.add(done);
            return;
        }
        for (int i = 0; i < letersLeft.length(); i++) {
            recursivePermutations(done + letersLeft.charAt(i), new StringBuilder(letersLeft).deleteCharAt(i));
        }
    }
}