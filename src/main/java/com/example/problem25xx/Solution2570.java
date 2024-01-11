package com.example.problem25xx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiejx
 * @date 2024/1/11 20:36
 */
public class Solution2570 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int[] arr1 = nums1[i];
            int[] arr2 = nums2[j];
            if (arr1[0] < arr2[0]) {
                list.add(arr1);
                i++;
            } else if (arr1[0] > arr2[0]) {
                list.add(arr2);
                j++;
            } else {
                list.add(new int[]{arr1[0], arr1[1] + arr2[1]});
                i++;
                j++;
            }
        }
        while (i < nums1.length) {
            list.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            list.add(nums2[j]);
            j++;
        }
        int[][] result = new int[list.size()][2];
        for (int k = 0; k < result.length; k++) {
            result[k][0] = list.get(k)[0];
            result[k][1] = list.get(k)[1];
        }
        return result;
    }
}
