package main.java.learning;

import java.util.Scanner;
/*
    差分数组法思想：
    N个小朋友，建立[N+2]的数组记录差分信息，[0],[N+1]作用分别是差分起始点和终点(方便写代码)
   每次读入一个老师的Li、Ri、Ci，[Li] = [Li]+1比前面的小朋友多ci个，[Ri] = [Ri] -ci比前面的小朋友少ci个,中间都是一样的不需要操作
   输出的时候从通过[0]从[1]计算到[N]即可
* */
public class disApple {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int N,M;
            N = scanner.nextInt();
            M = scanner.nextInt();
            int[] num = new int[N + 2];//第一个和最后一个都是用来计数的

            for (int i = 0; i < M; i++) {
                int li = scanner.nextInt();
                int ri = scanner.nextInt();
                int ci = scanner.nextInt();
                num[li] += ci;//比前面一个小朋友多ci个
                num[ri + 1] -= ci;//比前面一个小朋友少ci个,N+2就是为了让这里不出错
            }//这样出来的话，num[0] = 0,形成差分
            for (int i = 1; i < N+1; i++) {
                //实际结果
                num[i] += num[i - 1];
                System.out.printf(num[i]+ " ");
            }
        }
    }
}
