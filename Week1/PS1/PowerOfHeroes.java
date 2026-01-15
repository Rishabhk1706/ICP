package Week1.PS1;
import java.util.*;
public class PowerOfHeroes {
    private static int sumOfPower(int n, int[] nums){
        Arrays.sort(nums);
        long Mod = 1000000007;
        long prefix=0;
        long res=0;
        for(int i : nums){
            long sq = (long) i*i % Mod;
            res = (res + sq * (prefix + i) % Mod) % Mod;
            prefix = (prefix*2 + i) % Mod;
        }
        return (int) res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(sumOfPower(n,nums));
        sc.close();
    }
}
//LC 2681