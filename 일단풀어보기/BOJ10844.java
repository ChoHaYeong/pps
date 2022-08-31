package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][10]; //D[i][j] i번째 자릿수의 자릿값이 j일 때 계단수인 경우의 수

        //if()
        for(int i=1; i<10; i++)
            D[1][i] = 1 % 1000000000;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {
                if(j == 0)
                    D[i][j] = (D[i-1][j+1]) % 1000000000;
                else if(j == 9)
                    D[i][j] = (D[i-1][j-1]) % 1000000000;
                else
                    D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) %1000000000;
            }
        }

        long sum = 0;
        for(int i=0; i<10; i++)
            sum += D[n][i];
        System.out.println(sum);


        
    }
    
}
