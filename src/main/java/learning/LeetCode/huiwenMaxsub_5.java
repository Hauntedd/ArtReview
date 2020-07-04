package main.java.learning.LeetCode;
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例：输入: "babad"，输出: "bab",aba也可
分析：
回文的状态转移性质，一个回文去掉两头之后依然是回文
二维动态规划:dp[i][j]表示子串是s[i..j]是否为回文子串。这里定义为左闭右闭(j>i)
状态方程 dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
* */
public class huiwenMaxsub_5 {
    public String longestPalindrome(String s){
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();//字符串转换为数组

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;//对角线是单字符所以肯定是回文
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {//首尾不相等，设为false
                    dp[i][j] = false;
                } else {//首尾相等
                    if (j - i < 3) {//字符串长度不大于三(边界条件)，可以直接判断为回文串
                        dp[i][j] = true;
                    } else {//字符串大于3,判断子串
                        dp[i][j] = dp[i + 1][j - 1];//因为这个子串的特性，所以先循环列，再循环行(只用到了表的右上半部分)
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && (j - i + 1 > maxLen)) {//这样写可以避免在输出的时候再遍历求值
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);//左闭右开

    }

}
