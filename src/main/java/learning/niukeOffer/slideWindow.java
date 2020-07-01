package main.java.learning.niukeOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
滑动窗口的最大值
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
* */
public class slideWindow {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String nums = sc.nextLine();//读取数组并转换成int类型(符合题设)
            String[] numS = nums.split(" ");
            int[] num = new int[numS.length];
            for (int i = 0; i < numS.length; i++) {
                num[i] = Integer.parseInt(numS[i]);
            }
            int size = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> maxOfWindow = maxInWindows(num, size);
            System.out.println(maxOfWindow);
        }
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num==null||size<0){
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        if(size==0){
            return list;
        }
        ArrayList<Integer> temp=new ArrayList<Integer>();//备份模板
        int length = num.length;//数组的长度
        if(length<size){//数组长度小于窗口，返回空list
            return list;
        }else{//正常情况
            for(int i=0;i<length-size+1;i++){//length-size+1是窗口可以滑动的次数
                temp.clear();//使用之前先清空集合
                for(int j=i;j<size+i;j++){//这个就是获取窗口长度的值，然后添加到temp里面去
                    temp.add(num[j]);
                }
                Collections.sort(temp);//升序排序
                list.add(temp.get(size - 1));//取出最后一位，也就是最大值
            }
        }
        return list;

    }
}
