package Week1.PS2;

import java.util.Scanner;

public class SearchInsertPosition {
    private static int search(int[] nums, int target){
        int l=0;
        int r=nums.length-1;
        int pos=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                pos=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return pos+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(search(arr,target));
        sc.close();
    }
}
