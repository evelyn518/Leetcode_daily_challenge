class Solution {
    private int[] sums;
    private int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        if (stoneValue == null || stoneValue.length == 0) return null;
        int n = stoneValue.length;
        sums = new int[n];
        sums[n - 1] = stoneValue[n - 1];
        for (int i = n - 2; i >= 0; i--){
            sums[i] = stoneValue[i] + sums[i + 1];
        }
        
        dp = new int[n];
        
        int temp = helper(stoneValue, 0);
        if (temp > sums[0] - temp){
            return "Alice";
        }
        else if (temp == sums[0] - temp){
            return "Tie"; 
        }
        else{
            return "Bob";
        }
    }
    
    private int helper(int[] a, int idx){
        if (idx >= a.length) return 0;
       
        
        if (dp[idx] != 0) return dp[idx];
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= 3; i++){
            min = Math.min(min, helper(a, idx + i));
        }
        dp[idx] = sums[idx] - min;
        return dp[idx];
    }
}