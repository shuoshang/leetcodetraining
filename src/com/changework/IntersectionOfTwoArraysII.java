package com.changework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer,Integer> map =  new HashMap<>();
//        int l = nums1.length <= nums2.length ? nums1.length : nums2.length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else{
                map.put(nums1[i],map.get(nums1[i])+1);
            }
        }

        for(int j=0;j<nums2.length;j++){
            if(!map.containsKey(nums2[j])){
                continue;
            }else{
                map.put(nums2[j],map.get(nums2[j])-1);
                if(map.get(nums2[j])>=0){
                    list.add(nums2[j]);
                }
            }
        }
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
    public static void main(String[] args) {

        // write your code here
        IntersectionOfTwoArraysII intersectionOfTwoArraysII =  new IntersectionOfTwoArraysII();
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] intersectint = intersectionOfTwoArraysII.intersect(nums1,nums2);
        System.out.println(Arrays.toString(intersectint));
    }
}
