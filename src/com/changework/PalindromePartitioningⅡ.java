package com.changework;

import java.util.*;

public class PalindromePartitioningⅡ {
    List<List<String>> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public List<List<String>> partition(String s) {

        int flag = 0;
        stack.push(flag);
        int i = 0;
        while(stack.peek()==0){
            List<String> list = new ArrayList<>();
            while(flag<s.length() && i<s.length()){
                if(isPalindrome(s.substring(flag,i+1))){
                    list.add(s.substring(flag,i+1));
                    if(!map.containsKey(i+1) && i+1<s.length()){
                        flag = i+1;
                        stack.push(flag);
                        i++;
                    }else{
                        i++;
                        continue;
                    }
                }else{
                    i++;
                }
            }
            if(flag==s.length()){
                res.add(list);
            }
            while(!stack.isEmpty()){
                flag = stack.peek();
                stack.pop();
                list.remove(list.size()-1);
                while(flag<s.length() && i<s.length()){
                    if(isPalindrome(s.substring(flag,i+1))){
                        if(!map.containsKey(i+1)  && i+1<s.length()){
                            flag = i+1;
                            stack.push(flag);
                            list.add(s.substring(flag,i+1));
                            i++;
                        }else{
                            i++;
                            continue;
                        }
                    }else{
                        i++;
                    }
                }
                if(flag==s.length()){
                    res.add(list);
                }
            }
        }
        return res;
    }
    /**
     * 判断是否是回文串
     */
    public boolean isPalindrome(String s) {

        if(s.length()==0){
            return true;
        }
        int l =0;
        int r =s.length()-1;
        while( l < r){
            if(!(('a' <= s.charAt(l) && s.charAt(l) <= 'z') || ('A' <= s.charAt(l) && s.charAt(l) <= 'Z') || ('0' <= s.charAt(l) && s.charAt(l) <= '9') )){
                l++;
            }else if(!(('a' <= s.charAt(r) && s.charAt(r) <= 'z') || ('A' <= s.charAt(r) && s.charAt(r) <= 'Z') || ('0' <= s.charAt(r) && s.charAt(r) <= '9'))){
                r--;
            }else{
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }



    public static void main(String[] args){
        // write your code here
        PalindromePartitioningⅡ palindromePartitioningⅡ =  new PalindromePartitioningⅡ();
        List<List<String>> palindromepartitioning = palindromePartitioningⅡ.partition("aab");
        System.out.println(palindromepartitioning);
    }
}
