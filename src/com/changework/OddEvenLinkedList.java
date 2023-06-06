package com.changework;

//这道题给了我们一个链表，让我们分开奇偶节点，所有奇节点在前，偶节点在后。
//设定两个虚拟节点，dummyHead1 用来保存奇节点，dummyHead2 来保存偶节点；
//遍历整个原始链表，将奇节点放于dummyHead1 中，其余的放置在dummyHead2 中
//遍历结束后，将dummyHead2 插入到dummyHead1 后面
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head == null ){
            return head;
        }
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        int len = 1;
        ListNode p = new ListNode(0);
        p = head;
        ListNode temp1 = new ListNode(0);
        ListNode temp2 = new ListNode(0);
        temp1 = dummyHead1;
        temp2 = dummyHead2;
        while(p!=null){
            if(len%2 != 0){
                ListNode newp1 = new ListNode(p.val);
                temp1.next = newp1;
                temp1 = temp1.next;
            }
            if(len %2 == 0){
                ListNode newp2 = new ListNode(p.val);
                temp2.next = newp2;
                temp2 = temp2.next;
            }
            p = p.next;
            len++;
        }
        temp1.next = dummyHead2.next;
        return dummyHead1.next;


    }
    public static void main(String[] args) {

        // write your code here
        OddEvenLinkedList oddEvenLinkedList =  new OddEvenLinkedList();
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

        ListNode s = oddEvenLinkedList.oddEvenList(root);

    }
}
