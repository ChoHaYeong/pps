package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[21];
        int[] P = new int[21];
        int[] D = new int[21];

        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }   
        int max = 0;
        for(int i=1; i<=N+1; i++) {

            D[i] = Math.max(max, D[i]);

            //if(i+T[i] <= N) {
            D[i+T[i]] = Math.max(D[i+T[i]], D[i]+P[i]);
            //} 

            max = Math.max(max, D[i]);
            System.out.println(i + " : " + max + " , " + D[i]);
        //    else break;
        }

        for(int i=1; i<=N+1; i++) {
            System.out.println(i + " : " + D[i]);
        //    else break;
        }

        System.out.println(max);
    }
}

