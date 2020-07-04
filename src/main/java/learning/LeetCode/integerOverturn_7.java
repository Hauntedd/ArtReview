package main.java.learning.LeetCode;
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。123==>321
注意: 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
* */
public class integerOverturn_7 {
    public static void main(String[] args) {
        System.out.println(reverseInt(21234567));
//        int a = 2147483646 +100;
//        System.out.println(a);
    }
    public static int reverseInt(int x){
        int res = 0;
        int maxValue = Integer.MAX_VALUE/10,minValue = Integer.MIN_VALUE/10;//除以10是为了在进行最后一次反转之前判断是否有溢出的可能
        int maxLast = Integer.MAX_VALUE%10,minLast = Integer.MIN_VALUE%10;
        while (x !=0){
            //每次取末尾数字
            int temp = x%10;
            //判断是否 大于 最大32位整数
            if (res>maxValue || (res==maxValue && temp>maxLast)) {//这个判断主要用于最后一位反转之前，判断已经转换的n-1位是否大于最大值的n-1位，若等于则判断最后一位数字是否大于上限
                return 0;
            }
            //判断是否小于最小的32位整数
            if(res<minValue || (res==minValue && temp<minLast)){//同上
                return 0;
            }
            res = res *10 +temp;
            x /= 10;

        }
        return res;
    }
}
