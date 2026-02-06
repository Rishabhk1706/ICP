package Week4;
import java.util.Scanner;
import java.util.Stack;

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
}
public class NextSmallerLinkedList {
    public static int[] NextSmaller(Node head) {
        int len=0;
        Node ptr = head;
        Stack<Integer> st = new Stack<>();
        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        int[] arr = new int[len];
        len=0;
        ptr=head;
        while(ptr!=null){
            arr[len++] = ptr.val;
            ptr=ptr.next;
        }
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            int ng = (st.isEmpty()) ? -1 : st.peek();
            st.push(arr[i]);
            arr[i] = ng;
        }
        return arr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node prev = new Node(-1);
        Node ptr=prev;
        for(int i=0;i<n;i++){
            int q = sc.nextInt();
            Node newNode = new Node(q);
            ptr.next=newNode;
            ptr=ptr.next;
        }
        int[] ans = NextSmaller(prev.next);
        for(int q : ans){
            System.out.print(q+" ");
        }
        System.out.println();
        sc.close();
    }
}
