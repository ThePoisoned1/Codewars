public class Snail {

    public static int[] snail(int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return new int[0];
        }
        int[] out = new int[array.length * array.length];
        String[][] snailing = new String[array.length][array.length];
        for (int i = 0; i < snailing.length; i++) {
            for (int j = 0; j < snailing.length; j++) {
                snailing[i][j] = Integer.toString(array[i][j]);
            }
        }
        int numsAdded = 0;
        int posX = 0, posY = 0;
        boolean whiled = false;
        while (numsAdded < out.length) {
            while (posX < array.length && posY < array.length) { // going right
                if (snailing[posY][posX].equals("*")) {
                    break;
                }
                out[numsAdded] = Integer.parseInt(snailing[posY][posX]);
                numsAdded++;
                snailing[posY][posX] = "*";
                posX++;
                whiled = true;
            }
            if (whiled) {
                posX--;
                posY++;
            }
            while (posY < array.length && posX < array.length) { // going down
                if (snailing[posY][posX].equals("*")) {
                    break;
                }
                out[numsAdded] = Integer.parseInt(snailing[posY][posX]);
                numsAdded++;
                snailing[posY][posX] = "*";
                posY++;
                whiled = true;
            }
            posY--;
            posX--;
            while (posX >= 0 && posY >= 0) { // going left
                if (snailing[posY][posX].equals("*")) {
                    break;
                }
                out[numsAdded] = Integer.parseInt(snailing[posY][posX]);
                numsAdded++;
                snailing[posY][posX] = "*";
                posX--;
                whiled = true;
            }
            if (whiled) {
                posX++;
                posY--;
            }
            while (posY >= 0 && posX >= 0) { // going up
                if (snailing[posY][posX].equals("*")) {
                    break;
                }
                out[numsAdded] = Integer.parseInt(snailing[posY][posX]);
                numsAdded++;
                snailing[posY][posX] = "*";
                posY--;
                whiled = true;
            }
            if (whiled) {
                posY++;
                posX++;
            }
        }
        return out;
    }
}