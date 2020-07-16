package main.java.learning;


class ListNode {//链表节点
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class lianbiaOverTurn {

    public ListNode reverseList(ListNode head){//这是递归，循环也可以
        if(head ==null || head.next == null)
            return head;
        ListNode temp = head.next;//临时存储下一个节点
        ListNode newHead = reverseList(head.next);//这个递归返回值只用来获取原链表的尾巴
        temp.next = head;
        head.next = null;
        return newHead;
    }
}
