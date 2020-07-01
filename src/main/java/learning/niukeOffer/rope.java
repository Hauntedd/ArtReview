package main.java.learning.niukeOffer;

import java.util.Scanner;
/*
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[1],...,k[m]。
请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
知识点：贪心算法.分析可得必然会拆分成2\3，且同等情况下3应该优先于2(贪心)

* */
public class rope {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(curRope(n));
        }
    }

    public static long curRope(int n){
        if(n == 2) return 1; //题目设置n>1,m>1,所以必然有2=1*1,3=1*2
        if(n == 3) return 2;
        long x = n % 3; //优先考虑3
        double y = Math.floor((double) n/3); //有多少个3,必须用double,且向下取整小数点后面取0 注：其实在代码中也可以不写类型转换，java会自动装箱
        if(x==0){//能整除，直接带走
            return (long)Math.pow(3,y);
        }else if(x==1){//此情况下必然存在一个4=2*2>3*1，所以此处考虑拆分为2*2
            return 2*2*(long)Math.pow(3,(y-1));
        }else{//x==2，
            return 2*(long)Math.pow(3,y);
        }
    }
}
