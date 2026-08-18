class NumArray {
    private int prefix[];

    public NumArray(int[] nums) {
        int n = nums.length;
        prefix = new int[n];
        int sum=0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            prefix[i]=sum;
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = prefix[right];
        if(left!=0)sum-=prefix[left-1];
        return sum;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */