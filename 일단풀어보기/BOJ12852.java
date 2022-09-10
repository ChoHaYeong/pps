package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];
        int[] P = new int[N+1];
        D[1] = 0;
        for(int i=2; i<=N; i++) {

            D[i] = D[i-1] + 1;
            P[i] = i-1;

            if(i % 3 == 0 && D[i/3] + 1 < D[i]){
                D[i] = D[i/3] + 1;
                P[i] = i/3;
            }
            if(i % 2 == 0 && D[i/2] + 1 < D[i]){
                D[i] = D[i/2] + 1;
                P[i] = i/2;
            }

            //System.out.println(P[i]);
        }   
        //int value = D[N];

        //System.out.println("==============================" + value);

        //for(int i=D[N]; i>0; i--) {
        // for(int i=N; i>0; i--) {
        //     if(D[i] == value){
        //         System.out.print(P[i] + " ");
        //        // stack.push(i);
        //         value--;
        //     }
        // }

        System.out.println(D[N]);
        System.out.print(N + " ");
        while(N > 1) {  
            System.out.print(P[N] + " ");
            N = P[N];
        }
        // System.out.println();
        // System.out.print(N + " ");
        // while(!stack.isEmpty())
        //     System.out.print(stack.pop() + " ");
        //System.out.print(1);
        //})
    }
    
}
