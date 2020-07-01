package main.java.learning.niukeOffer;
/*
字符流中第一个不重复的字符
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出：如果当前字符流没有存在出现一次的字符，返回#字符。
知识点：char 在运算时会先转换成int,所以可以当成数组的标
* */
public class stringFirst {

    int count[]=new int[256];
    //Insert one char from stringstream
    int index=1;
    public void Insert(char ch) //读取字符流，每次一个。（应该是模拟方法，自己无法测试的）
    {
        if(count[ch]==0){//当前字符对应出现的次数，如果是第一次出现就标记为出现的位置（是字符流的第几个）
            count[ch]=index++;
        }
        else{//重复出现，直接置为-1，表示这个字符无了，不用再看了
            count[ch]=-1;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int temp=Integer.MAX_VALUE;//当前遍历到的符合要求的字符的位置，用来找第一个出现的
        char ch='#';
        for(int i=0;i<256;i++){//遍历字符流的标记数组，看有没有符合情况的
            if(count[i]!=0&&count[i]!=-1&&count[i]<temp){//满足条件，且先于当前值出现的位置
                temp=count[i];
                ch=(char)i;//转换回字符
            }
        }
        return ch;
    }
}
