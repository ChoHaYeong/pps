import java.util.*;
import java.io.*;

public class BOJ13549 {
    static int N, K;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈이의 현재위치
        K = Integer.parseInt(st.nextToken()); // 동생의 현재위치

        visited = new boolean[100001];
        dist = new int[100001];


        bfs(N);
    }

    static void bfs(int curr) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(curr);
        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            //System.out.println(out);
            //visited[out] = true;

            if(out == K){
                System.out.println(dist[out]);
                return ;
            }

            int[] move = {out, -1, 1};
            for(int i=0; i<3; i++) {
                int next = out + move[i];

                if(next < 0 || next > 100000) continue;
                else if( visited[next]) continue;
                else {
                    if(i != 0) { //순간이동하는 경우 아니면
                        queue.offer(next);
                        visited[next] = true;
                        if(dist[next] != 0)
                            dist[next] = Math.min(dist[next], dist[out]+1);
                        else
                            dist[next] = dist[out] + 1;

                        //System.out.println(next + " . " + out);
                    }
                    else { 
                        queue.addFirst(next);
                        visited[next] = true;
                        if(dist[next] != 0)
                            dist[next] = Math.min(dist[next], dist[out]);
                        else
                            dist[next] = dist[out];
                    }
                }

            }
        }

        return ;
    }
}
