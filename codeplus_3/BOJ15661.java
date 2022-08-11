package codeplus_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15661 {
    static int N, min = Integer.MAX_VALUE;
    static int[][] S;
    static boolean[] visited;
    static int[] s_arr;
    static int[] l_arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];
        s_arr = new int[N/2];
        l_arr = new int[N];

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            l_arr[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);
        
    }

    static void dfs(int depth) {
        if(depth == N/2) {
            int[] l_arr = new int[N];
            int s_sum = 0; //스타트팀의 능력치
            int l_sum = 0;

            int idx = 0;

           
            // for(int a: s_arr) {
            //     for(int a2: s_arr) {
            //         s_sum += S[a][a2];
            //     }
            // }

            //visited가 true면 링크팀임 ..
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {

                    if(visited[i] && visited[j])
                        s_sum += S[i][j];
                }
            }

            //visited가 false면 링크팀임 ..
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {

                    if(!visited[i] && !visited[j])
                        l_sum += S[i][j];
                }
            }

            min = Math.min(min, Math.abs(s_sum - l_sum));
            return ;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                //s_arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
    
}
