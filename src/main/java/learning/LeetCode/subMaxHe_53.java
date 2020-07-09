package main.java.learning.LeetCode;
/*
最大子序列和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
这提莫的是动态规划？
* */
public class subMaxHe_53 {

    public int maxSubArray(int[] nums) {
        int pre = 0;//这个值的作用是当前一个子序列为负数时丢弃。
        int maxAns = nums[0];//这个值就是一直存储最大子序列的值(从前到后试)
        for (int x :nums) {
            pre = Math.max(pre + x,x);//这里决定ai单独成为一段，还是ai+f(i-1) 注：f(i-1)并不一定大于f(i-2),但若i-1是个小负数呢就必然会加入进去得到正结果
            maxAns = Math.max(maxAns,pre);//选择保留
        }
        return maxAns;
    }
}
