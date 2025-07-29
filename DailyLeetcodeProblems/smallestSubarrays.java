class Solution {
    public int[] smallestSubarrays(int[] nums) {
       int n = nums.length;
        int[] result = new int[n];
        int[] maxOr = new int[n];
        maxOr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxOr[i] = nums[i] | maxOr[i + 1];
        }
        
        int[] lastPos = new int[32];
        Arrays.fill(lastPos, -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int bit = 0; bit < 32; bit++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    lastPos[bit] = i;
                }
            }
            int farthest = i;
            for (int bit = 0; bit < 32; bit++) {
                if ((maxOr[i] & (1 << bit)) != 0 && lastPos[bit] != -1) {
                    farthest = Math.max(farthest, lastPos[bit]);
                }
            }
            result[i] = farthest - i + 1;
        }
        return result;
    }
}
