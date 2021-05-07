import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class DoubleLinear {

    static ArrayList<Integer> lmao;
    static boolean lmaoed = false;

    static void calculateSequence() {
        TreeSet<Integer> sequence = new TreeSet<>();
        sequence.add(1);
        sequence.add(3);
        sequence.add(4);
        List<List<Integer>> tree = new ArrayList<>();
        tree.add(new ArrayList<>());
        tree.get(0).add(1);
        tree.add(new ArrayList<>());
        tree.get(1).add(3);
        tree.get(1).add(4);
        int x;
        int row = 2;
        int num;
        while (sequence.size() < 262143) { // if you dont know when to stop, don't stop ;)
            tree.add(new ArrayList<>());
            for (int i = 0; i < tree.get(row - 1).size(); i++) {
                x = tree.get(row - 1).get(i);
                num = 2 * x + 1;
                tree.get(row).add(num);
                sequence.add(num);
                num = 3 * x + 1;
                tree.get(row).add(num);
                sequence.add(num);
            }
            row++;
        }
        tree.clear();
        lmao = new ArrayList<>(sequence);
    }

    public static int dblLinear(int n) {
        if (!lmaoed) {
            calculateSequence();
            lmaoed = true;
        }
        return lmao.get(n);
    }
}