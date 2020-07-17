package main.java.learning.LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给定一个整数数组，判断是否存在重复元素。
如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
* */
public class _217_chongfuElement {
    public boolean containsDuplicate(int[] nums) {//可用方法：排序后遍历，就不写了
        //方法二：hash表
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
