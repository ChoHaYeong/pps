package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    static int N, max = 0;
    static int[] P;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    static void dfs(int curr, int sum, int count) {
        if(count >= N) {
            if(max <= sum)
                max = sum;
            return ;
        }
        for(int i=1; i<=N; i++) {
            // if(!visited[i]) {
            //    visited[i] = true;
            if(count+i <= N)
                dfs(curr+1, sum+P[i], count+i);
            //   visited[i] = false;
          //}
        }

    }
}
