class Solution {
  public static String camelCase(String input) {
    return String.join(" ", input.split("(?=\\p{Lu})"));
  }
}
