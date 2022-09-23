package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int[] arr, n_arr;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            arr = new int[N];
            n_arr = new int[6];
            visited = new boolean[N];

            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            dfs(0);
            System.out.println();
        }
    }

    static void dfs(int curr) {
        if(curr == 6) {
            for(int a: n_arr)
                System.out.print(a + " ");
            System.out.println();
            return ;
        }

        for(int i=curr; i<N; i++) {
            if(!visited[i] && (curr ==0 || (curr>0 && n_arr[curr-1] <= arr[i]))) {
                visited[i] = true;
                n_arr[curr] = arr[i];
                dfs(curr+1);
                visited[i] = false;
            }
        }
    }
}
