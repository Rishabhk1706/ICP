import java.util.Scanner;

public class LC1823 {
    public static int helper(int n,int k){
        if(n==1) return 0;
        int x = helper(n-1,k);
        x=(x+k)%n;
        return x;
    }
    public static int findTheWinner(int n, int k) {
        return helper(n,k)+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findTheWinner(n,k));
        sc.close();
    }
}
