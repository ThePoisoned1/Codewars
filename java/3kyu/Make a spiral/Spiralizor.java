public class Spiralizor {

    public static int[][] spiralize(int size) {
        int[][] spiral = new int[size][size];
        int startX = 0, startY = 0, endY = size - 1, endX = size - 1;
        boolean first = true;
        while (startX <= endX && startY < endY) {
            if (!first) {
                endX -= 2;
            }
            if (startX + 1 == endX) { // avoids adding an extra 1 horizontally, making 1s touch
                break;
            }
            for (int i = startX; i <= endX; i++) { // going right
                spiral[startY][i] = 1;
            }
            if (!first) {
                endY -= 2;
            }
            for (int i = startY; i <= endY; i++) { // going down
                spiral[i][endX] = 1;
            }
            if (!first) {
                startX += 2;
            }
            if (startX + 1 == endX) { // avoids adding an extra 1 horizontally, making 1s touch
                break;
            }
            for (int i = endX; i >= startX; i--) { // going left
                spiral[endY][i] = 1;
            }
            startY += 2;
            for (int i = endY; i >= startY; i--) { // going up;
                spiral[i][startX] = 1;
            }
            if (first) {
                first = false;
            }
        }
        return spiral;
    }

}