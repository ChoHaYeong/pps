package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ1167 {
    static int n;
    static class Node{
        int val, dist;
        Node(int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    static boolean[] visited;
    static int max= 0, max_x = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int end = Integer.parseInt(st.nextToken());

                if(end == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                list.get(start).add(new Node(end, dist));
            }

        }
        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0);
        visited = new boolean[n+1];
        visited[max_x] = true;
        dfs(max_x, 0);
        
        // for(int i=1; i<=n; i++) {
        //     visited = new boolean[n+1];
        //     visited[i] = true;
        //     dfs(i, 0);

        // }

        System.out.println(max);
    }

    static void dfs(int x, int sum) {

        for(Node l : list.get(x)) {
            
            if(!visited[l.val]) {
                visited[l.val] = true;
                dfs(l.val, sum + l.dist);
            }
        }
        if(max < sum) {
            max = sum;
            max_x = x;
        }
    }

}
