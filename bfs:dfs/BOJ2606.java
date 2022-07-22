import java.io.*;
import java.util.*;

public class BOJ2606 {
    static int N, M, count = 0;
    static int[][] computer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        computer = new int[N][N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); 

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computer[x-1][y-1] = 1;
            computer[y-1][x-1] = 1;
        }

        for(int i=0; i<N; i++) {
            computer[i][i] = 1;
        }

        bfs(0);

        System.out.println(count);
    }

    static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            for(int i=0; i<N; i++) {
                if(!visited[i] && computer[out][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                    count ++;
                } else {
                    continue;
                }
            }
        }
    }
}