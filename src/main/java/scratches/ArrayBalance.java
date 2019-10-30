package scratches;

public class ArrayBalance {

  public static void main(String[] args) {
    System.out.println(canBalance( new int[]{1, 1, 1, 2, 1}));// → true
    System.out.println(canBalance( new int[]{2, 1, 1, 2, 1}));// → false
    System.out.println(canBalance( new int[]{10, 10}));// → true
  }

  public static boolean canBalance(int[] nums) {
    int left = 0;
    int right = sumArray(nums);

    for(int i = 0; i < nums.length; i++) {
        left+= nums[i];
        right-= nums[i];
        if(left == right)
          return true;
    }
      return false;
  }

  private static int sumArray(int[] nums) {
    int sum = 0;
    for(int i : nums) {
      sum += i;
    }
    return sum;
  }
}
