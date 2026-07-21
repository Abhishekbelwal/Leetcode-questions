import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        List<Integer> zeroGroupLengths = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            } else {
                int currentZeroCount = 0;
                while (i < s.length() && s.charAt(i) == '0') {
                    currentZeroCount++;
                    i++;
                }
                zeroGroupLengths.add(currentZeroCount);
                i--; // Step back since the for-loop will increment i again
            }
        }
        
        // 2. Find the maximum sum of any two adjacent zero blocks
        int maxZeroMerge = 0;
        for (int i = 0; i < zeroGroupLengths.size() - 1; i++) {
            int combinedZeros = zeroGroupLengths.get(i) + zeroGroupLengths.get(i + 1);
            maxZeroMerge = Math.max(maxZeroMerge, combinedZeros);
        }
        
        // 3. Result is total '1's plus the maximum zeros we can flip to '1's
        return totalOnes + maxZeroMerge;
    }
}
