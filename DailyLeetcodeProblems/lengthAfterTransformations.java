class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1000000007;
        long[] count = new  long[26];

        for(char c : s.toCharArray()){
            count[c-'a']++;
        }

        for(int i = 0;i<t;i++){
            long[] next = new long[26];
            for(int j = 0;j<26;j++){
                if(j == 25){
                    next[0] = (next[0] + count[25]) % MOD; // 'a'
                    next[1] = (next[1] + count[25]) % MOD; /// 'b'
                } else {
                    next[j +1] = (next[j+1] + count[j]) % MOD;
                }
            }
            count = next;
        }

        long ans = 0;
        for(long val : count){
            ans = (ans + val) % MOD;
        }

        return (int) ans;
    }
}
