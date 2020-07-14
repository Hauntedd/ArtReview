package main.java.learning;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

//注意一个事儿啊，输入形式尤其是最终到0结束那种，不需要按照给的输入样例一样一次性读入，一行一行读然后输出就可以了
public class testClass {
    public static void main(String[] args) {

//        sortTest();
//        absSort();
//        absValue();
//        maxInput();
//        System.out.println("8".compareTo("15"));

//        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");//java8新特性，流stream（不是IO流）
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());//collect规约操作，主要用于类型转换
//        System.out.println(filtered);
//        String test = "abcd";
//        int a;
////        System.out.println(a=5);//输出：5
        String str = "abcd";
        System.out.println(str +"efg");
    }

    public static void sortTest(){
        Scanner scanner =new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());//这里仅读取一次字符串个数，后续不再改变
        String[] a = new String[n];
        while(scanner.hasNext()){
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLine();
            }
            Arrays.parallelSort(a);
            for (int i = 0; i < n; i++) {
                System.out.println(a[i]);
            }
        }
    }

    public static void absSort(){//输入的绝对值排序，最终输入以0为结尾

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();//读取n
            if(n == 0)
                return;
            int[] a = new int[n];//原数组
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            F(a);
            for (int i = 0; i < n; i++) {
                if(i == n-1)
                    System.out.printf("%d\n",a[i]);
                else
                    System.out.printf("%d"+" ",a[i]);
            }
        }
    }

    public static void absValue(){//输入的绝对值
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String result = String.format("%.2f",Math.abs(sc.nextDouble()));//将任意对象格式化为字符串类型，第一个参数为格式
            System.out.println(result);
        }
    }

    public static void maxInput(){
        //提交的时候报编译错误，应该是没有导包，也不知道题目提交能不能导包，如果可以以后直接import java.util.*;不能的话这里就改用nextline,然后split,也可以实现
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()){
            int n = sc.nextInt();//读取n
            if(n != 0)
                list.add(n);
            else{
                int max = 0;
                for (int i = 0; i < list.size(); i++) {
                    if(max<list.get(i))
                        max = list.get(i);
                }
                System.out.println(max);
                list.clear();
            }
        }
    }

    /***
     *冒泡排序
     * @param a
     */
    private static void F(int[] a){
        int len = a.length;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {//每次循环把最小的数冒泡到最后,最后的位置每一个小循环减1
                if(Math.abs(a[j]) < Math.abs(a[j+1])){//前小于后,交换位置
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
