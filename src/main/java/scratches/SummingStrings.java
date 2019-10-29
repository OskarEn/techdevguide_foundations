package scratches;

public class SummingStrings {

  public static void main(String[] args) {
    System.out.println(sumNumbers("abc123xyz")); // → 123
    System.out.println(sumNumbers("aa11b33")); // → 44
    System.out.println(sumNumbers("7 11")); // → 18
  }

  private static int sumNumbers(String alphanumeric) {
    char[] chars = alphanumeric.toCharArray();
    int sum = 0;
    for(int i = 0; i < alphanumeric.length(); ) {
      if(Character.isDigit(chars[i])) {
        System.out.println("Checking " + chars[i] );
        String fullNumber = "" + chars[i];

        while( ((i + 1) < alphanumeric.length()) && Character.isDigit(chars[i + 1])) {
          i++;
          fullNumber += chars[i];
        }
        sum += Integer.parseInt(fullNumber);
      } else {
        i++;
      }
    }
    return sum;
  }
}
