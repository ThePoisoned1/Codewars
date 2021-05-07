public class ScreenLock {

    char[] ezCorner = { 'B', 'D', 'E', 'F', 'H' }; // any corner can connect to this positions at all times
    char[] ezNorthSouth = { 'A', 'C', 'D', 'E', 'F', 'G', 'I' }; // B and H can connect to this oens at all times
    char[] ezEastWest = { 'A', 'B', 'C', 'E', 'G', 'H', 'I' }; // D and F can connect to this oens at all times
    char[] ezMid = { 'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I' }; // E just can connect to whatever (but himself)

    int calculating(String pattern, char last, int patternLength) {

        if (patternLength == 0) { // reached the inputed length
            return 1;
        }
        int total = 0;
        switch (last) {
            case 'A':
                for (int i = 0; i < ezCorner.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezCorner[i]))) {
                        total += calculating(pattern + last, ezCorner[i], patternLength - 1);
                    }
                }
                if (pattern.contains("B") && !pattern.contains("C")) { // can conect under a cirscuntance
                    total += calculating(pattern + last, 'C', patternLength - 1);
                }
                if (pattern.contains("D") && !pattern.contains("G")) {
                    total += calculating(pattern + last, 'G', patternLength - 1);
                }
                if (pattern.contains("E") && !pattern.contains("I")) {
                    total += calculating(pattern + last, 'I', patternLength - 1);
                }
                break;
            case 'B':
                for (int i = 0; i < ezNorthSouth.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezNorthSouth[i]))) {
                        total += calculating(pattern + last, ezNorthSouth[i], patternLength - 1);
                    }
                }
                if (pattern.contains("E") && !pattern.contains("H")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'H', patternLength - 1);
                }
                break;
            case 'C':
                for (int i = 0; i < ezCorner.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezCorner[i]))) {
                        total += calculating(pattern + last, ezCorner[i], patternLength - 1);
                    }
                }
                if (pattern.contains("B") && !pattern.contains("A")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'A', patternLength - 1);
                }
                if (pattern.contains("E") && !pattern.contains("G")) {
                    total += calculating(pattern + last, 'G', patternLength - 1);
                }
                if (pattern.contains("F") && !pattern.contains("I")) {
                    total += calculating(pattern + last, 'I', patternLength - 1);
                }
                break;
            case 'D':
                for (int i = 0; i < ezEastWest.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezEastWest[i]))) {
                        total += calculating(pattern + last, ezEastWest[i], patternLength - 1);
                    }
                }
                if (pattern.contains("E") && !pattern.contains("F")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'F', patternLength - 1);
                }
                break;
            case 'E':
                for (int i = 0; i < ezMid.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezMid[i]))) {
                        total += calculating(pattern + last, ezMid[i], patternLength - 1);
                    }
                }
                break;
            case 'F':
                for (int i = 0; i < ezEastWest.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezEastWest[i]))) {
                        total += calculating(pattern + last, ezEastWest[i], patternLength - 1);
                    }
                }
                if (pattern.contains("E") && !pattern.contains("D")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'D', patternLength - 1);
                }
                break;
            case 'G':
                for (int i = 0; i < ezCorner.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezCorner[i]))) {
                        total += calculating(pattern + last, ezCorner[i], patternLength - 1);
                    }
                }
                if (pattern.contains("D") && !pattern.contains("A")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'A', patternLength - 1);
                }
                if (pattern.contains("E") && !pattern.contains("C")) {
                    total += calculating(pattern + last, 'C', patternLength - 1);
                }
                if (pattern.contains("H") && !pattern.contains("I")) {
                    total += calculating(pattern + last, 'I', patternLength - 1);
                }
                break;
            case 'H':
                for (int i = 0; i < ezNorthSouth.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezNorthSouth[i]))) {
                        total += calculating(pattern + last, ezNorthSouth[i], patternLength - 1);
                    }
                }
                if (pattern.contains("E") && !pattern.contains("B")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'B', patternLength - 1);
                }
                break;
            case 'I':
                for (int i = 0; i < ezCorner.length; i++) { // can always conect to this
                    if (!pattern.contains(String.valueOf(ezCorner[i]))) {
                        total += calculating(pattern + last, ezCorner[i], patternLength - 1);
                    }
                }
                if (pattern.contains("E") && !pattern.contains("A")) {// can conect under a cirscuntance
                    total += calculating(pattern + last, 'A', patternLength - 1);
                }
                if (pattern.contains("F") && !pattern.contains("C")) {
                    total += calculating(pattern + last, 'C', patternLength - 1);
                }
                if (pattern.contains("H") && !pattern.contains("G")) {
                    total += calculating(pattern + last, 'G', patternLength - 1);
                }
                break;
        }
        return total;
    }

    public int calculateCombinations(char startPosition, int patternLength) {

        if (patternLength > 9 || patternLength == 0) { // higher than the maximun pattern or 0
            return 0;
        }

        return calculating("", startPosition, patternLength - 1);
    }
}