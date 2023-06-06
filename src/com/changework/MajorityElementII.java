package com.changework;

import java.util.*;

public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {

//        List<Integer> list = new ArrayList<>();
//        if(nums ==null || nums.length ==0){
//            return list;
//        }
//        int a1 = nums[0];
//        int count1 = 0;
//        int a2 = nums[0];
//        int count2 = 0;
//        for(int i=0;i<nums.length;i++){
//            if(a1==nums[i]){
//                count1++;
//                continue;
//            }
//            if(a2==nums[i]){
//                count2++;
//                continue;
//            }
//            if(count1==0){
//                a1 =nums[i];
//                count1++;
//                continue;
//            }
//            if(count2==0){
//                a2 =nums[i];
//                count2++;
//                continue;
//            }
//            count1--;
//            count2--;
//        }
//        count1 = 0;
//        count2 =0;
//        for(int j=0;j<nums.length;j++){
//            if (a1 == nums[j]) count1++;
//            if (a2 == nums[j]) count2++;
//        }
//        if(a1 == a2){
//            if (count1 > nums.length / 3) list.add(a1);
//            return list;
//        }else{
//            if (count1 > nums.length / 3) list.add(a1);
//            if (count2 > nums.length / 3) list.add(a2);
//            return list;
//
//        }
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                int t = map.get(nums[i]);
                map.put(nums[i],t+1);
                if(t+1 > (nums.length/3)){
                    list.add(nums[i]);
                }
            }
        }
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);
        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);
        return listWithoutDuplicates;

    }


    public static void main(String[] args) {

        // write your code here
        MajorityElement majorityElement =  new MajorityElement();
        int[] nums = new int[]{3,2,3};
        int majorityelement = majorityElement.majorityElement(nums);
        System.out.println(majorityelement);
    }
}
