package com.leet;

import java.util.HashMap;
import java.util.Map;

// Strategy: Loop thru array and insert elements as key in Hashmap. As you keep moving forward
class Leet1b {

    public int[] twoSum(int[] nums, int target) {

        int index[] = new int[2];

        if(nums == null || nums.length <=1) {
            return index;
        }

        // Compliment will be the key!
        Map<Integer, Integer> visited = new HashMap<>();

        for(int i=0; i<nums.length; i++) {

            int compliment = target - nums[i];
            if(visited.containsKey(compliment)) {
                index[1] = visited.get(compliment);
                index[0] = i;
            } else {
                // put the array elements key, which will act as "compliment" to upcoming elements.
                // Value is index, as thats what we need to return.
                 visited.put(nums[i], i);
            }
       }

        return index;
    }
}