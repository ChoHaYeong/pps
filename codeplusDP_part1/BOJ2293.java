package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];

        for(int i=1; i<=n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        int[] D = new int[k+1];
        D[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                if(j - coin[i] >= 0) D[j] += D[j -coin[i]];
            }
        }

        System.out.println(D[k]);
    }
}
