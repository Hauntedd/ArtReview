package main.java.learning;

public class stringOverturn {
    //1.直接使用reverse方法
    public static void re1(String str){
        StringBuilder sb1 = new StringBuilder(str);
        System.out.println(sb1.reverse()); //uoy olleH

        StringBuffer sb2 = new StringBuffer(str);
        System.out.println(sb2.reverse()); //og ahah
    }

    //2.将字符串转换成字符数组，然后从末尾开始，拼接字符串
    public static void re2(String str){
        char[] charStr = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = charStr.length - 1; i >= 0; i--) {
            sb.append(charStr[i]);
        }
        System.out.println(sb.toString());
    }

    //对于整数，一种是可以转换成字符串，另外也可以通过取余和除直接倒置
    public static void re3(int num){
        int test =  789;
        String str = String.valueOf(test);
        re2(str);

        int res = 0;
        while(num > 0){
            res = res * 10 + num % 10;
            num /= 10;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        re3(123);
    }


}
