package com.changework;

import java.util.*;

public class PerfectSquares {
    public int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        queue.add(n);
        if(n == 0)
            return 0;
        int count = 1;
        int k=0;
        int res = 0;
        while(!queue.isEmpty()){
            k = queue.peek();
            queue.poll();
                if (queue.isEmpty()) {
                    while (k - count * count > 0) {
                        queue2.add(k - count * count);
                        count++;
                    }
                    if(k - count * count == 0){
                        res ++;
                        break;
                    }
                    count = 1;
                    while (!queue2.isEmpty()) {
                        queue.add(queue2.peek());
                        queue2.poll();
                    }
                    res ++;
                } else {
                    while (k - count * count > 0) {
                        queue2.add(k - count * count);
                        count++;
                    }
                    if(k - count * count == 0){
                        res ++;
                        break;
                    }
                    count = 1;
                }

            }
            return res;
    }


    public static void main(String[] args) {

        // write your code here
        PerfectSquares perfectSquares =  new PerfectSquares();
        int  n = perfectSquares.numSquares(12);
        System.out.println(n);
    }
}
