package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
    static int N, E;
    static class Node implements Comparable<Node>{
        int val;
        int dis;
        Node(int val, int dis) {
            this.val = val;
            this.dis = dis;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.dis - o.dis;
        }
    }
    static int[] dist;
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //거리가 c임
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }



        st = new StringTokenizer(br.readLine());
        //반드시 거쳐야 하는 두 점 (= 시작점으로 선택함)
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        long result = 0, result2 = 0;
        System.out.println(v1 + " " + v2);
        result += dijkstra(1, v1);
        result += dijkstra(v1, v2);
        result += dijkstra(v2, N);

        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);
        System.out.println(result + " / " + result2);
        if(Math.min(result, result2) >= Integer.MAX_VALUE) System.out.println(-1);
        else {
            System.out.println(Math.min(result, result2));

            //System.out.println(min);
        }
        
        
    }

    static int dijkstra(int x, int end) {
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        //boolean[] visited = new boolean[N+1];
        dist[x] = 0;
        queue.add(new Node(x, dist[x]));
        //visited[x] = true;

        while(!queue.isEmpty()) {
            Node out = queue.poll();
            //if(out.dis > dist[out.val]) continue;
           // if(visited[out.val]) continue;
           // visited[out.val] = true;
            for(Node n : list.get(out.val)) {
                if(dist[n.val] > dist[out.val] + n.dis) {
                    dist[n.val] = dist[out.val] + n.dis;
                    queue.add(new Node(n.val, dist[n.val]));
                }
            }
        }
        System.out.println("start : " + x + "dist["+end+"] = " + dist[end]);
        return dist[end];
    }
}
