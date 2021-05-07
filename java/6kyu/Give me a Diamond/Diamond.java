class Diamond {
    public static String print(int n) {
        if (n % 2 == 0 || n < 0) {
            return null;
        }
        StringBuilder diamond = new StringBuilder();
        for (int i = 0; i < n; i++) {
            diamond.append("*");
        }
        diamond.append("\n");
        StringBuilder row = new StringBuilder(diamond);
        for (int i = 0; i < n / 2; i++) {
            row.deleteCharAt(row.length() - 2);
            row.replace(i, i + 1, " ");
            diamond.insert(0, row);
            diamond.append(row);
        }
        return diamond.toString();
    }
}