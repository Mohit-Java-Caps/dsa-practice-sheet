class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformationsSecond(String s, int t, List<Integer> nums) {
        int[][] T = buildTransformationMatrix(nums);
        int[][] T_pow = matrixPower(T, t);
        long[] count = new long[26];
 
        // Count initial characters in the string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Multiply initial count vector with transformation matrix
        long[] result = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                result[j] = (result[j] + count[i] * T_pow[i][j]) % MOD;
            }
        }

        long total = 0;
        for(long val : result){
            total = (total + val) %  MOD;
        }
        return (int) total;

    }
    private int[][] buildTransformationMatrix(List<Integer> nums){
         int[][] T = new int[26][26];
        for (int i = 0; i < 26; i++) {
            int steps = nums.get(i);
            for (int step = 1; step <= steps; step++) {
                T[i][(i + step) % 26]++;
            }
        }
        return T;
    }

    private int[][] matrixPower(int[][] matrix, int power){
        int size = matrix.length;
        int[][] result = identityMatrix(size);
        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiplyMatrices(result, matrix);
            }
            matrix = multiplyMatrices(matrix, matrix);
            power >>= 1;
        }
        return result;
    }
     private int[][] identityMatrix(int size) {
        int[][] identity = new int[size][size];
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }

    private int[][] multiplyMatrices(int[][] A, int[][] B){
        int size = A.length;
        int[][] result = new int[size][size];
         for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    result[i][j] = (int) ((result[i][j] + (long) A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return result;
    }
}
