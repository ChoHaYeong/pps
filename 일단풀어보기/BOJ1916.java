package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    static int N, M;
    static class Node implements Comparable<Node>{
        int val, cost;
        Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.cost - o.cost;
        }

        
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            //list.get(b).add(new Node(a, c));
        }

        // for(int i=1; i<=N; i++) {
        //         for(Node l : list.get(i)) System.out.print(l.val + " - " + l.cost + " / ");
        //         System.out.println();
        //     }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e);
    }   

    static void dijkstra(int x, int end) {
       // System.out.println(x + " " + end);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[x] = 0;
        queue.add(new Node(x, dist[x]));

        boolean[] visited = new boolean[N+1];
        //visited[x] = true;

        while(!queue.isEmpty()) {
            Node out = queue.poll();  
            if(dist[out.val] < out.cost) continue;
            if(visited[out.val]) continue;
            visited[out.val] = true;
            for(Node l : list.get(out.val)) {
                if(dist[l.val] >= dist[out.val] + l.cost){
                    dist[l.val] = dist[out.val] + l.cost;
                    queue.add(new Node(l.val, dist[l.val]));
                }
            }
        }
        System.out.println(dist[end]);
    }
}
