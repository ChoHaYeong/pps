package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) { //nCr = n-1Crn-1 + n-1Cr , nC0 = 1 nCn = 1
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            long[][] D = new long[N+1][N+1];
            D[0][0] = 1;

            for(int j=0; j<=N; j++){
                //for(int k=1; k<=M; k++) {
                    D[j][0] = 1;
                    D[j][j] = 1; 
                //}
            }


            for(int j=1; j<=N; j++){
                for(int k=1; k<=M; k++) {
                    // if(k == j)
                    //     D[j][k] = 1;
                    // else
                        D[j][k] = D[j-1][k-1] + D[j-1][k];
                }
            }

            System.out.println(D[N][M]);
        }
    }
}
