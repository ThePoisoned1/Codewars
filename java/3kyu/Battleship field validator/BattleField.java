public class BattleField {

    static int battleships, cruisers, destroyers, submarines;

    static boolean checkShips(int size) {
        switch (size) {
            case 1:
                submarines++;
                break;
            case 2:
                destroyers++;
                break;
            case 3:
                cruisers++;
                break;
            case 4:
                battleships++;
                break;
            default:
                return false;
        }
        return battleships <= 1 && cruisers <= 2 && destroyers <= 3 && submarines <= 4;
    }

    static boolean checkBeginingCornersH(int y, int x, int[][] field) {
        return ((x > 0 && y > 0) && field[y - 1][x - 1] != 0)
                || ((x > 0 && y < field.length - 1) && field[y + 1][x - 1] != 0);
    }

    static boolean checkEndingCornersH(int y, int x, int[][] field) {
        return ((x < field[y].length - 1 && y > 0) && field[y - 1][x + 1] != 0)
                || ((x < field[y].length - 1 && y < field.length - 1) && field[y + 1][x + 1] != 0);
    }

    static boolean checkBeginingCornersV(int y, int x, int[][] field) {
        return ((x > 0 && y > 0) && field[y - 1][x - 1] != 0)
                || ((x < field[y].length - 1 && y > 0) && field[y - 1][x + 1] != 0);
    }

    static boolean checkEndingCornersV(int y, int x, int[][] field) {
        return ((x < field[y].length - 1 && y < field[y].length - 1) && field[y + 1][x + 1] != 0)
                || ((x > 0 && y < field[y].length - 1) && field[y + 1][x - 1] != 0);
    }

    static boolean checkVertical(int y, int x, int[][] field) {
        int startY = y;
        int size = 0;
        if (checkBeginingCornersV(y, x, field)) {
            return false;
        }
        while (y < field.length && field[y][x] == 1) {
            if (x > 0 && field[y][x - 1] != 0) {
                return false;
            }
            if (x < field.length - 1 && field[y][x + 1] != 0) {
                return false;
            }
            y++;
            size++;
        }
        if (checkEndingCornersV(y - 1, x, field)) {
            return false;
        }
        for (int i = startY; i < y; i++) {
            field[i][x] = 0;
        }

        return checkShips(size);
    }

    static boolean checkHorizontal(int y, int x, int[][] field) {
        int startX = x;
        int size = 0;
        if (checkBeginingCornersH(y, x, field)) {
            return false;
        }
        while (x < field[y].length && field[y][x] == 1) {
            if (y > 0 && field[y - 1][x] != 0) {
                return false;
            }
            if (y < field[y].length - 1 && field[y + 1][x] != 0) {
                return false;
            }
            x++;
            size++;
        }
        if (checkEndingCornersH(y, x - 1, field)) {
            return false;
        }
        for (int i = startX; i < x; i++) {
            field[y][i] = 0;
        }

        return checkShips(size);
    }

    public static boolean fieldValidator(int[][] field) {
        battleships = 0;
        cruisers = 0;
        destroyers = 0;
        submarines = 0;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    if (!(checkVertical(i, j, field) || checkHorizontal(i, j, field))) {
                        return false;
                    }
                }
            }
        }
        return battleships == 1 && cruisers == 2 && destroyers == 3 && submarines == 4;
    }
}