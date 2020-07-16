package main.java.learning.LeetCode;

import java.util.Arrays;

/*
多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
* */
public class _169_mostElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        //由多数元素的定义可知，中位数必须是多数元素
        return nums[nums.length/2];
    }
//    也可以采用分治法,递归求解 如果数 a 是数组 nums 的众数，
// 如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数。如果左右两边求出来的众数不同，那么就遍历数组看谁更多即可
    class Solution {
        private int countInRange(int[] nums, int num, int lo, int hi) {//求某个数在数组中出现的次数
            int count = 0;
            for (int i = lo; i <= hi; i++) {
                if (nums[i] == num) {
                    count++;
                }
            }
            return count;
        }

        private int majorityElementRec(int[] nums, int lo, int hi) {//递归函数
            // base case; the only element in an array of size 1 is the majority
            // element.
            if (lo == hi) {
                return nums[lo];
            }

            // recurse on left and right halves of this slice.
            int mid = (hi-lo)/2 + lo;
            int left = majorityElementRec(nums, lo, mid);
            int right = majorityElementRec(nums, mid+1, hi);

            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }

            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, lo, hi);//左右两边的众数不同，则进行遍历求解(遍历范围是当前左+右)
            int rightCount = countInRange(nums, right, lo, hi);

            return leftCount > rightCount ? left : right;
        }

        public int majorityElement(int[] nums) {
            return majorityElementRec(nums, 0, nums.length-1);
        }
    }

}
