package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] S = new int[n+1];
        int[][] D = new int[3][n+1];
        for(int i=1; i<=n; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

       // D[0][1] = 0;
        D[1][1] = S[1];
        D[2][1] = 0;
        
        System.out.println( D[1][1] + " , " + D[2][1]);


        int max = Math.max(D[0][1], Math.max(D[1][1], D[2][1]));
        for(int i=2; i<=n; i++) {
            D[0][i] = Math.max(D[0][i-1], Math.max(D[1][i-1], D[2][i-1])); //oox
            D[1][i] = Math.max(D[2][i-2] ,D[1][i-2]) + S[i]; //xxoxo ooxxo
            D[2][i] = Math.max(D[0][i-1], D[1][i-1]) + S[i]; //xoo

            //if(max < Math.max(D[0][i], Math.max(D[1][i], D[2][i])))
                max = Math.max(D[0][i], Math.max(D[1][i], D[2][i]));
            // System.out.println(i );
            // System.out.println( D[1][i] + "  = " +D[2][i-2] + " , " + D[1][i-2] + " + " +  S[i]);
            // System.out.println(  D[2][i] + "  = " +D[1][i-1] +  " + " +  S[i]);
            // System.out.println();

            //Math.max(D[0][i-2], D[1][i-2]) + S[i-1] 
        }

        System.out.println(max);
    }
}
