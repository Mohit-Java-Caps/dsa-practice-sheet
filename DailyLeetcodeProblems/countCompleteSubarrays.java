import java.util.*;

// To identify complete subarrays, we need to find all subarrays that contain every unique element present in the entire array. A brute-force approach would involve checking all possible subarrays, but this would be inefficient for large arrays.
 
//Instead, we can utilize a sliding window approach:
 
//1. Determine the total number of unique elements in nums.

//2. Use two pointers (left and right) to define a window over the array.
//3. Maintain a frequency map to track the count of elements within the current window.

//4. Expand the window by moving the right pointer and updating the frequency map.

//5. Shrink the window from the left when the window contains all unique elements, updating the count of complete subarrays accordingly.
 
public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int totalUnique = new HashSet<Integer>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new))).size();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, count = 0;
 
        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
 
            while (freqMap.size() == totalUnique) {
                count += n - right;
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
        }
 
        return count;
    }
}
