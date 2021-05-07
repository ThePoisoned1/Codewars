import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        return checking0s(sudoku) ? checkRows(sudoku) && checkColumns(sudoku) && check3x3s(sudoku) : false;
    }

    static boolean checking0s(int[][] sudoku) {
        for (int[] row : sudoku) {
            for (int i : row) {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean check3x3s(int[][] sudoku) {
        Set<Integer> set = new HashSet<>();
        int startY, startX;
        for (int i = 0; i < 9; i++) {
            startY = i % 3 * 3;
            startX = 3 * (i / 3);
            set.clear();
            for (int j = startY; j <= startY + 2; j++) {
                for (int k = startX; k <= startX + 2; k++) {
                    set.add(sudoku[j][k]);
                }
            }
            if (set.size() != 9) {
                return false;
            }
        }
        return true;
    }

    static boolean checkRows(int[][] sudoku) {
        Set<Integer> set = new HashSet<>();
        for (int[] row : sudoku) {
            set.clear();
            for (int i : row) {
                set.add(i);
            }
            if (set.size() < 9) {
                return false;
            }
        }
        return true;
    }

    static boolean checkColumns(int[][] sudoku) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.clear();
            for (int j = 0; j < 9; j++) {
                set.add(sudoku[j][i]);
            }
            if (set.size() < 9) {
                return false;
            }
        }
        return true;
    }
}