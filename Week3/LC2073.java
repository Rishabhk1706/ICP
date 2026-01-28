import java.util.*;

public class LC2073 {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        int goal=tickets[k];
        for(int i=0;i<tickets.length;i++){
            if(i<=k) time+=Math.min(tickets[i],goal);
            else time+=Math.min(tickets[i],goal-1);
        }
        return time;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(timeRequiredToBuy(arr,k));
        sc.close();
    }
}
