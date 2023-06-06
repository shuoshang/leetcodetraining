package com.changework;


//定义 i 和 j 两个指针分别指向数组的左右两端，然后两个指针向中间搜索，并且更新面积最大值 res，直到 i == j 时返回 res。
//其中 容器装水量的算法是找出左右两个边缘中较小的那个乘以两边缘的距离
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int length = height.length;
        int i=0,j=length-1;
        int res = 0;
        while(i!=j){
            int p1=height[i];
            int p2=height[j];
            if(p1<=p2){
                res=Math.max(res,(j-i)*p1);
                i=i+1;
            }else{
                res=Math.max(res,(j-i)*p2);
                j=j-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        // write your code here
        ContainerWithMostWater containerWithMostWater =  new ContainerWithMostWater();
        int[] nums1 = new int[]{1,8,6,2,5,4,8,3,7};
        int maxarea = containerWithMostWater.maxArea(nums1);
        System.out.println(maxarea);
    }
}
