class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow = new int[n];
        pow[0] = 1;

        for(int i = 1 ;i<n;i++){
            pow[i] = (pow[i-1]*2) % MOD;
        }
        int l = 0, r = n-1;
        int ans = 0;
        while(l<=r){
            if(nums[l] + nums[r] <= target){
                ans = (ans + pow[r-l])%MOD;
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }

}
