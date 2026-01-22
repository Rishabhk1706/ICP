package Week2.Hard01;
import java.util.*;
public class MinimumIncrementsOnSubarrayToFormTargetArray {
    public static int helper(int[] target){
        int ans=target[0];
        for(int i=1;i<target.length;i++){
            if(target[i]>target[i-1]){
                ans+=target[i]-target[i-1];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr));
        sc.close();
    }
}