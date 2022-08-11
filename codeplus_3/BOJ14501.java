package codeplus_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    static int N, t, max = 0 ;
    static int[] T, P, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1]; // 1~N
        P = new int[N+1];
        arr = new int[N+1]; // 상담을 진행하는 날짜를 담는 배열 
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(t=1; t<=N; t++) {
            dfs(0, t, 0);
        }


        System.out.println(max);
    }

    static void dfs(int curr, int start, int money) {
        if(start + T[start-1]> N+1) {
           // System.out.println("base case : " + money);
            if(max < money)
                max = money;
            return ;
        }

        for(int i=start; i<=N; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(i+T[i] <= N+1){

                    arr[curr] = i;
                   // System.out.println("money : " + money + " // curr+1 " + (curr+1) + " i+T[i] " + (i+T[i])  + " money : " + (money+P[i]) );
                    dfs(curr+1, i+T[i], money+P[i]);

                   // System.out.println("====================================");
                }

                visited[i] = false;

            }
        }
        
    }
    
}
