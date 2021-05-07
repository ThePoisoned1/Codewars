public class DRoot {
    public static int digital_root(int num) {
        return num < 10 ? num : digital_root(String.valueOf(num).chars().map(Character::getNumericValue).sum());
    }

}
