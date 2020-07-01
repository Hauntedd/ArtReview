package main.java.learning;

import java.util.Scanner;
/*
    第一行是一个正整数N，最大为100。之后是多行字符串（行数大于N）， 每一行字符串可能含有空格，字符数不超过1000。
    先将输入中的前N行字符串（可能含有空格）原样输出，再将余下的字符串（不含有空格）以空格或回车分割依次按行输出。每行输出之间输出一个空行。
* */
public class stringInOut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int n = Integer.parseInt(scanner.nextLine());//先把第一行的数据读进来，注意要把当前行的换行符也读进去，不然会影响下一行的读取
//        String empty = scanner.nextLine();//读取回车
        int i = 0;//读取前N行时用于循环
        int j = 0;//>N行时的读取
        int k = n;
        String[] str = new String[1000];
        while (scanner.hasNext()){

            for (; i < n; i++) {//讲道理只会循环一次
                str[i] = scanner.nextLine();//按行读入
            }
            str[k++] = scanner.next();

            for (; j < k; j++) {
                System.out.println(str[j] + "\n");
            }
        }
    }
}
