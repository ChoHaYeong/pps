package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1495 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N+1];
        boolean[][] D = new boolean[N+1][M+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        D[0][S] = true;

        for(int i=1; i<=N; i++) {
            for(int j=0; j<=M; j++) {
                if(!D[i-1][j]) continue;
                else {
                    if(j - a[i] >= 0) D[i][j-a[i]] = true;
                    if(j + a[i] <= M) D[i][j+a[i]] = true;
                }
            }
        }

        int ans = -1;
        for(int i=M; i>=0; i--) {
            if(D[N][i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }
}
