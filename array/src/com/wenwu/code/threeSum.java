package com.wenwu.code;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 */
public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        resultList.add(integers);
                    }
                }
            }
        }
        return resultList;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int mid,right;
        //left只用来循环所有的非正数就行了
        for (int left = 0; left < nums.length &&nums[left]<=0 ; left++) {
            mid = left +1; right = nums.length -1;
            int tmp = 0 - nums[left];
            //跳过left重复匹配
            if(left>0&&nums[left]==nums[left-1])
                continue;
            while(mid<right){
                if (nums[mid]+nums[right] ==tmp){
                    int tmp_mid = nums[mid],tmp_right =nums[right];
                    list.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    //跳过right和mid的重复匹配
                    while(mid<right&& nums[++mid] == tmp_mid);
                    while(mid< right && nums[--right] == tmp_right);
                }
                else if(nums[mid] + nums[right] <tmp)
                    mid++;
                else
                    right--;
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> rightSet = new HashSet<>();
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> allSet = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else
                map.put(nums[i],1);
            if(nums[i]>0){
                rightSet.add(nums[i]);
            }else if(nums[i]<0){
                leftSet.add(nums[i]);
            }
            if(nums[i] !=0){
                allSet.add(nums[i]);
            }
        }

        List<Integer> result = new ArrayList<>(allSet);
        //边界1
        if(map.containsKey(0)){
            if(map.get(0)>=3){
                list.add(Arrays.asList(0,0,0));
            }else if(map.get(0)>0){
                Iterator<Integer> iterator = leftSet.iterator();
                while(iterator.hasNext()){
                    int x =iterator.next();
                    int y = 0 - x;
                    if (rightSet.contains(y)){
                        list.add(Arrays.asList(x,0,y));
                    }
                }
            }
        }


        //边界2
        Iterator<Integer> rightIterator = rightSet.iterator();
        while(rightIterator.hasNext()){
            int x = rightIterator.next();
            int y = 0-2*x;
            if(map.containsKey(y)&&map.get(x)>=2){
                list.add(Arrays.asList(y,x,x));
            }
            if(x%2==0){
                int z = 0- x/2;
                if(map.containsKey(z)&&map.get(z)>=2){
                    list.add(Arrays.asList(z,z,x));
                }
            }


        }

        //边界3 3个非零数,都不相同

        return list;
    }

    /**
     * this code like a shit
     */
    @Test
    public void test(){
        int[] nums2 ={1,1,-2};
        List<List<Integer>> lists = threeSum2(nums2);
        System.out.println(lists);
    }

}
