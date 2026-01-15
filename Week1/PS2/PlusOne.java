package Week1.PS2;

import java.util.*;
public class PlusOne {
    private static int[] plusOne(int n, int[] arr){
        for(int i=n-1;i>=0;i--){
            arr[i]+=1;
            arr[i]%=10;
            if(arr[i]!=0){
                return arr;
            }
        }
        int[] res = new int[n+1];
        res[0]=1;
        for(int i=0;i<n;i++){
            res[i+1]=arr[i];
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int[] ans = plusOne(n,arr);
        for(int i : ans){
            System.out.print(i+" ");
        }
        System.out.println();
        sc.close();
    }
}
