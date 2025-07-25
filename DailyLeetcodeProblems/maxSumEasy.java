class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int ans = 0;
        for (int num : set) {
            if (num > 0) ans += num;
        }

        if (ans == 0) {
            ans = Collections.max(set);
        }

        return ans;

    }
}
