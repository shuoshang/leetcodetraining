package com.changework;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    public PriorityQueue<Integer> minheap, maxheap;
    public MedianFinder() {
        //维护较大的元素的最小堆
        maxheap = new PriorityQueue<Integer>(Collections.reverseOrder());
        //维护较小元素的最大堆
        minheap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxheap.add(num);
        minheap.add(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.add(minheap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) * 0.5;
        } else {
            return maxheap.peek();
        }
    }

    public static void main(String[] args) {

        // write your code here
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}
