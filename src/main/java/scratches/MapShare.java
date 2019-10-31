package scratches;


//Modify and return the given map as follows: if the key "a" has a value, set the key "b" to have
//that same value. In all cases remove the key "c", leaving the rest of the map unchanged.

import java.util.HashMap;
import java.util.Map;

public class MapShare {
  mapShare({"a": "aaa", "b": "bbb", "c": "ccc"}) → {"a": "aaa", "b": "aaa"}
  mapShare({"a": "aaa", "c": "meh", "d": "hi"}) → {"a": "aaa", "b": "aaa", "d": "hi"}
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("b", "xyz");
    map.put("c", "ccc");
    System.out.println(mapShare(map)); //→ {"b":"xyz"}

    map.clear();
    map.put("a", "aaa");
    map.put("b", "bbb");
    map.put("c", "ccc");
    System.out.println(mapShare(map));// → {"a":"aaa","b":"aaa"}

    map.clear();
    map.put("a", "aaa");
    map.put("c", "meh");
    map.put("d", "hi");
    System.out.println(mapShare(map));// → {"a":"aaa","b":"aaa","d":"hi"}
  }

  public static Map<String, String> mapShare(Map<String, String> map) {
    Map<String, String> orig = map;
    if(orig == null || orig.isEmpty())
      return orig;

    orig.remove("c");
    boolean hasA = containsNotEmpty(orig, "a");
    boolean hasB = containsNotEmpty(orig, "b");

    if(hasA && hasB) {
      //There is definitely a more elegant way
      String a = orig.get("a");
      String b = orig.get("b");
      orig.replace("a", b);
      orig.replace("b", a);
    }
    return orig;
  }

  private static boolean containsNotEmpty(Map<String, String> orig, String a) {
    return (orig.containsKey("a") && !orig.get("a").isEmpty());
  }

}
