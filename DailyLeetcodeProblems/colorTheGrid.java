class Solution {
    static final int MOD = 1_000_000_007;
    public int colorTheGrid(int m, int n) {
      List<Integer> states = new ArrayList<>();
        Map<Integer, List<Integer>> transitions = new HashMap<>();
 
        // Generate all valid column states using 3^m base
        generateStates(m, 0, 0, states);
 
        // Build transitions between valid states
        for (int s1 : states) {
            transitions.put(s1, new ArrayList<>());
            for (int s2 : states) {
                if (isValidTransition(s1, s2, m)) {
                    transitions.get(s1).add(s2);
                }
            }
        }
 
        // DP: Map state to count at each column
        Map<Integer, Integer> dp = new HashMap<>();
        for (int state : states) dp.put(state, 1); // base case
 
        for (int col = 1; col < n; col++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int prev : dp.keySet()) {
                for (int next : transitions.get(prev)) {
                    newDp.put(next, (newDp.getOrDefault(next, 0) + dp.get(prev)) % MOD);
                }
            }
            dp = newDp;
        }
 
        int result = 0;
        for (int count : dp.values()) result = (result + count) % MOD;
        return result;
    }
 
    // Recursively generate all valid column colorings
    private void generateStates(int m, int row, int state, List<Integer> result) {
        if (row == m) {
            result.add(state);
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (row == 0 || (state % 3) != color) {
                generateStates(m, row + 1, state * 3 + color, result);
            }
        }
    }
 
    // Check if two states can be adjacent
    private boolean isValidTransition(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            if ((a % 3) == (b % 3)) return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }
}
