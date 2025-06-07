class Solution {
    public String clearStars(String s) {
        int n = s.length();
        List<Integer>[] g = new ArrayList[26];
        for (int i = 0; i < 26; i++) g[i] = new ArrayList<>();
        boolean[] rem = new boolean[n];
 
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                rem[i] = true;
                for (int j = 0; j < 26; j++) {
                    if (!g[j].isEmpty()) {
                        int idx = g[j].remove(g[j].size() - 1);
                        rem[idx] = true;
                        break;
                    }
                }
            } else {
                g[c - 'a'].add(i);
            }
        }
 
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!rem[i]) result.append(s.charAt(i));
        }
 
        return result.toString();
    }
}
