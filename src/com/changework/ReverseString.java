package com.changework;

public class ReverseString {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        // write your code here
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =  new LongestSubstringWithoutRepeatingCharacters();
        int longestsubstringint = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew");
        System.out.println(longestsubstringint);
    }
}
