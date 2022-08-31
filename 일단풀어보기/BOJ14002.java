 package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] S = new int[n+1];
        int[] D = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            S[i] = Integer.parseInt(st.nextToken());
        
        D[1] = 1;
        int max = 1;
        for(int i=2; i<=n; i++) {
            D[i] = 1;
            for(int j=1; j<i; j++) {
                if(S[j] < S[i] && D[i] < D[j] + 1){
                    D[i] = D[j] + 1;
                } 
            }
           // System.out.println("D["+i+"] = " + D[i]);
            max = Math.max(max, D[i]);
        }


        System.out.println(max);
        // for(int i=1; i<=n; i++)
        //     System.out.println("D["+i+"] = " + D[i]);
        Stack<Integer> stack = new Stack<>();

        // D[i]의 값이 같다면 거꾸로 탐색했을 때 먼저 나오는 값이 더 작은 수
        // 왜냐하면 값이 더 컸다면, D[i]의 값이 작지 않았을 것이다.
       // for(int i=max; i>0; i--) {
            for(int j=n; j>0; j--){
                if(D[j] == max){
                    stack.push(S[j]);
                    max--;
                   // break;
                }
            }
       // }

       while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}
