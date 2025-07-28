class Solution {
    public int countMaxOrSubsets(int[] nums) {
         int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        
        int count = 0;
        int n = nums.length;
        // Precompute the OR for all subsets
        int[] orValues = new int[1 << n];
        orValues[0] = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            // Find the rightmost set bit
            int rightmostBit = mask & -mask;
            int index = Integer.numberOfTrailingZeros(rightmostBit);
            orValues[mask] = orValues[mask ^ rightmostBit] | nums[index];
            if (orValues[mask] == maxOr) {
                count++;
            }
        }
        return count;
    }
}
