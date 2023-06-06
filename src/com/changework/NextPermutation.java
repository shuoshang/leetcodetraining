package com.changework;

import java.util.Arrays;
import java.util.Stack;
//下一个排列
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            stack.push(nums[i]);
            i--;
        }
        stack.push(nums[i]);
        int tmp = i - 1;
        int j = nums.length - 1;
        while (!stack.isEmpty()) {
            if (tmp == -1) {
                nums[j] = stack.peek();
                stack.pop();
                j--;
            } else {
                while(!stack.isEmpty() && stack.peek() > nums[tmp]){
                    nums[j] = stack.peek();
                    j--;
                    stack.pop();
                }
                j = j+1;
                int k = nums[tmp];
                nums[tmp] = nums[j];
                nums[j] = k;
                j--;
                break;
            }
        }
        while (!stack.isEmpty()) {
                nums[j] = stack.peek();
                stack.pop();
                j--;
            }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {

        // write your code here1,5,8,4,7,6,5,3,1
        NextPermutation nextPermutation =  new NextPermutation();
        int[] tokens = new int[]{3,5,2};
        nextPermutation.nextPermutation(tokens);
    }
}
