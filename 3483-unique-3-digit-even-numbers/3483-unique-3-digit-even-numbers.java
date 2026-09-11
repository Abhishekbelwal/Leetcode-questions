class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Given digits ki frequency
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        // Saare 3-digit numbers check karo
        for (int num = 100; num <= 998; num += 2) {

            int ones = num % 10;
            int tens = (num / 10) % 10;
            int hundreds = num / 100;

            int[] used = new int[10];

            used[hundreds]++;
            used[tens]++;
            used[ones]++;

            boolean possible = true;

            for (int i = 0; i <= 9; i++) {
                if (used[i] > freq[i]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}