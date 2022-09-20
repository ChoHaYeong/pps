package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {
    static int V, E, K;
    static class Node implements Comparable<Node>{
        int val, weight;
        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.weight - o.weight;
           // return 0;
        }
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=V; i++)
            list.add(new ArrayList<>());

        K = Integer.parseInt(br.readLine()); //시작점 번호

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            // u에서 v로 가는 가중치 w인 간선
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, weight));
        }

        dijkstra(K);

        for(int i=1; i<=V; i++) {
            if(dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    static void dijkstra(int x) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V+1];
        queue.add(new Node(x, 0));
        dist[x] = 0;
        visited[x] = true;

        while(!queue.isEmpty()) {
            Node out = queue.poll();
            if(visited[out.val]) continue;
            for(Node l : list.get(out.val)) {
                if(dist[out.val] + l.weight < dist[l.val]) { // dist[out.val] + out.weight < dist[l.val]가 아님 out ~ l 까지의 가중치를 더해야 하는 것이기 때문에 dist[out.val] + l.weight < dist[l.val]
                    dist[l.val] = dist[out.val] + l.weight;
                    queue.add(new Node(l.val, dist[l.val]));
                }
            }
        }
    } 
}
