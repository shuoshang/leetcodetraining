package com.changework;

import java.util.*;


//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 *a，b，c ，*使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//题目需要我们找出三个数且和为 0 ，那么除了三个数全是 0 的情况之外，肯定会有负数和正数，所以一开始可以先选择一个数，然后再去找另外两个数，这样只要找到两个数且和为第一个选择的数的相反数就行了。也就是说需要枚举 a 和 b ，将 c 的存入 map 即可。
//需要注意的是返回的结果中，不能有有重复的结果。这样的代码时间复杂度是 O(n^2)。在这里可以先将原数组进行排序，然后再遍历排序后的数组，这样就可以使用双指针以线性时间复杂度来遍历所有满足题意的两个数组合。

//for(while(两个while))
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //int转为Integer数组
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> listsum= new ArrayList<>();
        if(integers.length<=2){
            return listsum;
        }
        if((integers.length==3)  && (integers[0]+integers[1]+integers[2])!=0){
            return listsum;
        }
        for (int i = 0; i < integers.length; i++) {
            if (i>0 && integers[i].equals(integers[i-1])) {
                continue;
            }
                int length = integers.length;
                int k = i+1;
                int j = length - 1;
                while (k < j) {
                    if((k+1>length - 1) || (j-1 <0)){
                        break;
                    }
                    int p1 = integers[k];
                    int p2 = integers[j];

                    if ((p1 + p2) > Math.negateExact(integers[i])) {
                        j = j - 1;
                    } else if ((p1 + p2) < Math.negateExact(integers[i])) {
                        k = k + 1;
                    } else {
                        listsum.add(Arrays.asList(integers[i],integers[k],integers[j]));
                        while (k<j && integers[k].equals(integers[k+1])) k++; // 去重
                        while (k<j && integers[j].equals(integers[j-1]) ) j--; // 去重
                        k++;
                        j--;
                    }
                }
        }
        return listsum;

    }

    public static void main(String[] args) {

        // write your code here
        ThreeSum threeSum =  new ThreeSum();
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> list= threeSum.threeSum(nums);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString() );
//            for(int j=0;j<list.get(i).size();j++){
//                System.out.println(list.get(i).get(j) );
//            }
        }
    }
}


