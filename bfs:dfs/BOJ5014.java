import java.util.*;
import java.io.*;

public class BOJ5014 {
    static int  F, S, G, U, D;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); //전체 층수
        S = Integer.parseInt(st.nextToken()); //현재위치
        G = Integer.parseInt(st.nextToken()); //목적지 층수
        U = Integer.parseInt(st.nextToken()); //위로 갈 수 있는 층수
        D = Integer.parseInt(st.nextToken()); //아래로 갈 수 있는 층수
        visited = new boolean[F+1];
        dist = new int[F+1];
        //System.out.println(-D);
        if(S == G){
            System.out.println(0);
            return ;
        }
        bfs(S);

    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int[] move = {U, -D};
        queue.add(x);
        visited[x] = true;
    
        while(!queue.isEmpty()) {
            int out = queue.poll();

            for(int i=0; i<2; i++) {
                int next = out + move[i];

                if(next < 1 || next > F) continue;
                else if(visited[next]) continue;
                else {
                    queue.add(next);
                    visited[next] = true;
                    dist[next] = dist[out] + 1;
                    //System.out.println("dist[next] " + dist[next]);
                    if(next == G){
                        //System.out.println(dist[next]);
                        return ;
                    }
                }

            }
        }

        System.out.println("use the stairs");
        return ;
    }
    
}
