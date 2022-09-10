package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14225 {
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        arr = new int[S];

        StringTokenizer st = new StringTokenizer(br.readLine());

       // int sum = 0;
        for(int i=0; i<S; i++){
            arr[i] = Integer.parseInt(st.nextToken());
           // sum += arr[i];
        }

        visited = new boolean[2000001];
        for(int i=1; i<=S; i++) 
            dfs(0, 0, i);

        for(int i=1; i<2000001; i++)
            if(!visited[i]){
                System.out.println(i);
                return ;
            }
    }

    static void dfs(int curr, int sum, int depth) {
        if(curr == depth){
            visited[sum] =  true;
            return ;
        }

        dfs(curr+1, sum + arr[curr], depth);
        dfs(curr+1, sum, depth);
    }
}
