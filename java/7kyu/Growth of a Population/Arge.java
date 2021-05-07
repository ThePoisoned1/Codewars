class Arge {
    
    public static int nbYear(int p0, double percent, int aug, int p) {
        percent /= 100;
        double population = p0;
        int years = 0;
        while (population < p) {
            population = population + population * percent + aug;
            years++;
        }
        return years;
    }
}
