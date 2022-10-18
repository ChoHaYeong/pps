package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ1967 {
    static int n;
    static class Node{
        int val, weight;
        Node(int val, int weight) {
            this.val= val;
            this.weight = weight;
        }
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    static boolean[] visited;
    static int max = 0, answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        for(int i=0; i<n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(p).add(new Node(c, w));
            list.get(c).add(new Node(p, w));
        }
        visited = new boolean[n+1];
       
        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];

            dfs(i);
           // System.out.println(answer);
            answer = 0;
            //System.out.println(answer);
            
           
            
        }
        System.out.println(max);
    }


    static void dfs(int x){ //이렇게하면 완전탐색
        visited[x] = true;

        for(Node l : list.get(x)) {
            if(!visited[l.val]) {
                visited[l.val] = true;
                answer += l.weight;
                dfs(l.val);
                answer -= l.weight;
            }
        }

        
        max = Math.max(max, answer);
            
    }
}
