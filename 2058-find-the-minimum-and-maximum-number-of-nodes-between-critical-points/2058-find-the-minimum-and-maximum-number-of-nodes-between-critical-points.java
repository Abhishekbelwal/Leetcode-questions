/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Base case: a critical point needs a previous and a next node
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;
        int firstCriticalIndex = -1;
        int prevCriticalIndex = -1;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 1; // 0-indexed tracking from the start

        while (curr.next != null) {
            ListNode nextNode = curr.next;
            
            // Check if current node is a local maxima or local minima
            boolean isLocalMaxima = curr.val > prev.val && curr.val > nextNode.val;
            boolean isLocalMinima = curr.val < prev.val && curr.val < nextNode.val;

            if (isLocalMaxima || isLocalMinima) {
                // If this is the very first critical point found
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = currentIndex;
                } else {
                    // Update the minimum distance between adjacent critical points
                    minDistance = Math.min(minDistance, currentIndex - prevCriticalIndex);
                }
                // Move the previous critical pointer to the current index
                prevCriticalIndex = currentIndex;
            }

            // Move pointers forward
            prev = curr;
            curr = nextNode;
            currentIndex++;
        }

        // If less than 2 critical points were found, return [-1, -1]
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        // Maximum distance is always between the last and the first critical point
        int maxDistance = prevCriticalIndex - firstCriticalIndex;

        return new int[]{minDistance, maxDistance};
    }
}
