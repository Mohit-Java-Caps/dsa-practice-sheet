class Solution {
    public int maximumGain(String s, int x, int y) {
         int score = 0;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        // First pass: remove the higher points substring
        if (x >= y) {
            score += removeSubstring(chars, stack, 'a', 'b', x);
            // Second pass: remove the lower points substring
            chars = stackToString(stack);
            stack.clear();
            score += removeSubstring(chars, stack, 'b', 'a', y);
        } else {
            score += removeSubstring(chars, stack, 'b', 'a', y);
            // Second pass: remove the lower points substring
            chars = stackToString(stack);
            stack.clear();
            score += removeSubstring(chars, stack, 'a', 'b', x);
        }
        
        return score;
    }
 
    private int removeSubstring(char[] chars, Stack<Character> stack, char first, char second, int points) {
        int score = 0;
        for (char c : chars) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                score += points;
            } else {
                stack.push(c);
            }
        }
        return score;
    }
 
    private char[] stackToString(Stack<Character> stack) {
        char[] result = new char[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
}
