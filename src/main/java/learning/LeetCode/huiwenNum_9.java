package main.java.learning.LeetCode;
/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。（负数8行）
* */
public class huiwenNum_9 {

    public boolean isPalindrrome(int x){
        if(x<0)
            return false;
        int cur = 0;
        int num = x;
        while (num !=0){
            cur = cur *10 + num %10;
            num /= 10;
        }
        return cur == x;//这是考虑到回文数必然相等所以没考虑溢出的问题(溢出了必然不相等。而且不报错)
    }

    public boolean isPalindrrome2(int x){//字符串反转
        if(x<0)
            return false;
        int cur = 0;
        //int num = x;
        String str = String.valueOf(x);
        String strOver = new StringBuffer(str).reverse().toString();//字符串反转
        cur = Integer.parseInt(strOver);
        return cur == x;
        /*
        顺带记录一下字符串反转的一些方法:
        1、利用stringbuffer和stringbuilder的reverse成员方法
        2、先将字符串通过toCharArray 方法转换为char数组，然后通过遍历将每一个字符拼接到空字符串后面即可
        3、利用charat方法遍历取原字符串的每一位，然后拼接。
        * */
    }
}
