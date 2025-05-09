class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 81; // Since num.length <= 80
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];
 
    // Precompute factorials and inverse factorials
    static {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }
 
    // Modular inverse using Fermat's little theorem
    static long modInverse(long x) {
        return pow(x, MOD - 2);
    }
 
    static long pow(long x, long y) {
        long res = 1;
        x %= MOD;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            y >>= 1;
        }
        return res;
    }
 
    // Compute n choose k modulo MOD
    static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return (((fact[n] * invFact[k]) % MOD) * invFact[n - k]) % MOD;
    }
 
    public int countBalancedPermutations(String num) {
        int n = num.length();
        int[] cnt = new int[10];
        int totalSum = 0;
        for (char c : num.toCharArray()) {
            int d = c - '0';
            cnt[d]++;
            totalSum += d;
        }
 
        if (totalSum % 2 != 0) return 0;
        int halfSum = totalSum / 2;
        int oddCount = n / 2;
        int evenCount = n - oddCount;
 
        // Memoization map: key -> "i,j,a,b", value -> count
        Map<String, Long> memo = new HashMap<>();
 
        return (int) dfs(0, halfSum, oddCount, evenCount, cnt, memo);
    }
 
    private long dfs(int digit, int sumOdd, int oddLeft, int evenLeft, int[] cnt, Map<String, Long> memo) {
        if (digit == 10) {
            return (sumOdd == 0 && oddLeft == 0 && evenLeft == 0) ? 1 : 0;
        }
 
        String key = digit + "," + sumOdd + "," + oddLeft + "," + evenLeft;
        if (memo.containsKey(key)) return memo.get(key);
 
        long res = 0;
        int total = cnt[digit];
        for (int i = 0; i <= total; i++) {
            int j = total - i;
            if (i > oddLeft || j > evenLeft) continue;
            int sum = i * digit;
            if (sum > sumOdd) continue;
            long ways = (comb(oddLeft, i) * comb(evenLeft, j)) % MOD;
            ways = (ways * dfs(digit + 1, sumOdd - sum, oddLeft - i, evenLeft - j, cnt, memo)) % MOD;
            res = (res + ways) % MOD;
        }
 
        memo.put(key, res);
        return res;
    }
}
