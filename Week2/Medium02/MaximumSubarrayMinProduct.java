package Week2.Medium02;
import java.util.*;
public class MaximumSubarrayMinProduct{
    public static int helper(int[] nums){
        int n = nums.length;
        int MOD = 1000000007;
        int[] prevsm = new int[n];
        int[] nextsm = new int[n];
        long[] prefixsum = new long[n];
        prefixsum[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixsum[i] = prefixsum[i-1]+nums[i];
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                prevsm[i]=-1;
            }
            else{
                prevsm[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nextsm[i]=n;
            }
            else{
                nextsm[i]=st.peek();
            }
            st.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            long leftsum = (prevsm[i]<0) ? 0 : prefixsum[prevsm[i]];
            long rightsum = prefixsum[nextsm[i]-1];
            long val = (rightsum - leftsum) * nums[i];
            ans = Math.max(ans,val);
        }
        return (int) (ans%MOD);
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