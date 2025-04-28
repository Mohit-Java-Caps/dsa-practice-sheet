class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, ans = 0;
        int start = 0;

        for(int end = 0;end<nums.length;end++){
            sum += nums[end];
        
        while(sum * (end - start + 1) >= k){
            sum -= nums[start];
            start++;
        }
        ans += (end-start + 1);
    }
    return ans;
    }
}
