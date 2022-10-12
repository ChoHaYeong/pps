package codeplusDP_part1;

import java.io.*;
import java.util.*;

public class BOJ2294 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];

        for(int i=1; i<=n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        int[] D = new int[k+1];
        Arrays.fill(D, Integer.MAX_VALUE);
        D[0] = 0;

        for(int i=1; i<=k; i++) {
            for(int j=1; j<=n; j++) {
                if(i - coin[j] >= 0 && D[i-coin[j]] != Integer.MAX_VALUE) {
                    if(D[i] == -1 || D[i] > D[i-coin[j]] +1 )
                        D[i] = D[i-coin[j]] + 1;
                }
                //System.out.println(i + " ) " + D[i]);
            }
        }

        if(D[k] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(D[k]);

    }
}


