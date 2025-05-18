class Solution {
    static final int MOD = 1_000_000_007;
    public int colorTheGrid(int m, int n) {
       List<Integer> stateList = new ArrayList<>();
        generateStates(m, 0, 0, stateList);
 
        int size = stateList.size();
        int[] states = new int[size];
        for (int i = 0; i < size; i++) states[i] = stateList.get(i);
 
        // Build compatible transitions using index
        List<Integer>[] transitions = new List[size];
        for (int i = 0; i < size; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (isCompatible(states[i], states[j], m)) {
                    transitions[i].add(j);
                }
            }
        }
 
        // Use array for DP
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
 
        for (int col = 1; col < n; col++) {
            int[] newDp = new int[size];
            for (int i = 0; i < size; i++) {
                for (int j : transitions[i]) {
                    newDp[j] = (newDp[j] + dp[i]) % MOD;
                }
            }
            dp = newDp;
        }
 
        int result = 0;
        for (int val : dp) result = (result + val) % MOD;
        return result;
    }
 
    // Generate valid single-column states
    private void generateStates(int m, int row, int state, List<Integer> res) {
        if (row == m) {
            res.add(state);
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (row == 0 || (state % 3) != color) {
                generateStates(m, row + 1, state * 3 + color, res);
            }
        }
    }
 
    // Check vertical compatibility (no same row color)
    private boolean isCompatible(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            if (a % 3 == b % 3) return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }
}
