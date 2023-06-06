package com.changework;

import java.util.*;

//桶排序~哈希表，以出现频率为数组索引
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> res = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
              if(list[map.get(key)] == null){
                  list[map.get(key)] = new ArrayList();
              }
              list[map.get(key)].add(key);
          }
          for(int j=list.length-1;j>=0;j--){
              if(list[j]==null) continue;
              res.addAll(list[j]);
              if(res.size()==k){
                  break;
              }
          }
          int[] ret = res.stream().mapToInt(Integer::valueOf).toArray();
          return ret;
    }

    public static void main(String[] args) {

        // write your code here
        TopKFrequentElements topKFrequent =  new TopKFrequentElements();
        int[] nums1 = new int[]{1,1,1,2,2,3};
        int[] topkfrequent = topKFrequent.topKFrequent(nums1,2);
        System.out.println(Arrays.toString(topkfrequent));
    }
}
