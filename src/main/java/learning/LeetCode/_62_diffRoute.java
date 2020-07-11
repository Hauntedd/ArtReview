package main.java.learning.LeetCode;
/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
问总共有多少条不同的路径？
知识点：明显动态规划,很基础
注：只能走右或下====>dp[i][j] = dp[i-1][j] + dp[i][j-1];
* */

public class _62_diffRoute {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];//从1开始计算到m，n。好理解一点，存储到当前网格的路径最大数

        for (int i = 1; i < m+1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < n+1; i++) {
            dp[1][i] = 1;
        }//第一列和行先置为1
        for (int i = 2; i <m+1 ; i++) {
            for (int j = 2; j < n+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }

}
