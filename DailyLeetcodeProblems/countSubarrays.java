class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minpos = -1, maxpos= -1, badpos = -1;
        long ans = 0;

        for(int i = 0;i<n;i++){
            if(nums[i]< minK || nums[i]>maxK){
                badpos=i;
            }
            if(nums[i] == minK){
                minpos=i;
            }
            if(nums[i] == maxK){
                maxpos= i;
            }
            int correctStart = Math.min(minpos, maxpos);
            if(correctStart > badpos){
                ans+= correctStart - badpos;
            }
        }
        return ans;

    }
}
