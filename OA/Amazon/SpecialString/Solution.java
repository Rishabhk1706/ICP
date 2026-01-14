package OA.Amazon.SpecialString;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int n = num.length();
        int ans = n;
        String[] targets = {"00", "25", "50", "75"};
        for(String t : targets){
            int j = n - 1;
            while(j>=0 && num.charAt(j)!=t.charAt(1)){
                j--;
            }
            if(j<0) continue;
            int i = j-1;
            while(i>=0 && num.charAt(i)!=t.charAt(0)){
                i--;
            }
            if(i<0) continue;
            int deletions = (n-1-j) + (j-i-1);
            ans = Math.min(ans, deletions);
        }
        for(char c : num.toCharArray()){
            if(c=='0'){
                ans = Math.min(ans, n-1);
                break;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}