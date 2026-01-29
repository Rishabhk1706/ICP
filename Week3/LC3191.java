import java.util.Scanner;

public class LC3191 {
    public static int minOperations(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1]= (nums[i+1]==0) ? 1:0;
                nums[i+2]= (nums[i+2]==0) ? 1:0;
                c++;
            }
        }
        if(nums[nums.length-2]==0 || nums[nums.length-1]==0){
            return -1;
        }
        return c;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minOperations(arr));
        sc.close();
    }
}
