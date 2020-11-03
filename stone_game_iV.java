class Solution {
    boolean[] dp;
    public boolean winnerSquareGame(int n) {
        dp = new boolean[n + 1];
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i * i <= n; i++){
            ls.add(i * i);
        }
        
        for (int i = 1; i <= n; i++){
            for (int x : ls){
                if (i - x < 0) break;
                if (dp[i - x] == false){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}