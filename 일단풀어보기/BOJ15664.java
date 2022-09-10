package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ15664 {
    static int N, M;
    static int[] arr, n_arr;
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        n_arr = new int[M];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(0);
        set.forEach(System.out::println);
    }
    static void dfs(int curr) {
        if(curr == M) {
            StringBuilder sb = new StringBuilder();
            for(int n: n_arr)
                sb.append(n + " "); //(n + " ");
            set.add(sb.toString());
            return ;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i] && (curr==0 || (curr>0 && n_arr[curr-1] <= arr[i]))) {
                visited[i] = true;
                n_arr[curr] = arr[i];
                dfs(curr+1);
                visited[i] = false;
            }
        }
    }
    
}
