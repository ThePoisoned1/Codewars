import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    static List<String> operation;

    public static Double evaluate(String expression) {
        String[] x = expression.split(" ");
        operation = new ArrayList<>();
        Collections.addAll(operation, x);
        boolean watchParenthesis = true;
        int end;
        while (operation.size() > 1) {
            if (watchParenthesis) {
                watchParenthesis = checkParenthesis();
                continue;
            }
            end = operateMulDiv(0, operation.size());
            operateSumSub(0, end);
        }
        return Double.parseDouble(operation.get(0));
    }

    static boolean checkParenthesis() {
        int pStart = 0, pEnd = operation.size();
        for (int i = 0; i < operation.size(); i++) {
            if (operation.get(i).equals("(")) {
                pStart = i;
            } else if (operation.get(i).equals(")")) {
                pEnd = operateMulDiv(pStart, i);
                operateSumSub(pStart, pEnd);
                return true;
            }
        }
        return false;
    }

    static int operateMulDiv(int start, int end) {
        for (int i = start; i < end; i++) {
            if (operation.get(i).equals("*")) {
                operation.set(i, String
                        .valueOf(Double.parseDouble(operation.get(i - 1)) * Double.parseDouble(operation.get(i + 1))));
                operation.remove(i + 1);
                operation.remove(i - 1);
                end -= 2;
                i--;
            } else if (operation.get(i).equals("/")) {
                operation.set(i, String
                        .valueOf(Double.parseDouble(operation.get(i - 1)) / Double.parseDouble(operation.get(i + 1))));
                operation.remove(i + 1);
                operation.remove(i - 1);
                end -= 2;
                i--;
            }
        }
        return end;
    }

    static void operateSumSub(int start, int end) {
        for (int i = start; i < end; i++) {
            if (operation.get(i).equals("+")) {
                operation.set(i, String
                        .valueOf(Double.parseDouble(operation.get(i - 1)) + Double.parseDouble(operation.get(i + 1))));
                operation.remove(i + 1);
                operation.remove(i - 1);
                end -= 2;
                i--;
            } else if (operation.get(i).equals("-")) {
                operation.set(i, String
                        .valueOf(Double.parseDouble(operation.get(i - 1)) - Double.parseDouble(operation.get(i + 1))));
                operation.remove(i + 1);
                operation.remove(i - 1);
                end -= 2;
                i--;
            }
        }
    }
}