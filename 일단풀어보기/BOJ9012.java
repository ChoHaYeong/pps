package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            
            for(int j=0; j<str.length(); j++) {
                if(stack.isEmpty() || str.charAt(j) == '(') stack.push(str.charAt(j));
                if(!stack.isEmpty() && stack.peek() == '(' && str.charAt(j) == ')') stack.pop();
                // if(!stack.isEmpty())
                //     System.out.println("-> " + stack.peek());
            }

            if(!stack.isEmpty()) System.out.println("NO");
            else System.out.println("YES");
        }
    }
    
}
