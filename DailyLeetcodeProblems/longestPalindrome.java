class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int length = 0, central = 0;

        for(String word: words){
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for(String word : freq.keySet()){
            String rev = new  StringBuilder(word).reverse().toString();
            if(!word.equals(rev)){
                if(freq.containsKey(rev)){
                int paircount = Math.min(freq.get(word), freq.get(rev));
                length += 4 * paircount;
                freq.put(word, freq.get(word) - paircount);
                freq.put(rev, freq.get(rev) - paircount);
                }
            }else{
                int count = freq.get(word);
                length += 4 * (count/ 2);
                if(count % 2 == 1) central = 2;
            }
        }
        return length + central;
    }
}
