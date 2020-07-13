package main.java.learning.LeetCode;

import java.util.Arrays;

/*
只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* */
public class _136_onlyOneNum {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==nums[i+1])
                i++;
            else{
                flag =i;
                break;
            }
        }
        return nums[flag];
    }
}
