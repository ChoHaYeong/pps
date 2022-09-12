package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1788 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] D = new int[Math.abs(N)+1];

        if(N  == 0){
            System.out.println(0);
            System.out.println(0);
            return ;
        }

        if(N > 0) {
            D[0] = 0;
            D[1] = 1;
            for(int i=2; i<=N; i++) {
                D[i] = (D[i-1] + D[i-2]) % 1000000000;
            }
        }

        else {
            D[0] = 0;
            D[1] = 1;

            for(int i=2; i<=Math.abs(N); i++) {
                D[i] = (D[i-2] - D[i-1]) % 1000000000;
            }
        }
        if(D[Math.abs(N)] < 0){
            System.out.println(-1);
            System.out.println(Math.abs(D[Math.abs(N)]) % 1000000000);
        }

        if(D[Math.abs(N)] > 0){
            System.out.println(1);
            System.out.println(Math.abs(D[Math.abs(N)]) % 1000000000);
        }
    }
}
