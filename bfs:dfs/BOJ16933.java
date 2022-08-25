import java.io.*;
import java.util.*;

class Wall {
    int x, y; //현재 map의 위치
    int cnt; //지금까지 부순 벽의 개수
    int day; //낮이면 1(true), 밤이면 0(false)

    Wall(int x, int y, int cnt, int day) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.day = day;
    }
}

public class BOJ16933 {
    static int N, M, K;
    static int[][] map;
    static int[][][][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K+1][2];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }

        bfs(0,0);
    }

    static void bfs(int x, int y) {
        ArrayDeque<Wall> queue = new ArrayDeque<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new Wall(x, y, 0, 1));
        dist[x][y][0][1] = 1;

        while(!queue.isEmpty()) {
            Wall out = queue.poll();

            if(out.x == N-1 && out.y == M-1) {
                System.out.println(dist[out.x][out.y][out.cnt][out.day]);
                return ;
            }

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 0) {
                    int nt = 1-out.day;
                    if(dist[nx][ny][out.cnt][nt] > 0) continue;

                    dist[nx][ny][out.cnt][nt] = dist[out.x][out.y][out.cnt][out.day] + 1;
                    queue.add(new Wall(nx, ny, out.cnt, nt)); //부순 벽의 개수는 그대로
                } else { //벽일 때

                    if(K == out.cnt) continue;
                    if(out.day == 1) { // 낮이면

                        int nt = 1-out.day;
                        int cnt = out.cnt + 1;
                        if(dist[nx][ny][cnt][nt] > 0) continue;

                        dist[nx][ny][cnt][nt] = dist[out.x][out.y][out.cnt][out.day] + 1;
                        queue.add(new Wall(nx, ny, cnt, nt));

                    } else if(out.day == 0 ) { //밤이면
                        int nt = 1-out.day;
                        if(dist[out.x][out.y][out.cnt][nt] > 0) continue;

                        dist[out.x][out.y][out.cnt][nt] = dist[out.x][out.y][out.cnt][out.day] + 1 ;
                        queue.add(new Wall(out.x, out.y, out.cnt, nt));
                    }

                    //queue.add(new Wall(nx, ny, out.cnt+1, nt));

                }
            }
        }

        System.out.println(-1);
        return ;
    }
}
