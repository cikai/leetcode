/**
 * @author Ci Kai
 * @date 24 Jan 2018
 * @problem 747. Largest Number At Least Twice of Others
 * @website https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 */
package me.cikai.answer;

import java.util.Arrays;

public class Answer_747 {

  public static int dominantIndex(int[] nums) {
    // step 1. find out the largest number in nums.
    int[] arr = nums.clone();
    Arrays.sort(arr);
    int max = arr[arr.length - 1];

    // step 2. judge if max is at least twice as much as every other number in the nums.
    Boolean flag = true;
    int[] siblings = Arrays.copyOfRange(arr, 0, arr.length - 1);
    for (int num : siblings) {
      if (num == 0) {
        flag = true;
        continue;
      }
      if (max / num < 2) {
        flag = false;
        break;
      } else {
        flag = true;
      }
    }
    return flag ? findIndex(nums, max) : -1;
  }

  public static int findIndex(int[] arr, int t) {
    if (arr == null) {
      return -1;
    }
    int len = arr.length;
    int i = 0;
    while (i < len) {
      if (arr[i] == t) {
        return i;
      } else {
        i = i + 1;
      }
    }
    return -1;
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
