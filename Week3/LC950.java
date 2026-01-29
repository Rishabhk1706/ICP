import java.util.*;

public class LC950 {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=deck.length-1;i>=0;i--){
            if(!dq.isEmpty()){
                dq.addFirst(dq.removeLast());
            }
            dq.addFirst(deck[i]);
        }
        int[] res = new int[deck.length];
        int i=0;
        for(int card : dq){
            res[i++] = card;
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
        int[] ans = deckRevealedIncreasing(arr);
        for(int i : ans) System.out.print(i+" ");
        System.out.println();
        sc.close();
    }
}
