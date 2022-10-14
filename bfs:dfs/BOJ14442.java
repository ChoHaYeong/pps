
import java.util.*;
import java.io.*;

class Wall {
    int x, y; //현재 map의 위치
    int cnt; //지금까지 부순 벽의 개수

    Wall(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
public class BOJ14442 {
    static int N, K, M, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][][] dist; //거리를 나타냄
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K+1];


        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        // if(min == Integer.MAX_VALUE) System.out.println(-1);
        // else System.out.println(min);

    }

    static void bfs(int x, int y) {
        Queue<Wall> queue = new LinkedList<>();

        queue.add(new Wall(0, 0, 0));
        dist[0][0][0] = 1;

        while(!queue.isEmpty()) {
            Wall out = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny >= M) continue;

                if(map[nx][ny] == 0 && dist[nx][ny][out.cnt] == 0) {
                    queue.add(new Wall(nx, ny, out.cnt)); //벽 안부수었으니 cnt는 그대로
                    dist[nx][ny][out.cnt] = dist[out.x][out.y][out.cnt] + 1;
                }
                if(out.cnt < K && map[nx][ny] == 1 && dist[nx][ny][out.cnt] == 0 ) {
                    queue.add(new Wall(nx, ny, out.cnt+1));
                    dist[nx][ny][out.cnt+1] = dist[out.x][out.y][out.cnt] + 1;
                }

                
            }
        }

        int ans = -1;
        for (int i=0; i<=K; i++) {
            if (dist[N-1][M-1][i] == 0) continue;
            if (ans == -1) {
                ans = dist[N-1][M-1][i];
            } else if (ans > dist[N-1][M-1][i]) {
                ans = dist[N-1][M-1][i];
            }
        }
        System.out.println(ans);
    }


    
}
