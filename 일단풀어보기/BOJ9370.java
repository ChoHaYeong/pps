package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ9370 {
    static class Node implements Comparable<Node> {
        int val, weight;
        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
    static int[] arrive;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0; k<T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //교차로 개수
            int m = Integer.parseInt(st.nextToken());   
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); 
            int g = Integer.parseInt(st.nextToken());   
            int h = Integer.parseInt(st.nextToken());

            for(int i=0; i<=n; i++)
                list.add(new ArrayList<>());

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); 
                int b = Integer.parseInt(st.nextToken());   
                int d = Integer.parseInt(st.nextToken());

                if((a == g && b == h) || (b == g && a == h)) {

                    list.get(a).add(new Node(b, 2*d-1));
                    list.get(b).add(new Node(a, 2*d-1));
                } else {
                    list.get(a).add(new Node(b, 2*d));
                    list.get(b).add(new Node(a, 2*d));
                }
            }

            // for(int i=1; i<=n; i++) {
            //     for(Node l : list.get(i)) System.out.print(l.val + " - " + l.weight + " / ");
            //     System.out.println();
            // }
            
            arrive = new int[t];

            for(int i=0; i<t; i++){
                st = new StringTokenizer(br.readLine());
                arrive[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrive);
            
    

            dijkstra(s, g, h, n,  arrive);
            System.out.println();


                



        }
    }

    static void dijkstra(int x, int g, int h, int n, int[] end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(new Node(x, 0));
        dist[x] = 0;


        boolean[] visited = new boolean[n+1];

        while(!queue.isEmpty()) {
            Node out = queue.poll();
            if( dist[out.val] < out.weight) continue;
            if(visited[out.val]) continue;
            visited[out.val] = true;
            for(Node l : list.get(out.val)) { 
                if( dist[l.val] > dist[out.val] + l.weight){
                    dist[l.val] = dist[out.val] + l.weight;
                    queue.add(new Node(l.val, dist[l.val]));
                }
            }
        }
        for(int e : end)
            if(dist[e] % 2 == 1) System.out.print(e + " ");
    }
    
}

// 1dist[out.val] != Integer.MAX_VALUE ||
// 6 9 2
// 2 3 1
// 1 2 1
// 1 3 3
// 2 4 4
// 2 5 5
// 3 4 3
// 3 6 2
// 4 5 4
// 4 6 3
// 5 6 7
// 5
// 6