package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+1];
        int[] S = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            S[i] = Integer.parseInt(st.nextToken());
        
        D[1] = S[1];
        D[1] = 1;
        int max = 0;
        for(int i=2; i<=n; i++) {
            // D[i] = Math.max(D[i-1], S[i]);
            // if(D[i-1] != D[i]) cnt++;
            D[i] = 1;
            for(int j=1; j<i; j++) {
                if(S[j] < S[i] && D[i] < D[j]+1)
                    D[i] = D[j] +1;
            }

            if(max < D[i])
                max = D[i];

        }
       
        System.out.println(max);
    }
}
