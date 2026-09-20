class Solution {
    public int reverseDegree(String s) {
        int totalDegree = 0;
        int len = s.length(); // 1. Use length() for loop boundaries
        
        for (int i = 0; i < len; i++) {
            char currChar = s.charAt(i); // 2. Extract character
            
            // 3. Calculate reversed alphabet rank ('a'=26, 'z'=1)
            int reverseAlphabetPos = 'z' - currChar + 1; 
            
            // 4. Calculate 1-indexed position in the string
            int stringPos = i + 1; 
            
            // 5. Accumulate the product
            totalDegree += reverseAlphabetPos * stringPos;
        }
        
        return totalDegree;
    }
}
