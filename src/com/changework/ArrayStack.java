package com.changework;

import java.util.Arrays;
/**
 * 数组实现栈
 * @param <T>
 */
public class ArrayStack<T> {
    //实现栈的数组
    private Object[] stack;
    //数组大小
    private int size;

    ArrayStack() {
        stack = new Object[10];//初始容量为10
    }

    //判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //返回栈顶元素
    public T peek() {
        T t = null;
        if (size > 0)
            t = (T) stack[size - 1];
        return t;
    }

    public void push(T t) {
        expandCapacity(size + 1);
        stack[size] = t;
        size++;
    }

    //出栈
    public T pop() {
        T t = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return t;
    }

    //扩大容量
    public void expandCapacity(int size) {
        int len = stack.length;
        if (size > len) {
            size = size * 3 / 2 + 1;//每次扩大50%
            stack = Arrays.copyOf(stack, size);
        }
    }
}


