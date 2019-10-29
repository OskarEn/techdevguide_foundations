package scratches;

import java.util.Iterator;

public class SummingStrings {

  public static void main(String[] args) {
    System.out.println(sumNumbers("abc123xyz")); // → 123
    System.out.println(sumNumbers("aa11b33")); // → 44
    System.out.println(sumNumbers("7 11")); // → 18
  }

  private static int sumNumbers(String alphanumeric) {
    char[] chars = alphanumeric.toCharArray();
    int sum = 0;
    for(int i = 0; i < chars.length; i++) {
      chars[i] = (Character.isDigit(chars[i])) ? chars[i] : ' ';
    }
    System.out.println(chars);
    String[] numbers = chars.toString().split(" ");
    for (String num : numbers) {
      System.out.println(num);
    }
    for(String num : numbers) {
      if(!num.contains(" ")) {
        sum+=Integer.parseInt(num.trim());
      }
    }
    return sum;
  }
}
