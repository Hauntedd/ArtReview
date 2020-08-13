package main.java.learning.mianjingTi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
字符串分段输出：
例：输入abc；输出：a,b,c,ab,ac,abc
* */
public class zstringFD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            combine(s);
        }
    }

    private static void combine(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        allCombine(chars,sb,0,list);
//        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void allCombine(char[] chars, StringBuilder sb, int start, List<String> list) {
        int len = chars.length;
        for (int i = start; i < len; i++) {
            sb.append(chars[i]);
            list.add(sb.toString());
            if(i<len){
                allCombine(chars,sb,i+1,list);
            }
//            sb.setLength(sb.length()-1);//执行完abcd后，回溯 -> abc -> ab重新执行 abd
            sb.deleteCharAt(sb.length() -1);//回溯
        }
    }
//    private static void allCombine(){}

}
