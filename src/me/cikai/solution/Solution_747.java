/**
 * @author Ci Kai
 * @date 24 Jan 2018
 * @problem 747. Largest Number At Least Twice of Others
 * @website https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 */
package me.cikai.solution;

public class Solution_747 {

  public static int dominantIndex(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }
    for (int i = 0; i < nums.length; ++i) {
      if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) {
        return -1;
      }
    }
    return maxIndex;
  }

  public static void main(String[] args) {
    int[] foo1 = {0, 0, 0, 1};
    int bar1 = dominantIndex(foo1);
    System.out.println(bar1);

    int[] foo2 = {1, 0, 0, 0};
    int bar2 = dominantIndex(foo2);
    System.out.println(bar2);
  }

}
