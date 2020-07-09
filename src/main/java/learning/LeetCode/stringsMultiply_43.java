package main.java.learning.LeetCode;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

/*
字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
说明：不能直接转换成整数来处理
* */
public class stringsMultiply_43 {

//    public static void main(String[] args){
//        System.out.println('9'-'0');
//        StringBuffer buffer = new StringBuffer();
//        System.out.println(buffer.append(10).toString());
//    }
    public String multiply(String num1, String num2) {
        if("0".equals(num1)||"0".equals(num2)) return "0";
        int len1 = num1.length();
        int len2 = num2.length();

        //字符串转换为数组，方便操作
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();

        //创建临时结果数组
        int len = len1 + len2 ;//最长的形式
        int[] temp = new int[len];

        //计算：
        for (int i = len1 -1; i >= 0 ; i--) {
            for (int j = len2 -1; j >= 0 ; j--) {
                temp[i+j+1] +=((cs1[i] - '0') * (cs2[j] - '0'));//经典对位乘法;i+j+1的操作很有意思，对位乘法发挥的很好
            }
        }
        //整理结果,从结果低位（数组高位）开始整理，保证每个数都 < 10
        for (int i = len - 1; i > 0; i--) {
            if (temp[i] > 9) {
                int add = temp[i] / 10;//需要进位多少
                temp[i - 1] += add;//进位
                temp[i] = temp[i] % 10;//只留下没进位的值
            }
        }
        //结果生成字符串
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if(i == 0 && temp[i] == 0) continue;//如果首位是0就不添加了
            buffer.append(temp[i]);
        }
        return buffer.toString();

    }
}
