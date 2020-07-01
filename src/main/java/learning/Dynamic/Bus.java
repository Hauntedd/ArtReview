package main.java.learning.Dynamic;

import java.util.Scanner;

/**
 *题目描述一个特别的单行街道在每公里处有一个汽车站。顾客根据他们乘坐汽车的公里使来付费。例如下表就是一个费用的单子。编号：1282
 *          没有一辆车子行驶超过10公里，一个顾客打算行驶n公里（1< =n< =100），它可以通过无限次的换车来完成旅程。最后要求费用最少
 *  输入：第一行十个整数分别表示行走1到10公里的费用（< =500）。注意这些数并无实际的经济意义，即行驶10公里费用可能比行驶一公里少。
 *          第二行一个整数n表示，旅客的总路程数。
 *  输出：仅一个整数表示最少费用
 *  分析：背包问题，填表法
 */
public class Bus {
    public static void main(String[] args){
//        sample();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int[] m_d = new int[11];//为了和后面对应起来，所以索引0位置不填充数据
            for (int i = 1; i < 11; i++) {
                m_d[i] = scanner.nextInt();
            }
            int N = scanner.nextInt();
            int[][] pg = new int[10+1][N+1];
            for (int i = 0; i < pg.length; i++) {
                pg[i][0] = 0;
            }
            for (int i = 0; i < pg[0].length; i++) {
                pg[0][i] = 0;
                pg[1][i] = i * m_d[1];//全走一公里的
            }
            for (int i = 2; i < pg.length; i++) {//开始换行，也就是开始更新可选择的里程数
                for (int j = 1; j < pg[0].length; j++) {
                    if(i <= j){//正常情况应该是i<=j，但是由于这里没有给i=0绘制0边框，所以这样子
                        pg[i][j] = Math.min(pg[i][j-i] + m_d[i], pg[i-1][j]); //选择 1.退回距离i然后加上i的费用；2.跟上一层相同的选择；其中的费用少的一个
                    }else{
                        pg[i][j] = pg[i-1][j];//继承对应的
                    }
                }
            }
            System.out.println(pg[10][N]);
        }
    }

    public static void sample(){
        Scanner scan = new Scanner(System.in);
        int [] m_v = new int[10];
        for (int i = 0; i < m_v.length; i++) {
            m_v[i] = scan.nextInt();
        }
        int N = scan.nextInt();
        scan.close();
        int[][] pg = new int [10][N+1];
        for (int i = 0; i < pg[0].length; i++) {
            pg[0][i] = i*m_v[0];
        }
        for (int i = 1; i < pg.length; i++) {
            for (int j = 0; j < pg[i].length; j++) {
                if(i+1<=j) {
                    pg[i][j] =Math.min(pg[i][j-i-1] + m_v[i], pg[i-1][j]);
                }else {
                    pg[i][j] = pg[i-1][j];
                }
            }
        }
        System.out.println(pg[9][N]);
        for (int i = 0; i < pg.length; i++) {
            for (int j = 0; j < pg[0].length; j++) {
                System.out.printf("%d" + " ",pg[i][j]);
            }
            System.out.printf("\n");
        }

    }
}
