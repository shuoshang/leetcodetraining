package com.changework;

//定义一个虚拟头节点dummyHead ，遍历查看原链表，遇到与给定值相同的元素，
// 将该元素的前后两个节点连接起来，然后删除该元素即可
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        if(head == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode dummyHead1 = new ListNode(0);
        dummyHead1 = dummyHead;
        dummyHead.next =  head;
        while(dummyHead.next !=null ){
            int t = dummyHead.next.val;
            if(t == val){
                dummyHead.next = dummyHead.next.next;
            }else{
                dummyHead = dummyHead.next;
            };
        }
        return dummyHead1.next;
    }

    public static void main(String[] args) {

        // write your code here
        RemoveLinkedListElements removeLinkedListElements =  new RemoveLinkedListElements();
        ListNode root = new ListNode(1);
        ListNode curr = new ListNode(1);
        root.next= curr;
//        ListNode curr1 = new ListNode(6);
//        curr.next = curr1;
//        ListNode curr2 = new ListNode(3);
//        curr1.next = curr2;
//        ListNode curr3 = new ListNode(4);
//        curr2.next = curr3;
//        ListNode curr4 = new ListNode(5);
//        curr3.next = curr4;
//        ListNode curr5 = new ListNode(6);
//        curr4.next = curr5;

       ListNode s = removeLinkedListElements.removeElements(root,1);

    }
}
