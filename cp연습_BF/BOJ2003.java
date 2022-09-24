package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    static int N, M, cnt= 0;
    static int[] a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) 
            go(i, 0);

        System.out.println(cnt);

    }

    static void go(int curr, int sum) {
        if(sum == M) {
            cnt++;
            return ;
        }
        if(sum > M || curr == N) return ;
        go(curr+1, sum + a[curr]);
    }
}
