package com.wenwu.code;

import org.junit.Test;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class maxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int temp;
        for (int i = 0; i <height.length ; i++) {
            for (int j = i+1; j <height.length ; j++) {

                temp = (j-i)*Math.min(height[i],height[j]);
                if(temp >max){
                    max = temp;
                }
            }
        }
        return max;
    }


    @Test
    public void test(){
        int[] arr = {1,3,4,5,2,23,7,9,5};
        System.out.println(maxArea(arr));
    }
}
