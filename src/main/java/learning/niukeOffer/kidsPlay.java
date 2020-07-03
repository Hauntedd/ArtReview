package main.java.learning.niukeOffer;
/*
孩子们的游戏，（圆圈中最火剩下的数）
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

如果没有小朋友，请返回-1
知识点写得是链表，但是我感觉数组也很简单
* */

public class kidsPlay {
    public int LastRemaining_Solution(int n, int m) {//n个小朋友，指定数为m一直不变，直到最后剩下一个小朋友

        if(n==0 || m==0){
            return -1;
        }
        int[] array = new int[n];
        int i = -1, step = 0, count = n;
        while (count >0){//这里之所以设为0，是把最后一个小朋友也找出来，它的编号就是i
            i++;
            if (i>=n) i=0;//形成一个环
            if (array[i] == 1)
                continue;//置为1表示这个小朋友已出列,则跳过不计数
            else
                step++;//计数+1
            if(step==m){
                array[i] = 1;//小朋友出列
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为1的元素（最后一个小朋友）
    }
}
