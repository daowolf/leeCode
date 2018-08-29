package com.wenwu.code;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int max = nums.length;
        if (nums[max - 1] < target || nums[0] > target || max == 0)
            return new int[]{-1, -1};
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            if (nums[i] < target && nums[i + 1] > target)
                return new int[]{-1, -1};
            else if (nums[i] == target) {
                integers.add(i);
            } else if (nums[i] > target) {
                break;
            }

        }
        return integers.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void test() {
        int[] arr = {1, 3, 3, 4, 5, 6, 7, 8};
        int target = 3;
        int[] ints = searchRange(arr, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
