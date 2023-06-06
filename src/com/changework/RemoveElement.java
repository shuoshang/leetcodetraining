package com.changework;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int k = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i]!=val){
                nums[i-k]=nums[i];
                i++;
            }else{
                k++;
                i++;
            }
        }
        return nums.length -k;

    }
    public static void main(String[] args) {

        // write your code here
        RemoveElement removeElement =  new RemoveElement();
        int[] nums1 = new int[]{0,1,2,2,3,0,4,2};
        int n = removeElement.removeElement(nums1,2);
        System.out.println(n);
    }
}
