package scratches;


//Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have
//that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

import java.util.Map;

public class MapShare {

  public static void main(String[] args) {
    mapShare({"b":"xyz","c":"ccc"}) //→ {"b":"xyz"}
    mapShare({"a":"aaa","b":"bbb","c":"ccc"})// → {"a":"aaa","b":"aaa"}
    mapShare({"a":"aaa","c":"meh","d":"hi"})// → {"a":"aaa","b":"aaa","d":"hi"}
  }

  public static Map<String, String> mapShare(Map<String, String> orig) {
    if(orig == null || orig.isEmpty())
      return orig;

    orig.remove("c");
    boolean hasA = containsNotEmpty(orig, "a");
    boolean hasB = containsNotEmpty(orig, "b");

    if(!hasA && !hasB)
      return orig;

    //There is definitely a more elegant way
    if(hasA ^ hasB) {
      if(hasA) {
        orig.put("b", orig.get("a"));
        orig.remove("a");
      } else {
        orig.put("a", orig.get("b"));
        orig.remove("b");
      }

      return orig;
    }

    //There is definitely a more elegant way
    String a = orig.get("a");
    String b = orig.get("b");
    orig.replace("a", b);
    orig.replace("b", a);
    return orig;

    orig.computeIfAbsent("b", () -> {})
  }

  private static boolean containsNotEmpty(Map<String, String> orig, String a) {
    return (orig.containsKey("a") && !orig.get("a").isEmpty());
  }

}
