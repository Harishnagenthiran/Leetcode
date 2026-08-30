class Solution {
    public int minimumDeletions(int[] nums) {
        int min_index =0;
        int max_index =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<nums[min_index])min_index = i;
            if(nums[i]>nums[max_index])max_index=i;
        }
        System.out.print(min_index +" "+max_index);
        int first = Math.min(min_index,max_index);
        int second = Math.max(min_index,max_index);
        int from_left = second+1;
        int from_right = nums.length - first;
        int from_bothend = (first+1)+(nums.length - second);
        return Math.min(from_left,(Math.min(from_right,from_bothend)));
    }
}