package Week2.Easy02;

import java.util.*;

public class MinimumStringLengthAfterRemovingSubstrings {
    // public static int remove(String s){
    //     Stack<Character> st = new Stack<>();
    //     for(char ch : s.toCharArray()){
    //         if(!st.isEmpty() && ((ch=='B' && st.peek()=='A') || (ch=='D' && st.peek()=='C'))){
    //             st.pop();
    //         }
    //         else{
    //             st.push(ch);
    //         }
    //     } 
    //     return st.size();
    // }

    // public static int remove(String s){
    //     StringBuilder st = new StringBuilder();
    //     for(char ch : s.toCharArray()){
    //         if(!st.isEmpty() && ((ch=='B' && st.charAt(st.length()-1)=='A') || (ch=='D' && st.charAt(st.length()-1)=='C'))){
    //             st.deleteCharAt(st.length()-1);
    //         }
    //         else{
    //             st.append(ch);
    //         }
    //     } 
    //     return st.length();
    // }

    public static int remove(String s){
        while(true){
            if(s.contains("AB")){
                s = s.replace("AB", "");
            }
            else if(s.contains("CD")){
                s = s.replace("CD", "");
            }
            else{
                break;
            }
        }
        return s.length();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(remove(s));
        sc.close();
    }
}
//LC2696