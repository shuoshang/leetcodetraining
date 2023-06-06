package com.changework;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//滑动窗口最大值
//输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//利用一个 双端队列，在队列中存储元素在数组中的位置， 并且维持队列的严格递减,，
// 也就说维持队首元素是 **最大的 **，当遍历到一个新元素时, 如果队列里有比当前元素小的，
// 就将其移除队列，以保证队列的递减。当队列元素位置之差大于 k，就将队首元素移除。
//补充：什么是双端队列（Dqueue）
//Deque 的含义是 “double ended queue”，即双端队列，它具有队列和栈的性质的数据结构。顾名思义，它是一种前端与后端都支持插入和删除操作的队列。
//Deque 继承自 Queue（队列），它的直接实现有 ArrayDeque、LinkedList 等。
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < k || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //在尾部添加元素，并保证左边元素都比尾部大
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            //在头部移除元素
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            //输出结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        SlidingWindowMaximum slidingWindowMaximum =  new SlidingWindowMaximum();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] singlenumber = slidingWindowMaximum.maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(singlenumber));
    }
}
