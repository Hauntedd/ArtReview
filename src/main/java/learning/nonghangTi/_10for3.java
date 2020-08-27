package main.java.learning.nonghangTi;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

/*
编写程序计算10个正整数的平均值，找出这10个数中与平均值距离（差值的绝对值）最近的三个数，以距离大小对这三个数排序和输出（与平均值距离小的先输出）。
例如输入{33，44，61，2，36，42，56，81，11，17}，输出36，42，33这三个数字。
* */
public class _10for3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] temp = new int[10];
            Vector<Integer> vector = new Vector<>();
            int[] out = new int[3];
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                temp[i] = sc.nextInt();
                sum += temp[i];
            }
            int avg = sum/10;
            for (int i = 0; i < 10; i++) {
                vector.add(Math.abs(temp[i] - avg));
                //flag[i] = ;//求出平均值距离
            }
            Collections.sort(vector);//从小到大排序
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 10; j++) {
                    if(vector.elementAt(i) ==Math.abs(temp[j] - avg) ){
                        System.out.print(temp[j] +" ");
                        break;
                    }
                }

            }
        }
    }
}
