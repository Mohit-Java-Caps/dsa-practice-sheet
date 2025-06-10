class Solution {
    public int maxDifference(String s) {
        int[] freq = new int[26];

        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        
        int maxodd = 0;
        int mineven = Integer.MAX_VALUE;

        for(int f : freq){
            if(f == 0) continue;
            if((f & 1)==1){
                maxodd = Math.max(maxodd, f);
            }else{
                mineven = Math.min(mineven, f);
            }
        }
        return maxodd - mineven;
    }
}
