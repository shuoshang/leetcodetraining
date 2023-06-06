package com.changework;


//我们使用两个指针，fast 与 slow。它们起始都位于链表的头部。随后slow 指针每次向后移动一个位置，而 fast 指针向后移动两个位置。如果链表中存在环，则 fast 指针最终将再次与slow 指针在环中相遇。
//如下图所示，设链表中环外部分的长度为 a。slow 指针进入环后，又走了 b 的距离与 fast 相遇。此时，fast 指针已经走完了环的 n 圈，因此它走过的总距离为 a+n(b+c)+b=a+(n+1)b+nc
//根据题意，任意时刻，fast 指针走过的距离都为 slow 指针的 2 倍。因此，我们有
//a+(n+1)b+nc=2(a+b)⟹a=c+(n−1)(b+c)
//有了 a=c+(n-1)(b+c)的等量关系，我们会发现：从快慢指针相遇点到入环点的距离加上 n-1圈的环长，恰好等于从链表头部到入环点的距离。
//因此，当发现 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇。

public class LinkedListCycleII {

    public LNode hasCycle(LNode head) {
        LNode fast = new LNode(0);
        LNode slow = new LNode(0);
        fast = head;
        slow = head;
        boolean loopExist = false;
        int len = 1;
        if (head == null) {
            return head;
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
        LNode newslow = new LNode(0);
        LNode newfast2 = new LNode(0);
        if(loopExist){
            newslow = head;
            newfast2 = fast;
            while(newslow!=newfast2){
                newslow = newslow.next;
                newfast2 = newfast2.next;
            }
        }else{
            return null;
        }
        return newslow;

    }

    public static void main(String[] args) {

        // write your code here
        LinkedListCycleII linkedListCycleII =  new LinkedListCycleII();
        LNode n1 = new LNode(3);
        LNode n2 = new LNode(2);
        LNode n3 = new LNode(0);
        LNode n4 = new LNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;


        LNode s = linkedListCycleII.hasCycle(n1);
//        System.out.println(s);
    }
}
