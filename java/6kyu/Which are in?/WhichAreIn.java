import java.util.TreeSet;

public class WhichAreIn {

    public static String[] inArray(String[] array1, String[] array2) {
        TreeSet<String> aux = new TreeSet<>();
        String[] output;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array2[j].contains(array1[i])) {
                    aux.add(array1[i]);
                }
            }
        }
        output = new String[aux.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = aux.pollFirst();
        }
        return output;
    }
}