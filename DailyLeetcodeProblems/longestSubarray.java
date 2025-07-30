class Solution {
    public int longestSubarray(int[] nums) {
        int maxAnd = 0;
        for(int num : nums){
            maxAnd = Math.max(maxAnd, num);
        }

        int maxLen = 0;
        int currLen = 0;
        for(int num : nums){
            if(num == maxAnd){
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            }else{
                currLen = 0;
            }
        }

        return maxLen;
    }
}
