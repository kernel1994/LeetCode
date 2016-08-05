/**
* time: 2016-08-05 22:18
* note: Keep an array to record whether char is repeated.
* 		Make index of char in array for the time complexity of accssing element which is O(1).
*/

/**
* Given a string, find the length of the longest substring without repeating characters.
* 
* Examples:
* Given "abcabcbb", the answer is "abc", which the length is 3.
* Given "bbbbb", the answer is "b", with the length of 1.
* Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.isEmpty()) return 0;
        
        // There are 95 printable ASCII characters
        int[] array = new int[95];
        int maxLength = 0;
        int tempLength = 0;
        final int sLength = s.length();
        // the back indicator, if match failed, go to next indication
        int j = 0;
        
        for (int i = 0; i < sLength; i++) {
        	// space is the first character, we can get char location in array by subtracting  
            int index = s.charAt(i) - ' ';
            
            if (array[index] == 0) {
                tempLength++;
                array[index] = 1;
            } else if (array[index] == 1) {
                // go to next indication if match failed
                i = j++;
                
                if (tempLength > maxLength) {
                    maxLength = tempLength;
                }
                
                // initiate temporary length recorder and array
                tempLength = 0;
                Arrays.fill(array, 0);
            }
        }
        
        if (tempLength > maxLength) {
            maxLength = tempLength;
        }
        
        return maxLength;
    }
}
