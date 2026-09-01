import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int[][] litterId = new int[m][n];

        int startRow = 0;
        int startCol = 0;
        int count = 0;

        // Find starting position and give every L a unique bit
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                else if (cell == 'L') {
                    litterId[i][j] = count++;
                }
            }
        }

        if (count == 0) return 0;

        // visited[row][col][remainingEnergy][remainingLitterMask]
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << count];

        Queue<int[]> queue = new LinkedList<>();

        // Initially all litter is remaining
        int fullMask = (1 << count) - 1;

        queue.offer(new int[]{
                startRow,
                startCol,
                energy,
                fullMask
        });

        visited[startRow][startCol][energy][fullMask] = true;

        int[] directions = {-1, 0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int currentEnergy = current[2];
                int mask = current[3];

                // All litter collected
                if (mask == 0) {
                    return moves;
                }

                // Cannot move anymore
                if (currentEnergy == 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {

                    int newRow = row + directions[k];
                    int newCol = col + directions[k + 1];

                    // Boundary and obstacle check
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n ||
                        classroom[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    char nextCell =
                            classroom[newRow].charAt(newCol);

                    // One move consumes energy
                    int nextEnergy = currentEnergy - 1;

                    // Reset area restores full energy
                    if (nextCell == 'R') {
                        nextEnergy = energy;
                    }

                    int nextMask = mask;

                    // Collect litter
                    if (nextCell == 'L') {
                        int id = litterId[newRow][newCol];

                        // Remove this litter from mask
                        nextMask &= ~(1 << id);
                    }

                    if (!visited[newRow][newCol]
                                [nextEnergy][nextMask]) {

                        visited[newRow][newCol]
                               [nextEnergy][nextMask] = true;

                        queue.offer(new int[]{
                                newRow,
                                newCol,
                                nextEnergy,
                                nextMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}