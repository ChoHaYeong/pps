package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] D = new int[N+1][K+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                D[i][j] = D[i-1][j] ;
                if(j - W[i] >= 0) D[i][j] = Math.max(D[i][j], D[i-1][j - W[i]] + V[i]);
                //System.out.println(i + " , " + j + " = " + D[i][j]);
            }
        }
        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, D[i][K]);
        }

        System.out.println(max);
    }
}
