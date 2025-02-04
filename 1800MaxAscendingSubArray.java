class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0], curSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curSum += nums[i];
            } else {
                maxSum = Math.max(maxSum, curSum);
                curSum = nums[i];
            }
        }
        return Math.max(maxSum, curSum);
    }
}
