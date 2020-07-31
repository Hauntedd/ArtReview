package main.java.learning.niukeOffer;

import java.util.ArrayList;
import java.util.List;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
* */
public class _06_dayinLBReverse {
    class ListNode {//链表节点
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    List<Integer> temp = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[temp.size()];
        for(int i = 0; i < res.length; i++)//list转数组
            res[i] = temp.get(i);
        return res;
    }
    void recur(ListNode head){//递归
        if(head == null) return;
        recur(head.next);
        temp.add(head.val);
    }
}
