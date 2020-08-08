package main.java.learning.LeetCode;

import java.util.*;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。(字符串思想应该类似)
* */
public class quanPailie_46 {
    public void backtrack(int n,//序列长度
                          ArrayList<Integer> output,//输入的数字序列
                          List<List<Integer>> res,//装结果的
                          int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);//交换
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);//回溯，有点打脑壳
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int num : nums)//数组转换成列表，为了后面交换方便
            output.add(num);

        int n = nums.length;
        backtrack(n, output, res, 0);//res暂时是空的
        return res;
    }

}


