package main.java.learning.mianjingTi;
/*
整数的二进制形式数反转
给定一个无符号32位整数，要求将其2进制形式数反转(即首尾颠倒，非按位取反)，输出反转后的整数。
* */
public class erjinzhiFANZHUAN {
    public static int reverseBits(int n){
        int y=0;
        //int digit = 0;
        for (int i = 0; i < 32; i++) {//32位
            y = y <<1;//先把Y左移一位，预留出位置
            y = y|(n & 1);//先和1与保留最后一位，然后把最后一位通过或操作赋值为Y;
            n = n>>1;//最低位复制完成，高位顺延下来
        }
        return y;

    }

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }
}
