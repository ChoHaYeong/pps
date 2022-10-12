package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {
    static int[] a;
    static boolean[][] D;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a = new int[N+1];
        D = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) 
            a[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(go(S, E)) System.out.println(1);
            else System.out.println(0);
        }
        
    }

    static boolean go(int S, int E) {
        if(S == E) return true; //길이가 1
        if(S+1 == E) {
            if(a[S] == a[E]) return true;
            else return false;
        }
        if(D[S][E]) return D[S][E];

        if(a[S] != a[E]) return D[S][E] = false;
        else return D[S][E] = go(S+1, E-1);

    }
}
