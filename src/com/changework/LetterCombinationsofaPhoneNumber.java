package com.changework;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
            LinkedList<String> ans = new LinkedList<String>();
            if(digits.isEmpty()) return ans;
            String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            ans.add("");
            for(int i =0; i<digits.length();i++){
                int x = Character.getNumericValue(digits.charAt(i));
                while(ans.peek().length()==i){
                    String t = ans.remove();
                    for(char s : mapping[x].toCharArray())
                        ans.add(t+s);
                }
            }
            return ans;
        }


    public static void main(String[] args) {

        // write your code here
        LetterCombinationsofaPhoneNumber letterCombinationsofaPhoneNumber = new LetterCombinationsofaPhoneNumber();
        List<String> lettercombinationsofaphonenumber = letterCombinationsofaPhoneNumber.letterCombinations("234");
        System.out.println(lettercombinationsofaphonenumber.toString());
    }
}
