class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++){
            dp[i][i] = 1;
            
            if (i < n - 1){
                if (arr[i] == arr[i + 1]){
                    dp[i][i + 1] = 1;
                }
                else{
                    dp[i][i + 1] = 2;
                }
            }
        }
        
        for (int len = 3; len <= n; len ++){
            for (int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                dp[i][j]  = len;
                
                if (arr[i] == arr[j]){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                
                for (int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        
        return dp[0][n -1];
        
    }
}
