class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        char[] st = new char[n];
        int top = -1;

        StringBuilder res = new StringBuilder();
        int minIdx = 0;

        for(char c : s.toCharArray()){
            count[c-'a']--;
            st[++top] = c;

            while(minIdx < 26 && count[minIdx] == 0){
                minIdx++;
            }
            while(top >= 0 && st[top] <= (char) (minIdx + 'a')){
                res.append(st[top--]);
            }
        }
        while(top >= 0){
            res.append(st[top--]);
        }

        return res.toString();
    }
}
