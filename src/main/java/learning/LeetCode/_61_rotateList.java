package main.java.learning.LeetCode;

/*
旋转链表(其实就是左移）
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
官方题解是先把链表成环，然后循环切断，比我的简单一些
* */
//    class ListNode {//21里面已经实现了链表节点了
//      int val;
//      ListNode next;
//      ListNode(int x) { val = x; }
//    }
public class _61_rotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null||head.next == null) return head;

        int length = 1;
        int finalK = 0;
        ListNode tempNode = head;
        ListNode newHaed =head;
        while ((tempNode=tempNode.next) !=null)
            length++;//获取链表的长度
        if(k>=length)
            finalK = length - k%length;//套圈的直接去掉,从前往后数
        else
            finalK = length - k;
        if(finalK ==0)
            return newHaed;//刚好一整圈，直接返回
        for (int i = 0; i < finalK; i++) {
            if(i ==(finalK -1) ){
                newHaed = tempNode.next;//找到新的头
                tempNode.next = null;//从中间切断(新的头之前)
            }
            else
                tempNode = tempNode.next;//遍历找到切断点
        }
        tempNode = newHaed;
        for (int i = 0; i < length - finalK; i++) {//遍历切下来的链表，找到尾巴
            if(i ==(length - finalK -1) ){
                tempNode.next = head;//找到尾，连接到原头
            }
            else
                tempNode = tempNode.next;//遍历找到切断点
        }
        return newHaed;
    }
}
