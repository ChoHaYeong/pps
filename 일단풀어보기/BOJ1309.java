package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][3];
        D[1][0] = 1; //해당 줄에 사자를 아예 넣지 않은 경우
        D[1][1] = 1;
        D[1][2] = 1;

        for(int i=2; i<=n; i++){
            D[i][0] =( D[i-1][0] + D[i-1][1] + D[i-1][2]) % 9901;
            D[i][1] =( D[i-1][0] + D[i-1][2]) % 9901;
            D[i][2] =( D[i-1][0] + D[i-1][1]) % 9901;
        }
        
        System.out.println((D[n][0] + D[n][1] + D[n][2]) % 9901);
    }
}
