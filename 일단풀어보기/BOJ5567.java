package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ5567 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited, n_visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        n_visited = new boolean[n+1];

        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());
        
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            list.get(to).add(from);
            list.get(from).add(to);
        }

        dfs(0, 1);
        int ans = 0;
        for(int i=2; i<=n; i++)
            if(visited[i]) ans++;

        System.out.println(ans);


    }

    static void dfs(int curr, int x) {
        System.out.println(curr + " -> " + x);
        if(curr == 2) {

            // for(int i=1; i<=n; i++) {

            //     if(visited[i])
            //         n_visited[i] = true;
            // }
            return ;
        }

        for(int l : list.get(x)) {
            //if(!visited[l]) {
                visited[l] = true;
                dfs(curr+1, l);
               // visited[l] = false;
            //}
        }
    }
}
