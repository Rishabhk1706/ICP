package Week2.Easy01;

import java.util.*;

public class MakeTheStringGreat {
    public static String Great(String s){
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && ((ch+32)==st.peek() || (ch-32)==st.peek())){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(Great(s));
        sc.close();
    }
}
//LC 1544