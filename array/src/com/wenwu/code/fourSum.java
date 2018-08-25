package com.wenwu.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
public class fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<String> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    for (int l = k+1; l <nums.length ; l++) {
                        if (nums[i]+nums[j]+nums[k]+nums[l]==target){
                            String key =""+nums[i]+nums[j]+nums[k]+nums[l];
                            if(!set.contains(key)){
                                set.add(key);
                                list.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            }

                        }
                    }
                }
            }
        }
        return list;
    }
}
