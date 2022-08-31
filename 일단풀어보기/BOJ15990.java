package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15990 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] D = new long[100001][4];

        D[1][1] = 1;
        D[2][2] = 1;
        D[3][1] = 1;
        D[3][2] = 1;
        D[3][3] = 1;

        for(int j=4; j<=100000; j++) {
            D[j][1] = (D[j-1][2] + D[j-1][3]) % 1000000009;
            D[j][2] = (D[j-2][1] + D[j-2][3]) % 1000000009;
            D[j][3] = (D[j-3][1] + D[j-3][2]) % 1000000009;
        }


        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            

            System.out.println((D[n][1] + D[n][2] + D[n][3] % 1000000009));
        }
    }
}
