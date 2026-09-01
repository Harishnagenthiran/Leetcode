class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litterIndex[i][j] = bit number of litter at (i,j)
        int[][] litterIndex = new int[m][n];

        int startRow = 0;
        int startCol = 0;
        int litterCount = 0;

        // Find starting position and assign an index to every litter.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                }
                else if (ch == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter to collect.
        if (litterCount == 0) {
            return 0;
        }

        /*
         * State:
         *
         * row
         * col
         * energy
         * mask
         *
         * visited[row][col][energy][mask]
         */
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        /*
         * Queue element:
         * [row, col, currentEnergy, mask]
         */
        Queue<int[]> queue = new LinkedList<>();

        /*
         * Suppose there are 3 litter:
         *
         * litter 0
         * litter 1
         * litter 2
         *
         * Initial mask:
         *
         * 111
         *
         * 1 = litter still needs to be collected
         */
        int startMask = (1 << litterCount) - 1;

        queue.offer(new int[]{
                startRow,
                startCol,
                energy,
                startMask
        });

        visited[startRow][startCol][energy][startMask] = true;

        // Up, right, down, left
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level.
            while (size-- > 0) {

                int[] state = queue.poll();

                int row = state[0];
                int col = state[1];
                int currentEnergy = state[2];
                int mask = state[3];

                // mask == 0 means all litter has been collected.
                if (mask == 0) {
                    return moves;
                }

                /*
                 * No energy means we cannot move anymore.
                 *
                 * If we were standing on R, energy would already
                 * have been reset to maximum.
                 */
                if (currentEnergy == 0) {
                    continue;
                }

                // Try all 4 directions.
                for (int d = 0; d < 4; d++) {

                    int newRow = row + dr[d];
                    int newCol = col + dc[d];

                    // Outside grid
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[newRow].charAt(newCol) == 'X') {
                        continue;
                    }

                    /*
                     * Normally moving costs 1 energy.
                     *
                     * But if we move onto R, energy becomes
                     * maximum energy.
                     */
                    int newEnergy;

                    if (classroom[newRow].charAt(newCol) == 'R') {
                        newEnergy = energy;
                    }
                    else {
                        newEnergy = currentEnergy - 1;
                    }

                    /*
                     * Initially keep the same mask.
                     */
                    int newMask = mask;

                    /*
                     * If we reached litter:
                     *
                     * Example:
                     * mask = 111
                     *
                     * reached litter #1
                     *
                     * new mask = 101
                     */
                    if (classroom[newRow].charAt(newCol) == 'L') {

                        int litterBit = litterIndex[newRow][newCol];

                        newMask = newMask & ~(1 << litterBit);
                    }

                    /*
                     * Have we already visited this EXACT state?
                     */
                    if (!visited[newRow][newCol][newEnergy][newMask]) {

                        visited[newRow][newCol][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                                newRow,
                                newCol,
                                newEnergy,
                                newMask
                        });
                    }
                }
            }

            // One BFS level = one move.
            moves++;
        }

        // All possible states exhausted.
        return -1;
    }
}