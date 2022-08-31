package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] D = new long[N+1][11];
        for(int i=0; i<10; i++)
            D[1][i] = 1; //1번째 자릿수에 숫자가 오는 경우의 수는 1

        for(int i=2; i<=N; i++) {
            for(int j=0; j<10; j++) { // i번째 자릿수의 자릿값이 j인 경우 
                for(int k=j; k<10; k++) // j ~9 까지 더해가기 
                    D[i][j] = (D[i][j] + D[i-1][k]) % 10007;
            }
        }

        long sum = 0;
        for(int i=0; i<10; i++)
            sum += D[N][i];
        System.out.println(sum % 10007);
    }
}
