package com.wenwu.code;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates
 * 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 */
public class combinationSum2 {
    /**
     * fn(arr(n),target)=fn-1(arr(n-1),target)+fn-1(arr(n-1),target-an);
     * arr(n)={a1,a2,a3,....,an}
     * 默认 an < target
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int max = candidates[candidates.length-1];
        int min = candidates[0];
        if(max<target){
            
        }else{

        }
        return null;

    }
}
