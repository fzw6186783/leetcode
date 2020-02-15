package t5335;

import org.junit.Test;

public class Solution2 {
    public int maxStudents(char[][] seats) {
        int n = seats.length, m = seats[0].length;
        Integer[][] memo = new Integer[n][1 << m];
        return dfs(seats, memo, 0, 0);
    }

    private int dfs(char[][] seats, Integer[][] memo, int r, int preMask){
        int n = seats.length, m = seats[0].length;
        if(r == n){
            return 0;
        }
        if(memo[r][preMask] != null){
            return memo[r][preMask];
        }
        int res = 0;
        for(int i = 0 ; i < (1 << m) ;i++){
            if(isValid(i, preMask, seats, r)){
                res = Math.max(res, Integer.bitCount(i) + dfs(seats, memo, r + 1, i));
            }
        }
        memo[r][preMask] = res;
        return res;
    }

    private boolean isValid(int mask, int preMask, char[][] seats, int r){
        int n = seats.length, m = seats[0].length;
        for(int i = 0 ; i < m; i++){
            if((mask & (1 << i)) == 0){
                continue;
            }
            if (seats[r][i] == '#'){
                return false;
            }
            if(i > 0 && seats[r][i - 1] == '.' && (mask & (1 << (i - 1))) != 0){
                return false;
            }
            if(i < m - 1 && seats[r][i + 1] == '.' && (mask & (1 << (i + 1))) != 0){
                return false;
            }
            if(r > 0 && i > 0 && seats[r - 1][i - 1] == '.' && (preMask & (1 << (i - 1))) != 0){
                return false;
            }
            if(r > 0 && i < m - 1 && seats[r - 1][i + 1] == '.' && (preMask & (1 << (i + 1))) != 0){
                return false;
            }
        }
        return true;
    }
    public int maxStudents2(char[][] seats) {
        int n = seats.length, m = seats[0].length;
        int[][] dp = new int[n + 1][1 << m];
        for(int i = n - 1; i >= 0; i--){
          for(int preMask = 0; preMask < (1 << m); preMask++){
            int res = 0;
            for(int curMask = 0; curMask < (1 << m); curMask++){
              if(isValid(curMask, preMask, seats, i)){
                res = Math.max(res, Integer.bitCount(curMask) + dp[i + 1][curMask]);
              }
            }
            dp[i][preMask] = res;
          }
        }
        return dp[0][0];
      }
    @Test
    public void ss() {
    	char[][] seats= {{'.','.','.','.','#','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','#','.'},{'.','.','.','.','.','.','.','.'},{'.','.','#','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','#','.','.','#','.'}};
    System.out.println(maxStudents2(seats));

    	
    }

   
}


