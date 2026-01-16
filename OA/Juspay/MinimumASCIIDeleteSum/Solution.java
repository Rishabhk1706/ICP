import java.util.*;
public class Solution {
    private static int helper(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = s1.charAt(i-1) + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int total=0;
        for(char c:s1.toCharArray()) total+=c;
        for (char c:s2.toCharArray()) total+=c;
        return total - 2*dp[n][m];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(helper(s1,s2));
        sc.close();
    }
}
