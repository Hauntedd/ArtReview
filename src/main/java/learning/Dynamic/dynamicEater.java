package main.java.learning.Dynamic;

import java.util.Scanner;

/*
    总结一下：子序列问题从后到前，填表法从前到后一排一排来
    两行数据。
    第一行为一个整数n，表示小吃街上小吃的数量
    第二行为n个整数，分别表示n种食物的“美味度”
    求一个最长的不下降的子序列的问题
* */
public class dynamicEater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] delicacys = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                delicacys[i] = scanner.nextInt();
                dp[i] = 1;
            }
            for (int i = 1; i < n; i++) {//从小到大计算子序列长度,第一个必然是1就不算了
                for (int j = i-1; j >=0; j--) {
                    if(delicacys[i]>= delicacys[j]){//满足不下降
                        if(dp[j]>=dp[i]){//判断j的子序列(子序列可以是它自己)是否不小于当前序列的长度。如果是则接入子序列，否则寻找下一个子序列(像递归)
                            dp[i] = Math.max(dp[i],dp[j]) + 1 ;//这里直接用dp[j]应该就可以了
                        }
                    }
                }
            }
            int max = 1;
            for (int i = 0; i <n ; i++) {
                if(max<dp[i]){
                    max = dp[i];
                }
            }
            System.out.println(max);
        }
    }
}
