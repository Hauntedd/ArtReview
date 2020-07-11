package main.java.learning.LeetCode;
/*
爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
动态规划：f(x) = f(x-1)+f(x-2)
* */
public class _70_ascStairs {
    public int climbStairs(int n) {
        int[] steps = new int[n+1];
        steps[1] = 1;steps[2] = 2;//先把初始值设置了
        for (int i = 3; i < n+1 ; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
