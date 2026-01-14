package Week1.PS1;
import java.util.*;
public class CookieProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] greed = new int[n];
        int[] size = new int[m];
        for(int i=0;i<n;i++){
            greed[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            size[i] = sc.nextInt();
        }
        Arrays.sort(greed);
        Arrays.sort(size);
        int i=0,j=0;
        int ans=0;
        while(i<n && j<m){
            if(size[j]>=greed[i]){
                ans++;
                i++;
            }
            j++;
        }
        System.out.println(ans);
        sc.close();
    }
}
//Leetcode 455