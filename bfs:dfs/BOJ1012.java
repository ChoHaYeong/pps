import java.io.*;
import java.util.*;

public class BOJ1012 {
    /**
     * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
     * 그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50), 
     * 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 
     * 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 
     * 두 배추의 위치가 같은 경우는 없다.
     */

    static int T, N, M, K;
    static int[][] farm;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }

            int count = 0;
            for(int j=0; j<M; j++) {
                for(int k=0; k<N; k++) {
                    if(visited[j][k] == false && farm[j][k] == 1){
                        bfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int x, int y) {
        queue.add(new Position(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<4; i++) {

                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                else if(visited[nx][ny] || farm[nx][ny]  == 0) continue;
                else {
                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                }

            }
        }

    }
}
