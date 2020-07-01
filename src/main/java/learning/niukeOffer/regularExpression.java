package main.java.learning.niukeOffer;

import java.util.Scanner;

/*
正则表达式匹配
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
知识点：字符串处理，回溯等;
难点：需要考虑完全
* */
public class regularExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
//            String str,pattern;
            char[] str = sc.nextLine().toCharArray();
            char[] pattern  = sc.nextLine().toCharArray();
            boolean bool = match(str,pattern);
            System.out.println(bool);

        }
    }

    public static boolean match(char[] str, char[] pattern)
    {
        return matchTwo(str,0,str.length,pattern,0,pattern.length); //字符串，起始点，长度

    }
    private static boolean matchTwo(char[] str, int i, int length1, char[] pattern,
                             int j, int length2) {
        if(i==length1&&j==length2) {//1.字符串和匹配模式都为空，直接返回true
            return true;
        }

        if(i==length1&&j!=length2) {//2.字符串为空，但是匹配模式不为空
            while(j!=length2){//匹配模式不为空，但是值不存在*，遍历匹配
                if(pattern[j]!='*'&&(j+1>=length2||pattern[j+1]!='*')){
                    return false;
                }
                j++;
            }
            return true;//匹配到最后一位是*，则返回正确
        }

        if(i!=length1&&j==length2) {//3.字符串不为空，但是匹配模式为空，直接false
            return false;
        }
        if(j+1==length2){//4.均不为空，直接匹配以及匹配"."(模板长度为1的情况，下一次直接就是情况1,2,3)
            if(str[i]==pattern[j]||pattern[j]=='.')//单个匹配成功或者匹配"."成功
                return matchTwo(str, i+1, length1, pattern, j+1, length2);//向后继续匹配
            else {
                return false;
            }
        }
        //下面是不为空，且模板长度不是1
        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]!='*')//5.对应位相等，并且模板下一位不是*，是*的话需要多位匹配
            return matchTwo(str, i+1, length1, pattern, j+1, length2);

        if((str[i]==pattern[j]||pattern[j]=='.')&&pattern[j+1]=='*')//6.对应位相等，并且模板下一位就是*，开始进行多位匹配，字符串后移或模板跳位
            return matchTwo(str, i, length1, pattern, j+2, length2)||matchTwo(str, i+1, length1, pattern, j, length2);

        if(pattern[j+1]=='*')//7.对应位不等，但是模板下一位是*，模板跳位匹配
            return matchTwo(str, i, length1, pattern, j+2, length2);
        return false;//8.对应位不等，下一位也不是*，返回false
    }
}
