package com.wenwu.code;

import org.junit.Test;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class removeElement {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0){
            //-1表示原数组长度为0
            return len;
        }
        int temp,p = 0;
        for (int i = 0; i < len-p ; i++) {
            if(val == nums[i]){
                for (int j = i; j <len-p-1 ; j++) {
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

    @Test
    public void test(){
        int[] nums = new int[]{1, 2, 2,3,3,3,5};
        System.out.println(removeElement(nums,5));
    }
}
