package com.changework;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {

        int[] res = new int[T.length];
        Stack<Integer> s  = new Stack<>();
        for(int i=0;i<T.length;i++){
            if(!s.isEmpty()){
                while(!s.isEmpty() && (T[i] > T[s.peek()])){
                    res[s.peek()]=i-s.peek();
                    s.pop();
                }
                s.push(i);
                if(i==T.length-1){
                    while(!s.isEmpty()){
                        res[s.peek()]=0;
                        s.pop();
                    }
                }
            }else{
                s.push(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {

        // write your code here
        DailyTemperature dailyTemperature =  new DailyTemperature();
        int[] A = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] C = dailyTemperature.dailyTemperatures(A);
        System.out.println(Arrays.toString(C));
    }
}
