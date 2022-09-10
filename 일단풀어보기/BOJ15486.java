package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+51];
        int[] P = new int[N+1001];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[N+2];
        int max = 0;
        for(int i=1; i<=N+1; i++) {
            D[i] = Math.max(max, D[i]);
            //System.out.print(i+"일 차 => " + D[i] + " / ");
            if(i+T[i] <= N+1){
                D[i+T[i]] = Math.max(D[i] + P[i], D[i+T[i]]); //지금까지 번돈과 벌어들일 돈 
               // System.out.println((i+T[i]) + "일 차 => " + D[i+T[i]]);
            }
            max = Math.max(max, D[i]);
        }

        System.out.println(max);
    }
}
