package main.java.learning.LeetCode;
/*
请你来实现一个 atoi 函数，使其能将字符串转换成整数。
如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0 。不超过32位
* */
public class atoi_8 {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();//首先将字符串转换为char数组
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {//开始处理数据，第一步处理空格
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;//负号标识
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {//这里使用了一个API判断字符是否是一个数字
            // 其他符号
            return 0;
        }//处理完之后可以开始考虑数字了
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {//判断为数字，且没有溢出数组
            int digit = chars[idx] - '0';//用ascii编号来求数字
            if (ans > (Integer.MAX_VALUE - digit) / 10 ||((ans == Integer.MAX_VALUE / 10) &&digit>Integer.MAX_VALUE % 10)) {//int越界的处理，补上或才严谨
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE(和7题有些许相似)
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。(可以个锤子，想当然了)
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }

}
