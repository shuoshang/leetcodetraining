package com.changework;

public class LinkedListCycle {

    public boolean hasCycle(LNode head) {
        LNode fast = new LNode(0);
        LNode slow = new LNode(0);
        fast = head;
        slow = head;
        boolean loopExist = false;
        int len = 1;
        if (head == null) {
            return loopExist;
        }
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow!=fast){
                continue;
            }else{
                loopExist = true;
                break;
            }

        }
        return loopExist;

    }

    public static void main(String[] args) {

        // write your code here
        LinkedListCycle linkedListCycle =  new LinkedListCycle();
        LNode n1 = new LNode(3);
        LNode n2 = new LNode(2);
        LNode n3 = new LNode(0);
        LNode n4 = new LNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;


        boolean s = linkedListCycle.hasCycle(n1);
        System.out.println(s);
    }
}
