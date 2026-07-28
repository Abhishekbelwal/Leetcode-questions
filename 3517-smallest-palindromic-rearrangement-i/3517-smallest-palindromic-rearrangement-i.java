class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        
        // 1. Extract the left half of the palindromic string
        String leftHalf = s.substring(0, n / 2);
        
        // 2. Sort the left half to make it lexicographically smallest
        char[] leftChars = leftHalf.toCharArray();
        Arrays.sort(leftChars);
        String sortedLeft = new String(leftChars);
        
        // 3. Mirror the sorted left half to get the right half
        String sortedRight = new StringBuilder(sortedLeft).reverse().toString();
        
        // 4. Combine left, middle character (if length is odd), and right
        if (n % 2 == 1) {
            char middleChar = s.charAt(n / 2);
            return sortedLeft + middleChar + sortedRight;
        } else {
            return sortedLeft + sortedRight;
        }
    }
}