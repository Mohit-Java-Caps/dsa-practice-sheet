class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
         int n = nums.length;
        int[] freq = new int[n + 1];  // For difference array
 
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            freq[l]++;
            if (r + 1 < n) freq[r + 1]--;
        }
 
        // Apply prefix sum to get actual frequencies
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }
 
        // Check if each index is covered enough
        for (int i = 0; i < n; i++) {
            if (freq[i] < nums[i]) return false;
        }
 
        return true;
    }
}
