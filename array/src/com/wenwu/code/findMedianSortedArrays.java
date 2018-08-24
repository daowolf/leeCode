package com.wenwu.code;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * <p>
 * 你可以假设 nums1 和 nums2 不同时为空。
 */
public class findMedianSortedArrays {

    /**
     * 时间复杂度lg(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int lengthAll = n + m;
        int l = (lengthAll + 1) / 2;
        int r = (lengthAll + 2) / 2;
        return (getKmin(nums1, 0, nums2, 0, l) + getKmin(nums1, 0, nums2, 0, r)) / 2.0;
    }

    public static int getKmin(int[] A, int Astart, int[] B, int Bstart, int k) {
        if (Astart > A.length - 1) {
            return B[Bstart + k - 1];
        }
        if (Bstart > B.length - 1) {
            return A[Astart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[Astart], B[Bstart]);
        }

        int Amin = Integer.MAX_VALUE, Bmin = Integer.MAX_VALUE;
        if (Astart + k / 2 - 1 < A.length) {
            Amin = A[Astart + k / 2 - 1];
        }
        if (Bstart + k / 2 - 1 < B.length) {
            Bmin = B[Bstart + k / 2 - 1];
        }

        return Amin < Bmin ? getKmin(A, Astart + k / 2, B, Bstart, k - k / 2) : getKmin(A, Astart, B, Bstart + k / 2, k - k / 2);
    }

    /**
     * 合并成一个有序的数组,返回index k的值
     *
     * @param a
     * @param b
     * @param k
     * @return 这个算法简单粗暴, 但是 其时间复杂度为 O（m+n）， 空间复杂图为O（m+n)
     */
    public static int findKthByMerge(int[] a, int[] b, int k) {
        System.out.println("Find kth by merge array first");
        int[] ab = new int[a.length + b.length];
        int ai = 0, bi = 0, abi = 0;
        while (ai < a.length && bi < b.length) {
            ab[abi++] = (a[ai] < b[bi]) ? a[ai++] : b[bi++];
        }
        while (ai < a.length) {
            ab[abi++] = a[ai++];
        }
        while (bi < b.length) {
            ab[abi++] = b[bi++];
        }
        System.out.println(Arrays.toString(ab));

        return ab[k];
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m)   //保证数组1一定最短
            return findMedianSortedArrays2(nums2,nums1);

        int L1=0,L2=0,R1=0,R2=0,c1,c2,lo = 0, hi = 2*n;  //我们目前是虚拟加了'#'所以数组1是2*n+1长度
        while(lo <= hi)   //二分
        {
            c1 = (lo+hi)/2;  //c1是二分的结果
            c2 = m+n- c1;
            L1 = (c1 == 0)?Integer.MIN_VALUE:nums1[(c1-1)/2];   //map to original element
            R1 = (c1 == 2*n)?Integer.MAX_VALUE:nums1[c1/2];
            L2 = (c2 == 0)?Integer.MIN_VALUE:nums2[(c2-1)/2];
            R2 = (c2 == 2*m)?Integer.MAX_VALUE:nums2[c2/2];

            if(L1 > R2)//C1向左分
                hi = c1-1;
            else if(L2 > R1)//C1向右分
                lo = c1+1;
            else
                break;
        }
        return (Math.max(L1,L2)+ Math.min(R1,R2))/2.0;

    }

    public static void main(String[] args) {
        int[] A ={1,3,7};

        int[] B ={2,3,4,5};
        double medianSortedArrays = findMedianSortedArrays2(A, B);
        System.out.println(medianSortedArrays);
        System.out.println(Integer.MAX_VALUE);
    }
}
