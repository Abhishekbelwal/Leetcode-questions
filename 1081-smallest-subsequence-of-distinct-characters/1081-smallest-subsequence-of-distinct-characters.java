import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        // Track the last seen index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        // Track if a character is already present in the stack
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int idx = curr - 'a';
            
            // If character is already in our result, skip it
            if (seen[idx]) {
                continue;
            }
            
            // Pop greater characters if they appear again later in the string
            while (!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }
            
            // Push current character to stack and mark it as seen
            stack.push(curr);
            seen[idx] = true;
        }
        
        // Build the final result string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
