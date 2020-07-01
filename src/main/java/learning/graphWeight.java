package main.java.learning;

import java.util.Scanner;

public class graphWeight {

    static boolean aboolean;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int weight;
            for (int i = 0; i < m; i++) {
                weight = sc.nextInt();
                aboolean = false;//判断
                judge(arr,weight,0,0);
                if(aboolean){
                    if(i!=m-1){//不是最后一个
                        System.out.println("YES");
                        continue;
                    }
                    System.out.println("YES");
                }else{
                    if(i!=m-1){
                        System.out.println("NO");
                        continue;
                    }
                    System.out.println("NO");
                }
            }
        }
    }

    //递归(回溯？)
    private static void judge(int[] arr, int weight,int cw,int cn){
        if(cw == weight){
            aboolean = true;
            return;
        }
        if(cn == arr.length){//砝码用完也称不出来
//            aboolean = false;
            return;
        }
        //递归保证所有的砝码组合都能得到
        judge(arr,weight,cw +arr[cn],cn+1);//向物体的另一边托盘放置砝码
        judge(arr,weight,cw,cn+1);//跳过当前砝码
        judge(arr,weight,cw-arr[cn],cn+1);//向物体这边的托盘放置砝码
    }
}
