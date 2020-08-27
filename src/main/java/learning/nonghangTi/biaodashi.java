package main.java.learning.nonghangTi;

import java.util.ArrayList;
import java.util.List;

/*
计算表达式的值并输出，表达式由若干个数字和运算符（只包含加号和减号）构成,参数是字符串类型的"3+5="
* */
public class biaodashi {
    public static void main(String[] args) {
        test("102+999=");
    }
    public static void test(String str){
        String[] temp = str.split("\\+|-|=");//split用法，根据多个标签断开
        char[] flag = new char[str.length()/2];int j=0;
        int sum =0;int ZF =1;
        for (int i = 0; i < str.length(); i++) {//把符号找出来先
            char aaa = str.charAt(i);
            if(aaa =='+'||aaa=='-'||aaa=='='){
                flag[j++] = aaa;
            }
        }
        int k=0;j=0;
        while(k<temp.length){
            sum += Integer.parseInt(temp[k++]) * ZF;
            if(flag[j]=='+'){
                ZF = 1;
                j++;
            }else if(flag[j]=='-'){
                ZF = -1;
                j++;
            }else{
                break;
            }
        }
        System.out.println(sum);
//        int[] test = new int[temp.length/2];
//        int sum = 0;int flag = 1;

    }

}
