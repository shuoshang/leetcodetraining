package com.changework;

import java.util.Stack;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {

        Stack<Integer> s = new Stack<>();
        if(head == null || head.next == null){
            return head;
        }
        ListNode ln =  new ListNode();
        ln =  head.next;
        s.push(head.val);
        ListNode tmp1 = new ListNode();
        int tmp = head.val;
        while(ln!=null){
            if(ln.val==tmp){
                if(!s.isEmpty() && s.peek()==tmp){
                    s.pop();
                }
                ln = ln.next;
            }else{
                s.push(ln.val);
                tmp = ln.val;
                ln = ln.next;
            }
        }
        while(!s.isEmpty()){
            ListNode newtmp = new ListNode(s.peek());
            newtmp.next = tmp1.next;
            tmp1.next = newtmp;
            s.pop();
        }
        return tmp1.next;
    }



    public static void main(String[] args) {

        // write your code here
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII =  new RemoveDuplicatesFromSortedListII();
        ListNode root = new ListNode(1);
        ListNode curr1 = new ListNode(2);
        root.next= curr1;
        ListNode curr2 = new ListNode(2);
        curr1.next = curr2;
        ListNode curr3 = new ListNode(2);
        curr2.next = curr3;
//        ListNode curr4 = new ListNode(4);
//        curr3.next = curr4;
//        ListNode curr5 = new ListNode(4);
//        curr4.next = curr5;
//        ListNode curr6 = new ListNode(5);
//        curr5.next = curr6;

//        int s = addTwoNumbers.addTwoNumbers(curr2,curr4);
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(root).val);
    }
}
