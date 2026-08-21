
// Tharuni S
// 2:17 PM (1 minute ago)
// to Harish

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>(
                (a, b) -> ((a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]))
            );

        for (int[] point : points) {
            minHeap.offer(point);
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}