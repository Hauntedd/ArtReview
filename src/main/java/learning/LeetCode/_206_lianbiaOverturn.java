package main.java.learning.LeetCode;
/*
反转链表
这里使用迭代，因为递归已经用过了(工程最外面的解题)
* */
public class _206_lianbiaOverturn {

    public ListNode reverseList(ListNode head) {
        if(head ==null || head.next ==null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur!= null){//注意点：第一轮循环一定要记得null在最左边
            ListNode nexTemp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nexTemp;
        }
        return prev;
    }
}
