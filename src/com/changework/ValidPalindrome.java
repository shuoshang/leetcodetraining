package com.changework;

public class ValidPalindrome {

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

    public static void main(String[] args) {

        // write your code here
        ValidPalindrome validPalindrome =  new ValidPalindrome();
        boolean validpalindrome = validPalindrome.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(validpalindrome);
    }
}
