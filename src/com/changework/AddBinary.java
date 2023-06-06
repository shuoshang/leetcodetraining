package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Character.getType;


//两个二进制数相加
//设置标志位，加上对2取整，str加上对2的余数
//两个不一定谁长
public class AddBinary {

    public String addBinary(String a, String b) {

        //hello world
        StringBuilder str =  new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int flag = 0;
        while(i>=0 && j>=0){
            int mul =( a.charAt(i)-'0') + ( b.charAt(j)-'0') + flag;
            flag = mul/2;
            str.append(String.valueOf(mul%2));
            i--;
            j--;
        }
        if(i==-1){
            while(j>=0){
                int mul =b.charAt(j)-'0' + flag;
                flag = mul/2;
                str.append(String.valueOf(mul%2));
                j--;
            }
        }
        if(j==-1){
            while(i>=0){
                int mul =a.charAt(i)-'0' + flag;
                flag = mul/2;
                str.append(String.valueOf(mul%2));
                i--;
            }
        }
        if(flag!=0){
            str.append(String.valueOf(flag%2));

        }
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        // JDK8 Lambda表达式写法
        List<String> list1 = Arrays.asList("I", "love", "you", "too");
        Collections.sort(list1, (s1, s2) ->{// 省略参数表的类型
            if(s1 == null)
                return -1;
            if(s2 == null)
                return 1;
            return s1.length()-s2.length();
        });
        System.out.println(list1);

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list2.forEach( str -> {
            if(str.length()>3)
                System.out.println(str);
        });


        ArrayList<String> list3 = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list3.removeIf(str -> str.length()>3); // 删除长度大于3的元素
        System.out.println(list3);

        // write your code here
        AddBinary addBinary =  new AddBinary();
        String t = addBinary.addBinary("1010","1011");
        System.out.println(t);
    }
}
