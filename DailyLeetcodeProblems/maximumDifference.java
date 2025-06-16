class Solution {
    public int maximumDifference(int[] nums) {
        int minsofar = nums[0];
        int maxDiff = -1;

        for(int i = 1;i<nums.length;i++){
            if(nums[i] > minsofar){
                maxDiff = Math.max(maxDiff, nums[i] - minsofar);
            }else{
                minsofar = nums[i];
            }
        }
        return maxDiff;
    }
}
