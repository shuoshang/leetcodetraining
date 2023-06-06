package com.changework;

import java.util.Stack;


//由于计算时要保证最右边的数对齐，那么很自然的想到先用栈存放链表中的每个值，然后依次计算。
//由于相加时可能产生进位，所以使用一个flag表示是否有进位。
//提示：若栈中元素相加结束之后仍有进位，则需要新加入一个头结点。
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode head =  new ListNode();
        while(l1!=null){
            s1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        int l1Val,l2Val = 0;
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            if(!s1.isEmpty()){
                 l1Val = s1.peek() ;
                s1.pop();
            }else{
                 l1Val =0 ;
            }
            if(!s2.isEmpty()){
                 l2Val = s2.peek() ;
                 s2.pop();
            }else{
                 l2Val =0 ;
            }
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            sumNode.next = head.next;
            head.next = sumNode;
        }
        return head.next;
    }



    public static void main(String[] args) {

        // write your code here
        AddTwoNumbersII addTwoNumbersII =  new AddTwoNumbersII();
        ListNode root = new ListNode(7);
        ListNode curr1 = new ListNode(2);
        root.next= curr1;
        ListNode curr2 = new ListNode(4);
        curr1.next = curr2;
        ListNode curr3 = new ListNode(3);
        curr2.next = curr3;


        ListNode root2 = new ListNode(5);
        ListNode curr4 = new ListNode(6);
        root2.next= curr4;
        ListNode curr5 = new ListNode(4);
        curr4.next = curr5;

//        int s = addTwoNumbers.addTwoNumbers(curr2,curr4);
        System.out.println(addTwoNumbersII.addTwoNumbers(root,root2).val);
    }

}
