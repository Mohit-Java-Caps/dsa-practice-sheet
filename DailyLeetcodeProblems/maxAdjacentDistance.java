class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxdiff = 0;

        for(int i = 0;i<n;i++){
            int next = (i+1)%n;
            int diff = Math.abs(nums[i] - nums[next]);
            maxdiff = Math.max(maxdiff, diff);
        }
        return maxdiff;
    }
}
