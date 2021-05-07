class Solution {

    public static String rangeExtraction(int[] arr) {
        int inRow = 0;
        int start = arr[0];
        String out = "";
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                if (inRow == 0) {
                    start = arr[i - 1]; // an interval can start in the previous number
                }
                inRow++;
                if (inRow < 2) { // there is an interval. We put the begining of it
                    out += "," + start;
                }
            } else {
                if (inRow >= 2) {
                    out += "-"; // inteval ended
                } else {
                    out += ","; // single number
                }
                out += arr[i - 1];
                inRow = 0;
            }
        }
        if (inRow >= 2) { // last check
            out += "-";
        } else {
            out += ",";
        }
        return out.substring(1) + arr[arr.length - 1];
    }
}