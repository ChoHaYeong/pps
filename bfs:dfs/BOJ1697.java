import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int N, K, C  = 0;
    static int[] visited;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //수빈이가 있는 위치
        K = Integer.parseInt(st.nextToken()); //동생이 있는 위치
        visited = new boolean[100000];
        bfs(N);
        System.out.println(C);
    }

    static void bfs(int n) {
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()) {
            int out = queue.poll();
            int[] d = {-1, 1, out};

            for(int i=0; i<3; i++) {
                int position = out + d[i];
                System.out.println( position);
                if(position < 0 || position > 100000) continue;
                else if(visited[position]) continue;
                else if(position == K) {
                    return ;
                }
                else {
                    queue.add(position);
                    visited[position] = true;
                    if(i == 2)
                        C++;
                }
            }

        }
    }
}
