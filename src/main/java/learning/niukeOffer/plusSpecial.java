package main.java.learning.niukeOffer;

import java.util.Scanner;

/*
不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
知识点：二进制与或非计算基础.(灵感来源于十进制计算的基础步骤)
* */
public class plusSpecial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            while (num2 !=0){
                int temp = num1^num2;//异或，作用为不进位的相加。第一步:计算不进位的相加010（以5+7为例）
                num2 = (num1&num2)<<1;//第二步：计算进位值，101&111=101，再向左移一位得到1010 注：左移相当于乘2，右移除2
                num1 = temp;//第三步，交换值，相当于每一步都计算当前的最低位相加，值给到num1，循环下去即可得到一个完整的数
            }
            System.out.println(num1);
        }
    }
}
