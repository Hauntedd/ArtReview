package main.java.learning.mianjingTi;

import java.util.Scanner;

/*
x*y*z的立方体，切割k刀，最多切多少块？
切法：以平行于立方体某个面的平面切割，只能在坐标轴为整数的地方切，比如x=0.5就不合法
输入 2 2 3 3
输出 8
* */
public class lifangtiQiege {//想法: 三个面轮番增加切割次数，直至次数用完。最终结果是(三方切割刀数+1)相乘,最终结果可以记一下

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt(),y= sc.nextInt(),z= sc.nextInt(),k= sc.nextInt();
            int idx=0,idy=0,idz=0;
            long sum = 0;
            while (k>0){
                if(idx <x-1&&k>0){
                    idx++;
                    k--;
                }
                if(idy<y-1&&k>0){
                    idy++;
                    k--;
                }
                if(idz<z-1&&k>0){
                    idz++;
                    k--;
                }
            }
            sum = (idx+1)*(idy+1)*(idz+1);
            System.out.println(sum);
        }
    }
}
