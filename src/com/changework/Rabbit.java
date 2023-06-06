package com.changework;

import java.util.Arrays;
import java.util.LinkedList;

public class Rabbit {
    public void rabbitNum() {
        int x = 0; //代表当月
        int y = 1; //代表上个月
        int z = 1; //代表上上个月
        int month = 24;
        for (int i = 3; i <= month; i++) {
            x = y + z;//获得当月的兔子数量
            System.out.println("第" + i + "月的兔子数量为" + x + "对");
            z = y;//将上月的兔子数量赋给上上月的兔子数量，下轮循环用。
            y = x; //将当月的兔子数量赋给上月，下轮循环用。		        }	         }
        }
    }
    public  LinkedList findSegment(int[] A, int n) {
            // write code here
            LinkedList  list = new LinkedList();
            int first = 0,last = 0;
            int max = A[0],min = A[A.length-1];
            for (int i = 1; i < A.length; ++i)
            {
                if (max > A[i])
                    last = i;
                else if (max < A[i])
                    max = A[i];
            }
             Arrays.toString(A);
            for(int i = A.length-2; i >= 0; --i)
            {
                if (min < A[i])
                    first = i;
                else if (min > A[i])
                    min = A[i];
            }
            list.push(first);
            list.push(last);
            return list;
        }
}
