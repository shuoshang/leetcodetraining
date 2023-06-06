package com.changework;

import java.util.Arrays;


//设立一个表示进位的变量carried，建立一个新链表，把输入的两个链表从头往后同时处理，
// 每两个相加，将结果加上carried后的值作为一个新节点到新链表后面。
public class AddTwoNumbers{

    public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
//        ListNode root = new ListNode(0);
//        ListNode curr = root;
//        int i = 0;
//        int j = 0;
//        int sum1 = 0;
//        int sum2 = 0;
//        while (l1 != null) {
//            sum1 += l1.val * Math.pow(10, i);
//            l1 = l1.next;
//            i++;
//        }
//
//        while (l2 != null) {
//            sum1 += l2.val * Math.pow(10, j);
//            l2 = l2.next;
//            j++;
//        }
//
//        int twosum = sum1 + sum2;
//        int h = twosum;
//        int t = twosum;
//        ListNode rootsum = new ListNode();
//        ListNode temp = rootsum;
//        while (h != 0) {
//            t = h % 10;
//            h = h / 10;
//
//            ListNode newnode = new ListNode(t);
//            temp.next = newnode;
//            temp = newnode;
//
//        }
//        return rootsum.next;

        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }


    public static void main(String[] args) {

        // write your code here
        AddTwoNumbers addTwoNumbers =  new AddTwoNumbers();
        ListNode root2 = new ListNode(3);
        ListNode curr = new ListNode(4);
        curr.next= root2;
        ListNode curr2 = new ListNode(2);
        curr2.next = curr;


        ListNode root3 = new ListNode(4);
        ListNode curr3 = new ListNode(6);
        curr3.next= root3;
        ListNode curr4 = new ListNode(5);
        curr4.next = curr3;

//        int s = addTwoNumbers.addTwoNumbers(curr2,curr4);
        System.out.println(addTwoNumbers.addTwoNumbers(curr2,curr4).val);
    }


}
