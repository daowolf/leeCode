package com.wenwu.code;

import org.junit.Test;

public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        int k=0;
        for (int i = 0; i <nums.length ; i++) {
            if(i==nums.length-1&&nums[i]<target){
                return nums.length;
            }
            if (nums[i]==target)
                k=i;
            if (nums[i]<target&&nums[i+1]>target)
                k=i+1;
        }
        return k;
    }

    @Test
    public void test(){
        int[] arr ={1,3,5,6};
        System.out.println(searchInsert(arr,7));
    }
}
