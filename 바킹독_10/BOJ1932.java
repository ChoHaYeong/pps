package 바킹독_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    static int N;
    static int[][] tri, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tri = new int[N+1][N+1];
        D = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        D[1][1] = tri[1][1];
        // D[2][1] = tri[1][1] + tri[2][1];
        // D[2][2] = tri[1][1] + tri[2][2];
    
        for(int i=2; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                // if(j == 1)
                //     D[i][j] = D[i-1][j] + tri[i][j];
                // else if(j == i) 
                //     D[i][j] = D[i-1][j-1] + tri[i][j];
                // else 
                    D[i][j] = Math.max(D[i-1][j], D[i-1][j-1]) + tri[i][j]; 
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            if(max < D[N][i])
                max = D[N][i];
        }

        System.out.println(max);

    }
    
}
