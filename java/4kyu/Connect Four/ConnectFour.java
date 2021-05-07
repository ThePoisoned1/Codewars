import java.util.*;

public class ConnectFour {
    static char[][] field;
    static int lastColumn, lastRow;

    public static String whoIsWinner(List<String> piecesPositionList) {
        field = new char[6][7];
        for (String move : piecesPositionList) {
            placeCoin(move);
            if (isWinner(lastRow, lastColumn, move.charAt(2))) {
                return field[lastRow][lastColumn] == 'R' ? "Red" : "Yellow";
            }
        }
        return "Draw";
    }

    private static boolean isWinner(int y, int x, char winner) {
        int toOneSide = 0, toTheOther = 0;
        boolean change = true;
        while ((y + toOneSide + 1 < field.length || y - (toTheOther + 1) >= 0) && (change)) { // vertical check
            change = false;
            if (y + toOneSide + 1 < field.length && field[y + toOneSide + 1][x] == winner) {
                toOneSide++;
                change = true;
            }
            if (y - (toTheOther + 1) >= 0 && field[y - (toTheOther + 1)][x] == winner) {
                toTheOther++;
                change = true;
            }
            if (toOneSide + toTheOther >= 3) {
                return true;
            }
        }
        toOneSide = 0;
        toTheOther = 0;
        change = true;
        while ((x - (toTheOther + 1) >= 0 || x + toOneSide + 1 < field.length) && (change)) { // horizontal check
            change = false;
            if (x + toOneSide + 1 < field[0].length && field[y][x + toOneSide + 1] == winner) {
                toOneSide++;
                change = true;
            }
            if (x - (toTheOther + 1) >= 0 && field[y][x - (toTheOther + 1)] == winner) {
                toTheOther++;
                change = true;
            }
            if (toOneSide + toTheOther >= 3) {
                return true;
            }
        }
        toOneSide = 0;
        toTheOther = 0;
        change = true;
        while ((y + toOneSide + 1 < field.length && x - (toOneSide + 1) >= 0 //
                || y - (toTheOther + 1) >= 0 // uphill check
                        && x + toTheOther + 1 < field[0].length)
                && (change)) {
            change = false;
            if ((y + toOneSide + 1 < field.length && x - (toOneSide + 1) >= 0)
                    && field[y + toOneSide + 1][x - toOneSide - 1] == winner) {
                toOneSide++;
                change = true;
            }
            if ((y - (toTheOther + 1) >= 0 && x + toTheOther + 1 < field[0].length)
                    && field[y - (toTheOther + 1)][x + toTheOther + 1] == winner) {
                toTheOther++;
                change = true;
            }
            if (toOneSide + toTheOther >= 3) {
                return true;
            }
        }
        toOneSide = 0;
        toTheOther = 0;
        change = true;
        while (((y + toOneSide + 1 < field.length && x + toOneSide + 1 < field[0].length)
                || (y - (toTheOther + 1) >= 0 && x - (toTheOther + 1) >= 0)) && (change)) { // downhill check
            change = false;
            if ((y + toOneSide + 1 < field.length && x + toOneSide + 1 < field[0].length)
                    && field[y + toOneSide + 1][x + toOneSide + 1] == winner) {
                toOneSide++;
                change = true;
            }
            if ((y - (toTheOther + 1) >= 0 && x - (toTheOther + 1) >= 0)
                    && field[y - (toTheOther + 1)][x - (toTheOther + 1)] == winner) {
                toTheOther++;
                change = true;
            }
            if (toOneSide + toTheOther >= 3) {
                return true;
            }
        }
        return false;
    }

    private static void placeCoin(String move) {
        String columns = "ABCDEFG";
        int column = columns.indexOf(move.charAt(0));
        int row = field.length - 1;
        while (row > 0 && (field[row][column] == 'R' || field[row][column] == 'Y')) {
            row--;
        }
        field[row][column] = move.charAt(2);
        lastRow = row;
        lastColumn = column;
    }
}