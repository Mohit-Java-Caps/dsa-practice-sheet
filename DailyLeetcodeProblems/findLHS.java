class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        //counting freq for each number
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        int maxLen = 0;
        for(int num : freq.keySet()){
            if(freq.containsKey(num + 1)){
                maxLen = Math.max(maxLen, freq.get(num) + freq.get(num + 1));
            }
        }

        return maxLen;
    }
}
