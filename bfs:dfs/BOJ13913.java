import java.util.*;
import java.io.*;

public class BOJ13913 {
    static int N, K;

    static boolean[] visited;
    static int[] dist, parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        visited = new boolean[100001];
        dist = new int[100001];
        parent = new int[100001];
        
        if(N == K){
            System.out.println(0);
            System.out.println(N);
        }
        else
            bfs(N);
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        int[] arr = new int[1000001];
        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            int out = queue.poll();

            // if(out == K){
            //     System.out.println(dist[out]);
            //     return ;
            // }

            int[] move = {-1, 1, out};
            for(int i=0; i<3; i++) {
                int next = out + move[i];

                if(next < 0 || next>100000) continue;
                else if(visited[next]) continue;
                else {
                    queue.add(next);
                    visited[next] = true;

                    if(dist[next] != 0)
                        dist[next] = Math.min(dist[next], dist[out]+1);
                    else 
                        dist[next] = dist[out] + 1; 
                        
                    parent[next] = out; //parent[next]로 이동하기 직전 위치
                    
                    if(next == K)
                        System.out.println(dist[next]);
                }
            }
        }
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue2.add(K);
        while(queue2.peek() != N) {
            queue2.addFirst(parent[queue2.peek()]);
        }

        for(int q:queue2) {
            System.out.print(q + " ");
        }
    }
}
