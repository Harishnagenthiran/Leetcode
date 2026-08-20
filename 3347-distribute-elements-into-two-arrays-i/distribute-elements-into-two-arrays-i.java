class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        int i = 0;
        int j = 0;

        // First element goes to arr1
        arr1[i++] = nums[0];

        // Second element goes to arr2
        arr2[j++] = nums[1];

        // Process remaining elements
        for (int k = 2; k < n; k++) {

            if (arr1[i - 1] > arr2[j - 1]) {
                arr1[i++] = nums[k];
            } else {
                arr2[j++] = nums[k];
            }
        }

        // Combine arr1 + arr2
        int[] res = new int[n];

        int index = 0;

        for (int x = 0; x < i; x++) {
            res[index++] = arr1[x];
        }

        for (int x = 0; x < j; x++) {
            res[index++] = arr2[x];
        }

        return res;
    }
}