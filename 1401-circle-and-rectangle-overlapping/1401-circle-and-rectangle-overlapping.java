class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest x and y coordinates on the rectangle to the circle center
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);
        
        // Calculate the distance squared from the circle center to this closest point
        int distX = xCenter - closestX;
        int distY = yCenter - closestY;
        int distanceSquared = (distX * distX) + (distY * distY);
        
        // Compare squared distance with squared radius
        return distanceSquared <= (radius * radius);
    }
    
    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
}
