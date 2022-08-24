package 바킹독_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    static int T, N;
    static int[][] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        fibo = new int[41][2];

        fibo[0][0] = 1; 
        fibo[0][1] = 0;

        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for(int k=0; k<T; k++) {
            N = Integer.parseInt(br.readLine());

            for(int i=2; i<=N; i++) {
                fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
                fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
            }

            System.out.println(fibo[N][0] + " " + fibo[N][1]);
        }

    }
    
}
