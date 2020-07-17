package main.java.learning.LeetCode;
/*
2的幂
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
* */
public class _231_2deMi {
    public boolean isPowerOfTwo(int n) {//简单方案
        if(n==0)
            return false;
        while (n%2==0)
            n /= 2;
        return n==1;
    }
    public boolean isPowerOfTwo2(int n){//二进制中2的次幂只有一个1，那么n-1会是那一位变成0后续全部为1所以：
        if(n==0)
            return false;
        long num = (long)n;//转型怕溢出(int_min)
        return (num &(num -1)) == 0;
    }
}
