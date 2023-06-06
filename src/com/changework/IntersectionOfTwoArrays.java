package com.changework;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Set set = new HashSet<>();
        for(int i = 0; i < nums1.length; ++i){
            set.add(nums1[i]);
        }
        Set set2 = new HashSet<>();
        for(int i = 0; i < nums2.length; ++i){
            set2.add(nums2[i]);
        }
        HashMap<Integer,Integer> map =  new HashMap<>();
        List<Integer> list = new ArrayList<Integer>();
        for(Object obj: set){
            int aa= (Integer)obj;
            if(set2.contains(aa)){
                list.add(aa);
            }else{
                continue;
            }
        }

        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
    public static void main(String[] args) {

        // write your code here
        IntersectionOfTwoArrays intersectionOfTwoArrays =  new IntersectionOfTwoArrays();
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] intersectint = intersectionOfTwoArrays.intersect(nums1,nums2);
        System.out.println(Arrays.toString(intersectint));
    }
}
