package 바킹독_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int N;
    static int[][] S, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        S = new int[N+1][3];
        D = new int[N+1][3];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D[1][0] = S[1][0];
        D[1][1] = S[1][1];
        D[1][2] = S[1][2];

        for(int i=2; i<=N; i++) {
            D[i][0] = S[i][0] + Math.min(D[i-1][1], D[i-1][2]);
            D[i][1] = S[i][1] + Math.min(D[i-1][0], D[i-1][2]);
            D[i][2] = S[i][2] + Math.min(D[i-1][0], D[i-1][1]);
        }

        System.out.println(Math.min(D[N][0], Math.min(D[N][1], D[N][2])));


        
    }
    
}
