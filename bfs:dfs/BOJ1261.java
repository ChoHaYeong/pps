import java.util.*;
import java.io.*;

public class BOJ1261 {
    static int[][] maze, dist;
    static int M, N, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cnt = 0;

        maze = new int[N][M];
        dist = new int[N][M];

        for(int j=0; j<dist.length; j++) {
            Arrays.fill(dist[j], -1);
        }

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(Character.toString(str.charAt(i)));
            }
        }

        bfs(0,0);

    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        Queue<Position> result = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new Position(x, y));
        dist[x][y] = 0;

        while(!queue.isEmpty()) {
            Position out= queue.poll();

            if(out.x == N-1 && out.y == M-1){

                 System.out.println(cnt);
                System.out.println(dist[out.x][out.y] + 1);
                return ;
            }

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                else if(dist[nx][ny] >= 0) continue;
                else {
                    queue.add(new Position(nx, ny));
                    dist[nx][ny] = dist[out.x][out.y] + 1;

                    if(maze[nx][ny] == 1)
                        cnt++;
                }

            }
        }

        System.out.println(cnt);
    }

}