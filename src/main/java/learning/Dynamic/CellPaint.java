package main.java.learning.Dynamic;

import java.util.Scanner;

/*
参考：https://blog.csdn.net/qq_22891105/article/details/51050565
必须看明白的点：
    1、a[i]数组表示从最边缘的四个格子中某个出发，遍历完长度为i，个数为2i个格子的所有种类数；由假设可知：a[1]=1,a[2]=6,a[i]=2*a[i-1]+b[i]+4*a[i-2]
    2、b[i]数组表示从除了最边缘的四个格子外的某个中间的格子出发，遍历完一边回到所对的格子；b[i] = 2*b[i-1],有递归的感觉，很好理解，从左往右全部算出来就可以了
城墙形式为2*N(高*长) ，只需要输入N即可。
从任意一个格子刷起，刷完一格，可以移动到和它相邻的格子,不能跳，也不能重复
当已知  N  时，求总的方案数。当N较大时，结果会迅速增大，请把结果对  1000000007  (十亿零七)  取模。
输入正整数：《=1000, 输出正整数
难点：第三种情况容易漏掉
* */
public class CellPaint {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            long[] a = new long[N+1];
            long[] b = new long[N+1];
            long sum = 0;
            b[1] = 1; //直走
            for (int i = 2; i <= N ; i++) {
                b[i] = 2*b[i-1]%1000000007;
            }
            a[1] = 1;a[2] = 6;//a[1]直走，a[2] = 3*2
            for (int i = 3; i <=N ; i++) {
                a[i] = (2*a[i-1]+b[i]+4*a[i-2])%1000000007;// 暂时的理解：第三种和第二种的差别就在于不需要再回到出发点，和第一种的差别是建立一个新的顶角(奥利给)
//                a[i] = (2*a[i-1]+b[i])%1000000007;  //只考虑两种情况不对，必须考虑第三种才行
            }
            sum = (4*a[N])%1000000007;  //四个顶角出发的路径数
            for(int i = 2; i < N; i++){
                sum += ((8*b[i-1]*a[N-i])%1000000007+(8*b[N-i]*a[i-1])%1000000007)%1000000007;//必须每个项都取余，防止有大于这个数的情况
                sum %= 1000000007;
            }
            System.out.println(sum);
        }
    }
}
