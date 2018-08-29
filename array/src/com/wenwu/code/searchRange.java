package com.wenwu.code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        if (max == 0) {
            return new int[]{-1, -1};
        }
        if (nums[max - 1] < target || nums[0] > target)
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

    private int[] searchRange2(int[] arr, int target) {
        int max = arr.length;
        if (max == 0) {
            return new int[]{-1, -1};
        }
        if (arr[max - 1] < target || arr[0] > target)
            return new int[]{-1, -1};
        if (max==1 && arr[0]==target){
            return new int[]{0,0};
        }else if(max==1 && arr[0]!=target){
            return new int[]{-1, -1};
        }
        int[] nums =new int[2];
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] < target && arr[i + 1] > target)
                return new int[]{-1, -1};
            else if(i==0&&arr[i]==target||i>0&&arr[i-1] < target && arr[i]==target){
                nums[0] = i;
            }else if (arr[i]==target && i+1==max||arr[i]==target&&i+1<max&&arr[i+1]>target){
                nums[1] = i;
            }
        }
        return nums;
    }


    @Test
    public void test() {
        int[] arr = {1, 3};
        int target = 3;
        int[] ints = searchRange(arr, target);
        int[] ints1 = searchRange2(arr, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints1[i]);
        }
        int[] ints2 = searchRange3(arr, target);


    }

    private int[] searchRange3(int[] arr, int target) {
        int[] result = new int[2];
        int arrLength = arr.length;
        int i = Arrays.binarySearch(arr, target);
        if(i<0){
            result[0]=-1;
            result[1]=-1;
            return result;
        }else if(i==0){
            result[0] = 0;
            if(arrLength==1) {
                result[1] = 0;
                return result;
            }
            for (int j = 1; j < arrLength; j++) {
                if (arr[j]==target&&j+1<arrLength&&arr[j+1]>target){
                    result[1]=j;
                    return result;
                }else if(arr[arrLength-1]==target){
                    result[1]=arrLength-1;
                    return result;
                }else if(arr[1]>target){
                    result[1]=0;
                    return result;
                }
            }
        }else if(i>0&& i<arrLength-1){
            if(arr[arrLength-1]==target)
                result[1]=arrLength-1;
            int count = 0;
            for (int j = 0; j <arrLength ; j++) {
                if (j<=i&&arr[j]==target)
                    if(count==0) {
                        result[0] = j;
                        count++;
                    }
                if(arr[j]>target&&arr[j-1]==target){
                    result[1] = j-1;
                }

            }

        }else if(i>0&& i==arrLength-1){
            result[1] = arrLength-1;
            for (int j = 0; j <arrLength ; j++) {
                if (j<=i&&arr[j]==target)
                    result[0]=j;
            }
        }
        return result;

    }

    @Test
    public void test2(){
        int[] arr ={5,7,7,8,8,10};
        int target = 6;
        int[] ints = searchRange3(arr, target);
        Arrays.stream(ints).forEach(a-> System.out.println(a));
    }


}
