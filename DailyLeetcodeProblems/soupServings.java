class Solution {
    private Map<Long, Double> memo = new HashMap<>();
    private int SCALE = 25;
    public double soupServings(int n) {
     if (n >= 4800) return 1.0;
        return dfs((n + SCALE - 1) / SCALE, (n + SCALE - 1) / SCALE);
    }
 
    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
 
        long key = ((long) a << 32) | (b & 0xFFFFFFFFL);
        if (memo.containsKey(key)) return memo.get(key);
 
        double res = 0.25 * (dfs(a - 4, b)         // 100,0
                          + dfs(a - 3, b - 1)     // 75,25
                          + dfs(a - 2, b - 2)     // 50,50
                          + dfs(a - 1, b - 3));   // 25,75
 
        memo.put(key, res);
        return res;
    }
}
