package scratches;

//Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".

public class RemoveString {

  public static void main(String[] args) {
    System.out.println(withoutString("Hello there", "llo")); // "He there"
    System.out.println(withoutString("Hello there", "e")); // → "Hllo thr"
    System.out.println(withoutString("Hello there", "x")); //→ "Hello there"
  }

  public static String withoutString(String base, String remove) {
    return base.replace(remove, "");
  }


}
