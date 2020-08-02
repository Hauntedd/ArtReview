package main.java.learning.LeetCode;

import java.util.TreeMap;

/*
日程安排表
详见：https://leetcode-cn.com/problems/my-calendar-iii/
* */
public class _732_MyCalendar {
    TreeMap<Integer,Integer> delta;// Key 有序,不能为null

    public _732_MyCalendar(){
        delta = new TreeMap<>();
    }

    public int book (int start, int end){
        delta.put(start, delta.getOrDefault(start, 0) + 1);//getOrDefault这个方法的含义是：查询其中是否有这个key对应的值，有就用没有就使用设置的默认值
        delta.put(end, delta.getOrDefault(end, 0) - 1);//左闭右开是通过这里正负抵消实现的(理论上左闭右闭更难实现)

        int active = 0, ans = 0;
        for (int d: delta.values()) {//返回值是最大预定次数，也就是最大的有时间交集的预定次数(这里的写法运用了类似括号匹配的方法)
            active += d;
            if (active > ans)
                ans = active;
        }
        return ans;
    }
}
