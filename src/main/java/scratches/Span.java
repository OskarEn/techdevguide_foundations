package scratches;

import java.util.HashSet;
import java.util.Set;

public class Span {

//  Consider the leftmost and righmost appearances of some value in an array.
//  We'll say that the "span" is the number of elements between the two inclusive.
//  A single value has a span of 1. Returns the largest span found in the given array.
//  maxSpan([1, 2, 1, 1, 3]) → 4
//  maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6

  public int maxSpan(int[] nums) {
    int maxSpan = 0;
    for(int number : nums) {
      int span = nSquared(number, nums);
      maxSpan = span > maxSpan ? span : maxSpan;
    }
    return maxSpan;
  }

  public int quickerSpan(int[] nums) {
    Set<Integer> distinct = new HashSet<>();
    for(int number : nums)
      distinct.add(number);

    int largest = 0;
    for(Integer I : distinct) {
      int result = findFirst(I, nums) + findLast(I, nums);
      if(result > largest)
          largest = result;
    }
    return largest;
  }

  private int nSquared(int number, int[] nums) {
    //very slow
    int firstIndex = findFirst(number, nums);
    int lastIndex = findLast(number, nums);

    if (firstIndex != -1 && lastIndex != -1)
      return lastIndex + 1 - firstIndex;

    return 0;
  }

  private int findFirst(int number, int[] nums) {
    for (int first = 0; first < nums.length; first++) {
      if (number == nums[first]) {
        return first;
      }
    }
    return -1;
  }

  private int findLast(int number, int[] nums) {
    for (int last = nums.length - 1; last > 0; last--) {
      if (number == nums[last]) {
        return last;
      }
    }
    return -1;
  }
}
