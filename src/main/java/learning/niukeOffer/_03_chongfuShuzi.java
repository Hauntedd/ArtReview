package main.java.learning.niukeOffer;

import java.util.HashSet;
import java.util.Set;

/*
剑指 Offer 03. 数组中重复的数字
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
* */
public class _03_chongfuShuzi {
    public int findRepeatNumber(int[] nums){
        //可以应用hashset的特性来做
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if(set.contains(num)){
                repeat = num;
                break;
            }
            set.add(num);
        }
        return repeat;
    }
}
