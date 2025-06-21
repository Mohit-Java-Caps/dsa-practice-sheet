class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
 
        // Collect non-zero frequencies
        List<Integer> freqList = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) freqList.add(f);
        }
 
        // Sort frequencies to allow windowing
        Collections.sort(freqList);
 
        int size = freqList.size();
        int totalSum = word.length();
        int prefixSum = 0;
        int result = Integer.MAX_VALUE;
 
        int j = 0, windowSum = 0;
        for (int i = 0; i < size; i++) {
            int minFreq = freqList.get(i);
            int maxFreq = minFreq + k;
 
            // Move `j` to include all frequencies within the valid range
            while (j < size && freqList.get(j) <= maxFreq) {
                windowSum += freqList.get(j);
                j++;
            }
 
            int rightSize = size - j;
            int rightSum = totalSum - windowSum;
 
            int deletions = rightSum - (rightSize * maxFreq) + prefixSum;
            result = Math.min(result, deletions);
 
            // Prepare for next iteration
            totalSum -= minFreq;
            prefixSum += minFreq;
            windowSum -= minFreq;
        }
 
        return result;
    }
}
