package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] D = new long[n+1];

            for(int j=1; j<=n; j++) {
                if(j==1)
                    D[j] = 1;
                else if(j == 2)
                    D[j] = 2;
                else if(j == 3)
                    D[j] = 4;
                else
                    D[j] = (D[j-1] + D[j-2] + D[j-3]) % 1000000009;
            }

            System.out.println(D[n]%1000000009);
        }
    }
}
