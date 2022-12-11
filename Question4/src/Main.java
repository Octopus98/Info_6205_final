public class Main {
    //time O(m*n)
    //space O(m*n)
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 & j == 0) continue;
                if (obstacleGrid[i][j] == 1) continue;
                if (i == 0){
                    dp[i][j] = dp[i][j-1];
                }
                else if (j == 0){
                    dp[i][j] = dp [i-1][j];
                }
                else {
                    dp [i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        System.out.println(dp[m-1][n-1]);
    }
}
