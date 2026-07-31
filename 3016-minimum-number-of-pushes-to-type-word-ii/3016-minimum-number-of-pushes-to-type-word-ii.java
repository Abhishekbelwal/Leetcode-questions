import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int pushesPer = 1;
        int distinctCount = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            
            if (distinctCount > 0 && distinctCount % 8 == 0) {
                pushesPer++;
            }
            
            // Multiply the letter's frequency by its push cost
            totalPushes += freq[i] * pushesPer;
            distinctCount++;
        }
        
        return totalPushes;
    }
}
