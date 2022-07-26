import java.util.*;
import java.io.*;

public class BOJ2644 {

    static boolean[] visited;
    static int n, p1, p2, tc;
    static int[][] chonsu;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());  //전체 사람 수
        
        visited = new boolean[n];
        chonsu = new int[n][n];
        dist = new int[n];

        st = new StringTokenizer(br.readLine()); 
        p1 = Integer.parseInt(st.nextToken()); //촌수 구해야하는 사람 1
        p2 = Integer.parseInt(st.nextToken());  // 촌수 구해야하는 사람 2

        st = new StringTokenizer(br.readLine());
        tc = Integer.parseInt(st.nextToken()); //tc명의 부모자식관계

        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); 
            int y = Integer.parseInt(st.nextToken()); 
            chonsu[x-1][y-1] = 1;
            chonsu[y-1][x-1] = 1;

        }

        bfs(p1);
    }

    static void bfs(int p1) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        visited[p1-1] = true;
        queue.add(p1-1);
        //count++;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            if(p2-1 == out) {
                System.out.println(dist[p2-1]);
                return ;
            }

            for(int i=0; i<n; i++) {
                if(!visited[i] && chonsu[out][i] == 1) {
                    //System.out.println((out+1) + " //// " + (i+1) +  " ; " + dist[i]);
                    // if(p2-1 == i) {
                    //     //System.out.println(dist[p2-1]);
                    //     return ;
                    // }
        

                    visited[i] = true;
                    queue.add(i);
                    dist[i] = dist[out] + 1;
                    //System.out.println(i + " ===> " + dist[i]);
                }
            }

        }

        System.out.println(-1);

    }
    
}
