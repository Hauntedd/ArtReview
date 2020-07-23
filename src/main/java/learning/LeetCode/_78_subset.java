package main.java.learning.LeetCode;

import java.util.*;


/*
子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
类似递归处理
* */
public class _78_subset {
    public static void main(String[] args) {
        List<Integer> curr = new ArrayList<>();
        curr.add(10);
        List<Integer> newCurr = new ArrayList<>(curr);
        newCurr.add(20);
        System.out.println(curr);
        System.out.println(newCurr);
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());//先把默认的空集添加进去
        for (int num:nums) {
            List<List<Integer>> newSubs = new ArrayList<>();//存放加了整数的子集(防止发生覆盖，新建一个)
            for (List<Integer> curr : output) {//一开始只有空，每一轮都在所有旧子集上添加新数字
                List<Integer> temp = new ArrayList<Integer>(curr);
                temp.add(num);
                newSubs.add(temp);
            }
            for (List<Integer> newSub : newSubs) {
                output.add(newSub);
            }
        }
        return output;

    }
}
