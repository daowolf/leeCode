package com.wenwu.code;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class twoSum {

    /**
     *
     * @param nums
     * @param target
     * @return manay
     */
    public HashMap<Integer, Integer> twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <len ; j++) {
                if(target == nums[i]+nums[j]){
                    indexMap.put(i,j);
                }
            }
        }
        return indexMap;
    }

    /**
     *
     * @param nums
     * @param target
     * @return one
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] arr = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <len ; j++) {
                if(target == nums[i]+nums[j]){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }

    @Test
    public void test(){
        int[] arr =new int[]{1,2,3,4,5,6,7,8,9};
        HashMap<Integer, Integer> map = twoSum(arr, 10);
        map.forEach((key,value)-> System.out.println(key+"......."+value));
    }
}
