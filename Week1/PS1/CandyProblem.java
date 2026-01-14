package Week1.PS1;
import java.util.*;
public class CandyProblem {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(sc.nextInt());
        }
        System.out.println(Math.min(set.size(),n/2));
        sc.close();
    }
}
//leetcode 575