package Week1.PS1;
import java.util.*;
public class SubarrayWithK {
    public static int subarrayatmostk(int n,int[] arr,int k){
        int ans=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        for(int j=0;j<n;j++){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>k){
                map.put(arr[i],map.get(arr[i])-1);
                if(map.get(arr[i])==0) map.remove(arr[i]);
                i++;
            }
            ans+=(j-i+1);
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
        int k = sc.nextInt();
        System.out.println(subarrayatmostk(n,arr,k) - subarrayatmostk(n,arr,k-1));
        sc.close();
    }
}
//LC 992