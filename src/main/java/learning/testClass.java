package main.java.learning;

import sun.security.util.Length;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

//注意一个事儿啊，输入形式尤其是最终到0结束那种，不需要按照给的输入样例一样一次性读入，一行一行读然后输出就可以了
public class testClass {
    public static int main(){return 1;}
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

//        String str = "abcd";
//        System.out.println(str +"efg");
//        ConcurrentMap<String,Integer> testMap = new ConcurrentHashMap<>();
        //hashMap更好的线程安全版本，分16桶，需要锁的时候只锁一个桶就行，size操作的时候才锁定整个hash表
        //但是1.8及以后放弃了分段锁：1.加入多个分段锁浪费内存空间。
        //2.生产环境中， map 在放入时竞争同一个锁的概率非常小，分段锁反而会造成更新等操作的长时间等待。
        //3.为了提高 GC 的效率
//        String test = "hello";
//        for (int i = 0; i < 100000000; i++) {//模拟一下内存溢出outofmemory(扩展栈),stackoverflow(一直递归调用(加深栈)就可以实现）
//            test +=test;
//        }
//        System.out.println(test);
        
        char testA = '淦';//char对应unicode编码，所以可以存储unicode编码中包含的汉字字符
        System.out.println(testA);
        new testClass().testMethod();//静态方法中待用非静态方法

        FlyPig f1 = new FlyPig();
        FlyPig f2 = new FlyPig();
        FlyPig f3 = new FlyPig();
        FlyPig f4 = new FlyPig();
        System.out.println(f1.equals(f2));//没有重写的equals和==是一样的，比较引用的地址(并非指向的对象hashcode)；例如String类，就比较的是对象的内容
        System.out.println(f1.getTest());
        System.out.println(f2.getTest());
        System.out.println(f3.getTest());
        System.out.println(f4.getTest());

        System.out.println("===================================");
        String a = new String("abcdefg");
        String b = "abc" + "defg";
        System.out.println(a.hashCode()+";"+b.hashCode());
        System.out.println(a==b);
        System.out.println(a.equals(b));
        short s1 = 1;
        s1 += 1;
        System.out.println(s1);

        System.out.println("===================================");
        List<Integer> list = new ArrayList<>();list.add(1);list.add(2);list.add(3);list.add(2);
        int[] test = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            test[i] = list.get(i);
        }
        for (int i : test) {
            System.out.println(i);
        }
        System.out.println("===================================");
        List<Integer> ttest = new LinkedList<>();

        List<String> temp1 = new ArrayList<>();
        List<? extends String> temp2 = new ArrayList<>();
        List<Object> temp3 = new ArrayList<>();
        System.out.println(temp1.getClass() == temp2.getClass());
        System.out.println(temp1.getClass() == temp3.getClass());//编译以后不带泛型信息，泛型擦除
        System.out.println(temp1.getClass());
        System.out.println("===================================");
        Integer test1 = 1;
        Integer test2 = 1;
        Integer test3 = 300;//自动装箱会优先寻找缓存（-128~127）,没找到就新建对象
        Integer test4 = 300;
        System.out.println(test1 == test2);//使用缓存所以是同一个对象所以true
        System.out.println(test3 == test4);//新建对象所以false
        System.out.println(test3.equals(test4));

        System.out.println(main());
        Integer sInt = 100;
        WeakReference<Integer> weakInt = new WeakReference<Integer>(sInt);

        System.out.println("===================================");
        findDX("G9E6Z3F1A1B2CD4");
        deleteMulti("AAAAAABBCC");

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
    void testMethod(){}

    /**
     * 泛型方法
     */
    public <K,V> V put(K key, V value){//泛型的基本使用
        return value;
    }

    public static void findDX(String str){//先转型为数组，然后使用数组的排序，在循环遍历即可
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if(c >='A'&& c<= 'Z'){
                sb.append(c);
            }
        }
//        String result = sortString(sb.toString());
        System.out.println(sb.toString().length() + ":" +sb.toString());
    }

    public static void deleteMulti(String string){//字符串去重
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(!list.contains(string.charAt(i))){
                list.add(string.charAt(i));
                sb.append(string.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static ListNode removeNodeAtN(ListNode node,int n){//也可以使用双指针。先让两个指针有n的间隔，然后用间隔来寻找需要删除的节点（只需一次遍历）
        //首先遍历第一次,获取链表的长度
        ListNode head = node;
        ListNode pre=null,temp=null;
        int count = 0;
        while (node!=null){
            node = node.next;
            count++;
        }
        if(count < n)
            return node;//链表长度小于n直接返回，或者n%count也可以
        count -= n;//正数第n-1个
        for (int i = 0; i <=count ; i++) {//第二次遍历，删除指定节点
            if(i==0){
                temp = head;
            }
            else{
                pre = temp;
                temp = temp.next;
            }
        }
        pre = temp.next;
        temp.next = null;
        if(count ==0)
            return pre;//新的头节点
        else
            return head;
    }
}
