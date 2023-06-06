package com.changework;


//设置三个节点pre、cur、next
//（1）每次查看cur节点是否为NULL，如果是，则结束循环，获得结果
//（2）如果cur节点不是为NULL，则先设置临时变量next为cur的下一个节点
//（3）让cur的下一个节点变成指向pre，而后pre移动cur，cur移动到next
//（4）重复（1）（2）（3）
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        pre = null;
        ListNode cur = new ListNode(0);
        ListNode next = new ListNode(0);
        cur = head;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre =  cur;
            cur = next;
        }
        return pre;
    }
    public static void main(String[] args) {

        // write your code here
        ReverseLinkedList reverseLinkedList =  new ReverseLinkedList();
        ListNode root = new ListNode(1);
        ListNode curr = new ListNode(2);
        root.next= curr;
        ListNode curr1 = new ListNode(6);
        curr.next = curr1;
        ListNode curr2 = new ListNode(3);
        curr1.next = curr2;
        ListNode curr3 = new ListNode(4);
        curr2.next = curr3;
        ListNode curr4 = new ListNode(5);
        curr3.next = curr4;
        ListNode curr5 = new ListNode(6);
        curr4.next = curr5;

        ListNode s = reverseLinkedList.reverseList(root);
        System.out.println(s);

    }
}
