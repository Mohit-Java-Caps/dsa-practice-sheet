class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        List<int[]> pairs  = new ArrayList<>();
        for(int i =0;i<n;i++){
            pairs.add(new int[]{nums[i], i});

        }

        pairs.sort((a,b) -> b[0] -a[0]);
        // taking top k elements
        List<int[]> topK = pairs.subList(0,k);

        topK.sort(Comparator.comparingInt(a -> a[1]));

        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = topK.get(i)[0];
        }
        return ans;
    }
}
