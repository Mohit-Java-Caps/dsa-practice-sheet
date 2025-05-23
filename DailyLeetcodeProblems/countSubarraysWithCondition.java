class Solution {
    public int countSubarraysWithCondition(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i+2<n;i++){
            if( 2 * (nums[i] + nums[i+2]) == nums[i+1]){
                count++;
            }
        }
        return count;
    }
}
