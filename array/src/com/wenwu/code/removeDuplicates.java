package com.wenwu.code;

import org.junit.Test;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                len--;
            }
        }
        return len;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 2,3,3,3,5};
        //System.out.println(removeDuplicates(nums));
        System.out.println(removeDuplicates2(nums));
    }

    private int removeDuplicates2(int[] nums) {
        int len = nums.length;
        //边界条件1
        if(nums.length<2){
            return len;
        }
        int temp,p=0;
        for (int i = 0; i < len-p ; i++) {
            //边界条件2
            if(i == len-p-1){
                continue;
            }
            if (nums[i] == nums[i+1]){
                for(int j = i; j<len-p-1;j++){
                    temp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1] = temp;
                }
                p++;
                i--;
            }

        }
        return len-p;
    }


}
