class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n % 3 != 0) return new int[0][0];
        List<int[]> ans = new ArrayList<>();
 
        for (int i = 0; i < n; i += 3) {
 
            int a = nums[i], b = nums[i + 1], c = nums[i + 2];
 
            if (c - a > k) return new int[0][0]; // Max difference too large
 
            ans.add(new int[]{a,b,c});
        }
 
        return ans.toArray(new int[0][]);
    }
}
