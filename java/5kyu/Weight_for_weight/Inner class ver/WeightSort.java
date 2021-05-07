import java.util.Arrays;


public class WeightSort {

    static class Num implements Comparable<Num> {

        String num;
        int pos;
        int weight;

        Num(String num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Num o) {
            if (this.weight > o.weight) {
                return 1;
            } else if (this.weight < o.weight) {
                return -1;
            } else {
                int i = 0;
                while (i < this.num.length() && i < o.num.length()) {
                    if (Character.getNumericValue(this.num.charAt(i)) > Character.getNumericValue(o.num.charAt(i))) {
                        return 1;
                    } else if (Character.getNumericValue(this.num.charAt(i)) < Character.getNumericValue(o.num.charAt(i))) {
                        return -1;
                    } else {
                        i++;
                    }
                }
                return this.num.length() > o.num.length() ? 1 : -1;
            }
        }
    }

    public static String orderWeight(String strng) {
        String[] numbers = strng.split(" ");
        Num[] nums = new Num[numbers.length];
        int weight;
        for (int i = 0; i < numbers.length; i++) {
            weight = 0;
            for (int j = 0; j < numbers[i].length(); j++) {
                weight += Character.getNumericValue(numbers[i].charAt(j));
            }
            nums[i] = new Num(numbers[i], weight);
        }
        Arrays.sort(nums);
        String out = "";
        for (Num num : nums) {
            System.out.println(num.num + " " + num.pos + " " + num.weight);
            out += num.num + " ";
        }

        return out.trim();
    }
}
