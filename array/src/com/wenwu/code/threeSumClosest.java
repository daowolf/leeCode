package com.wenwu.code;

import org.junit.Test;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int min = Math.abs(nums[0]+nums[1]+nums[2]-target);
        int l=0,m=1,n=2;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    int temp = nums[i]+nums[j]+nums[k]-target;
                    //System.out.println(min>Math.abs(temp));
                    if(min>Math.abs(temp)){
                        min = Math.abs(temp);
                        l=i;m=j;n=k;

                    }
                }
            }
        }
        return nums[l]+nums[m]+nums[n];
    }

    @Test
    public void test(){
        int[] nums ={1,1,1,0};
        int target = -100;
        int result = threeSumClosest(nums, target);
        System.out.println(result);
    }
}
