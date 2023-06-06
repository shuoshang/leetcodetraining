package com.changework;

//缺失的第一个正数
//那这道题就变成了 如何利用数组的 value 和 index 之间的关系来找到最小缺失正整数 ，如果想到了这一点，就已经成功了一半。
//如果继续想下去有几点是可以明确的：
//缺失的正整数肯定在 [1, array.length + 1] 这个范围内
//我们可以交换输入数组中的元素的位置来让 index 和 value 的关系更加明确
//保证 index 和 value 的关系后，我们可以通过 index 来判定整数的存在性
//第一点很好理解，一个数组总共有 array.length 这么多个数，全部排满，也就是 1,2,…array.length，
// 那么答案就是 array.length + 1，没有排满，那么在这之间肯定是有缺失元素的。
//第二点是说我们可以通过交换来让 index 和 value 形成对应，我们看的是 value，但是 index 可以辅助我们寻找。
//前两点明确了，第三点就是从头到尾寻找答案的过程。
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if(nums == null ||  nums.length == 0){
            return 1;
        }
        int i = 0;
        while(i< nums.length){
            if(nums[i] == i+1){
                i++;
                continue;
            }
            if(nums[i] <1 || nums[i] > nums.length){
                i++;
                continue;
            }
            int k = nums[i];
            if(nums[k-1] == k){
               i++;
               continue;
            }else{
                nums[i] = nums[k-1];
                nums[k-1] = k;
            }
        }

        for(int j = 0; j < nums.length ; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {

        // write your code here
        FirstMissingPositive firstMissingPositive =  new FirstMissingPositive();
        int[] nums = new int[]{1,5,6,2,5,4,8,3,7};
        int  firstmissingpositive = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(firstmissingpositive);
    }
}
