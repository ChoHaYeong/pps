package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+1];
        //int min = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {


            D[i] = Integer.MAX_VALUE;
            for(int j=1; j<=Math.sqrt(i); j++) {
                D[i] = Math.min(D[i], D[i-(j*j)]+1);
            }
            // if(i % Math.sqrt(i) == 0)
            //     D[i] = 1;
            // else
            //     D[i] = D[i-1] + 1;
            
            System.out.println(i + " : " + D[i]);
        }

        System.out.println(D[n]);
    }
}
