package com.leet.twosum;

// Works only for sorted arrays
class Leet1a {
    public int[] twoSum(int[] nums, int target) {

        int index[] = new int[2];
        if(nums == null || nums.length <=1) {
            return index;
        }

        int i = 0;
        int j = nums.length - 1;

        while(i < j) { // This condition is important pattern

            if(nums[i] + nums[j] == target) {
                index[0] = i;
                index[1] = j;
                return index;
            }
            if(nums[i] + nums[j] < target) {
                i++;
            }
            if(nums[i] + nums[j] > target) {
                j--;
            }

        }
        return index;
    }
}