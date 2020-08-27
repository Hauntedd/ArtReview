package main.java.learning.nonghangTi;

import java.util.Scanner;
import java.util.regex.Pattern;

/*

* */
public class sanjinzhiQH {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            while (true){
                String str = sc.nextLine();
                System.out.println(isNumeric(str));
            }
//            int num1 = sc.nextInt();
//            int num2 = sc.nextInt();
//            {//Integer提供的方法
//                num1 = Integer.parseInt(String.valueOf(num1), 3);
//                num2 = Integer.parseInt(String.valueOf(num2), 3);//这里是三进制转十进制
//                int num3 = num1 + num2;
//                System.out.println(Integer.toString(num3, 3));
//            }
        }
    }

    //判断是否为数字的正则表达式,只能整数
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");//？表示非贪心的匹配，\\表示匹配后面跟着的字符，*多次匹配；^*为开始和结束符
        return pattern.matcher(str).matches();
    }


    public static String convertToBase7(int num) {//手动进制转换
        String ans = "";
        if (num < 0) {
            num = 0 - num;
            ans += "-";
        };
        StringBuilder sb = new StringBuilder();
        do {
            int mod = num % 7;
            sb.append((char)('0'+mod));
            num = num / 7;
        } while (num > 0);
        ans += sb.reverse().toString();
        return ans;

    }
}
