import java.util.*;
public class SumofSubarrayMinimums {
    public static int helper(int[] arr){
        int n = arr.length;
        int MOD = 1000000007;
        int[] prevsm = new int[n];
        int[] nextsm = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
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
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
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
            long val = (long) (nextsm[i]-i) * (i-prevsm[i]) * arr[i]%MOD;
            ans = (ans+val)%MOD;
        }
        return (int) ans;
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
//LC 907