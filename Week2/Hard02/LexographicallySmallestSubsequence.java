import java.util.*;
public class LexographicallySmallestSubsequence {
    public static String helper(String s,int k,char letter,int repetition){
        int lc=0;
        for(char c : s.toCharArray()){
            if(c==letter) lc++;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(!st.isEmpty() && st.peek()>ch && s.length()-i>k-st.size()){
                if(st.peek()!=letter){
                    st.pop();
                }
                else if(lc > repetition){
                    st.pop();
                    repetition++;
                }
                else break;
                
            }
            if(st.size()<k){
                if(ch==letter){
                    st.push(ch);
                    repetition--;
                }
                else if(k-st.size() > repetition){
                    st.push(ch);
                }
            }
            if(ch==letter) lc--;
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
        String n = sc.next();
        int k = sc.nextInt();
        char letter = sc.next().charAt(0);
        int repetition = sc.nextInt();
        System.out.println(helper(n,k,letter,repetition));
        sc.close();
    }
}
