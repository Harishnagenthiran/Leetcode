class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int premin[] = new int[n];
        premin[n-1]=nums[n-1];
        for(int i = n-2;i>=0;i--){
            premin[i]= Math.min(premin[i+1],nums[i]);
        }
        int premax = 0;
        for(int i =0;i<nums.length;i++){
            premax= Math.max(premax,nums[i]);
            int stable = premax-premin[i];
            if(stable<=k)return i;
        }
        return -1;
        
    }
}