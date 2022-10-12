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
        for (int j=1; j<=n; j++) {
            for(int i=1; i<=k; i++) {
                if(i - coin[j] >= 0)
                    D[i] += D[i-coin[j]];
              //  System.out.println(i + " ) " + D[i]);
            }
        }

        System.out.println(D[k]);
    }
}
