package com.changework;


import java.util.HashMap;
import java.util.Map;

//考虑用滑动窗口与查找表来解决。
//设置查找表record，用来保存每次遍历时插入的元素，record 的最大长度为k
//遍历数组nums，每次遍历的时候在record 查找是否存在相同的元素，如果存在则返回true，遍历结束
//如果此次遍历在record 未查找到，则将该元素插入到record 中，而后查看record 的长度是否为k + 1
//如果此时record 的长度是否为k + 1，则删减record的元素，该元素的值为nums[i - k]
//如果遍历完整个数组nums未查找到则返回false
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey (nums[i])) {
                int index = i - map.get (nums[i]);
                if (index <= k) {
                    return true;
                }
                map.put (nums[i], i);
            }
            else {
                map.put (nums[i], i);
            }
        }

        return false;


    }

    public static void main(String[] args) {

        // write your code here
        ContainsDuplicateII containsDuplicateII =  new ContainsDuplicateII();
        int[] nums1 = new int[]{1,3,4,7};
        boolean median = containsDuplicateII.containsNearbyDuplicate(nums1,1);
        System.out.println(median);
    }
}
