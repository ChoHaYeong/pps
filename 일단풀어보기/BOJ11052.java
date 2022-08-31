package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] P = new int[n+1];
        int[] D = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            P[i] = Integer.parseInt(st.nextToken());
        
         D[1] = 1;
       // int max = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                D[i] = Math.max(P[j] + D[i-j], D[i]); //D[i-j]할 때, D[i-j]의 최댓값이 아니라 그냥 마지막에 들어갔던 값이 들어감
                // System.out.println(i + " , " + j + "  : " + D[i]);
                // max = Math.max(max, D[i]);
                // System.out.println(max + " / D["+i+"] = "+ D[i] );
            }
        }

        System.out.println(D[n]);
    } 
}
