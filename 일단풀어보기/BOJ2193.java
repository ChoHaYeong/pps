package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][3];

        D[1][0] = 1; //1번째 자릿수의 자릿값이 0인 경우는 1가지이다 
        D[1][1] = 1; //1번째 자릿수의 자릿값이 1인 경우는 1가지이다.

        for(int i=2; i<=n; i++) {
            // for(int j=0; j<2; i++) {
            //     if(j == 0)
            if(i == n)
                D[i][0] = 0;
            else
                D[i][0] = D[i-1][0] + D[i-1][1];

            D[i][1] = D[i-1][0];
            // }
        }

        System.out.println(D[n][1]);
    }
}
