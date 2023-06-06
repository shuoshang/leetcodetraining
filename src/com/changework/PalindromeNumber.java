package com.changework;

//判断数字是否是回文数字
//把数字翻转过来， n = n*10 + x%10 x = x/10
//翻转过来的长度是否与原有长度一致，数值是否相等，或是否小于0
public class PalindromeNumber {


    public boolean isPalindrome(int x) {

        int tmp = x;
        long n = 0;
        int len = 0;
        while(x!=0){
            n = n*10 + x%10;
            x = x/10;
            len++;
        }
        int count=0; //计数
        int tmp2 =  (int)n==n ? (int)n:0;
        int num  = (int)n==n ? (int)n:0;
        while(num>=1) {
            num/=10;
            count++;
        }
        if((num < 0 ) || (len!=count) || (tmp2!=tmp)){
            return  false;
        }else{
            return true;
        }

    }

    public static void main(String[] args) {

        // write your code here
        PalindromeNumber palindromeNumber =  new PalindromeNumber();
        boolean ispalindrome = palindromeNumber.isPalindrome(-123);
        System.out.println(ispalindrome);
    }
}
