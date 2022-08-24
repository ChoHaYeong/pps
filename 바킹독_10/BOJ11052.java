package 바킹독_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    static int N;
    static int[] P, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = new int[N+1];
        D = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++)
            P[i] = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                D[i] = Math.max(P[j] + D[i-j], D[i]);
            }
        }

        System.out.println(D[N]);
    }
    
}
