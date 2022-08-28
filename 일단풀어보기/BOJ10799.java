package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else if(str.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
                if(i > 0 && str.charAt(i-1) == '(') ans += stack.size(); //레이저일 때 스택 사이즈 더하기
                if(i > 0 && str.charAt(i-1) == ')') ans += 1;
            }
        }

        System.out.println(ans);
    }
    
}
