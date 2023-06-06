package com.changework;

import java.util.Arrays;

//本题很简单，题目意思也很好理解，注意的点就是 进位问题。
//如果数组末位（个位）小于 9 ，直接个位加 1 返回即可
//如果数组末位（个位）等于 9，将该位（个位）设置为 0 ，并且产生了进位，接下来观察前一位（十位）
//如果前一位（十位）小于 9 ，直接十位加 1 返回即可
//如果前一位（十位）等于 9，将该位（十位）设置为 0 ，并且产生了进位，接下来观察前一位（百位）
//以此类推，最后观察运算完的第一位是否为 0 ，如果为 0 ，则在最前面加 1
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] newdigit = new int[digits.length+1];
        if(digits[digits.length-1]<9){
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        if(digits[digits.length-1]==9 && digits.length==1){
            digits[0]=0;
            newdigit[0]=1;
            for(int j = 1;j<digits.length+1 ; j++){
                newdigit[j]=digits[j-1];
            }
            return newdigit;
        }
        if(digits[digits.length-1]==9 && digits.length>=1){
            digits[digits.length-1]=0;
            for(int i=digits.length-2 ; i>=0 ;i--){
                if(digits[i]< 9){
                     digits[i]=digits[i]+1;
                     return digits;
                }
                if(digits[i]==9 && i !=0){
                    digits[i]=0;
                    continue;
                }
                if(digits[i]==9 && i ==0){
                    digits[i]=0;
                    newdigit[0]=1;
                    for(int j = 1;j<digits.length+1 ; j++){
                        newdigit[j]=digits[j-1];
                    }
                }
            }
        }
        return newdigit;
    }


    public static void main(String[] args) {

        // write your code here
        PlusOne plusOne =  new PlusOne();
        int[] nums = new int[]{9,9};
        int [] numsplusone = plusOne.plusOne(nums);
        System.out.println(Arrays.toString(numsplusone));
    }
}