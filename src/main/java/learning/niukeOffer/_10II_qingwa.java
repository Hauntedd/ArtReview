package main.java.learning.niukeOffer;

public class _10II_qingwa {
    public static int numWays(int n) {//迭代
        int[] dp = new int[n+1];
        dp[0] = 1;dp[1] = 1;dp[2] = 2;
        for (int i = 3; i <n+1 ; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }

    public static int numWays2(int n){//递推
        if(n==0 || n==1)
            return 1;
        if(n==2)
            return 2;
        int temp = numWays2(n-1) + numWays2(n-2);
        return temp%1000000007;
    }

    public static void main(String[] args) {
//        System.out.println(numWays2(50));//递归太深了会超时
        System.out.println(numWays(99));//迭代就没有问题
    }
}
