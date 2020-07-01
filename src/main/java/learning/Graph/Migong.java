package main.java.learning.Graph;

import java.util.Scanner;

public class Migong {//因为static的原因只能跑一次，很烦
    static int start_x,start_y,end_x,end_y;//起始点坐标信息
    static int[][] map=new int[101][101];//默认是0,存迷宫信息
    static int sum=0;//通路的数量

    public static void main(String[] args) {

        int n,m,t;
        int i,j;
        int x,y;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();m = sc.nextInt();t = sc.nextInt();//行、列、障碍数
            start_x=sc.nextInt();start_y = sc.nextInt();end_x =sc.nextInt();end_y =sc.nextInt();//起始点坐标
            //迷宫初始化
            for (int k = 1; k < n+1; k++) {//保留边界，防止搜索时溢出（同时还可以直接坐标对应索引值，美滋滋）
                for (int l = 1; l <m+1 ; l++) {
                    map[k][l]=1;
                }
            }
            for (int k = 0; k < t; k++) {//设置障碍物
                x = sc.nextInt();y = sc.nextInt();//障碍物坐标
                map[x][y] = 0;
            }
            dfs(start_x,start_y);//开始探索
            System.out.println(sum);//输出结果
        }
    }

    /**
     * 参数是起点坐标
     * @param x
     * @param y
     */
    private static void dfs(int x, int y){
        if(x==end_x && y==end_y){
            sum++;
            return;
        }else{//回溯
            map[x][y] = 0;//标记当前坐标，不能走第二次（理论上只有起点会设置成0然后一直是0）

            if(map[x][y-1]!=0){//向左
                dfs(x,y-1);//向左搜索(前进)
                map[x][y-1] = 1;//完成搜索回溯至当前点，不耽误后续的探索，所以重新置为1
            }
            if(map[x][y+1]!=0){//向右
                dfs(x,y+1);//向右搜索(前进)
                map[x][y+1] = 1;
            }
            if(map[x-1][y]!=0){//向上
                dfs(x-1,y);//向上搜索(前进)
                map[x-1][y] = 1;
            }
            if(map[x+1][y]!=0){//向下
                dfs(x+1,y);//向下搜索(前进)
                map[x+1][y] = 1;
            }
        }

      }
}
