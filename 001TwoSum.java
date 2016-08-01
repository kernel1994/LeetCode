/**
* time: 2016-07-30 23:00:00
* note: Good good study, day day up!
*/

/**
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
* You may assume that each input would have exactly one solution.
* 
* Example:
* Given nums = [2, 7, 11, 15], target = 9,
* 
* Because nums[0] + nums[1] = 2 + 7 = 9,
* return [0, 1].
* 
* UPDATE (2016/2/13):
* The return format had been changed to zero-based indices. Please read the above updated description carefully.
*/

// brute force
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        
        return null;
    }
}

// HashMap
public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer> ();
        
        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // time complexity of get() is O(1)
            Object complementObject = table.get(complement);
            
            if (complementObject != null) {
                int complementIndex = (Integer) complementObject;
                
                // not allowed one element and itself
                if (complementIndex != i) {
                    return new int[] {i, complementIndex};
                }
            }
        }
        
        return null;
    }
}
