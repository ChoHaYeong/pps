import java.io.*;
import java.util.*;
import java.util.ArrayDeque;

class Wall {
    int x, y; //현재 map의 위치
    int cnt; //지금까지 부순 벽의 개수
    int night; //낮이면 0(false), 밤이면 1(true)

    Wall(int x, int y, int cnt, int night) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.night = night;
    }
}

public class BOJ16933 {
    static int N, M, K;
    static int[][] map;
    static int[][][][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
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
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //bfs(0,0);

        Queue<Wall> queue = new LinkedList<>();
        queue.add(new Wall(0, 0, 0, 0));
        dist[0][0][0][0] = 1;

        while(!queue.isEmpty()) {
            Wall out = queue.remove();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx <0 || nx >=N || ny <0 || ny >= M ||  dist[nx][ny][out.cnt][1-out.night] > 0) continue;
                if(map[nx][ny] == 0 ){
                    queue.offer(new Wall(nx, ny, out.cnt, 1-out.night));
                    dist[nx][ny][out.cnt][1-out.night] = dist[out.x][out.y][out.cnt][out.night] + 1; //이동하면 낮, 밤이 바뀜
                }
                if(map[nx][ny] == 1 && out.cnt + 1 <= K && out.night == 0) {
                 //   if(out.cnt + 1 <= K && out.night == 0) { 
                        queue.offer(new Wall(nx, ny, out.cnt+1, 1-out.night));
                        dist[nx][ny][out.cnt+1][1-out.night] = dist[out.x][out.y][out.cnt][out.night] + 1; //이동하면 낮, 밤이 바뀜, 벽부순 개수도 증가함
                //    } // else하고 여기서 머무르는 로직을 세우면 안됨.
                }
            }

            if(dist[out.x][out.y][out.cnt][1-out.night] == 0){ //이동하지 않고 머무르기 => 낮, 밥만 바뀜  // 근데 여기 있으면 안됨!
                queue.offer(new Wall(out.x, out.y, out.cnt, 1-out.night));
                dist[out.x][out.y][out.cnt][1-out.night] = dist[out.x][out.y][out.cnt][out.night] + 1; //머물러도 거리는 증가하는 것임
            }
        }

        int ans = -1;
        for (int i=0; i<=K; i++) {
            for(int j=0; j<=1; j++) {
                if (dist[N-1][M-1][i][j] == 0) continue;
                if (ans == -1) {
                    ans = dist[N-1][M-1][i][j];
                } else if (ans > dist[N-1][M-1][i][j]) {
                    ans = dist[N-1][M-1][i][j];
                }
            }
            
        }
        System.out.println(ans);
    }

    static void bfs(int x, int y) {
        Queue<Wall> queue = new LinkedList<>();
        queue.add(new Wall(0, 0, 0, 0));
        dist[0][0][0][0] = 1;

        while(!queue.isEmpty()) {
            Wall out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx <0 || nx >=N || ny <0 || ny >= M) continue;
                if(map[nx][ny] == 0 && dist[nx][ny][out.cnt][1-out.night] == 0){
                    queue.add(new Wall(nx, ny, out.cnt, 1-out.night));
                    dist[nx][ny][out.cnt][1-out.night] = dist[out.x][out.y][out.cnt][out.night] + 1; //이동하면 낮, 밤이 바뀜
                }
                if(map[nx][ny] == 1 && dist[nx][ny][out.cnt][1-out.night] == 0) {
                    if(out.cnt + 1 <= K && out.night == 0) { 
                        queue.add(new Wall(nx, ny, out.cnt+1, 1-out.night));
                        dist[nx][ny][out.cnt+1][1-out.night] = dist[out.x][out.y][out.cnt][out.night] + 1; //이동하면 낮, 밤이 바뀜, 벽부순 개수도 증가함
                    } // else하고 여기서 머무르는 로직을 세우면 안됨.
                }
            }

            if(dist[out.x][out.y][out.cnt][1-out.night] == 0){ //이동하지 않고 머무르기 => 낮, 밥만 바뀜  // 근데 여기 있으면 안됨!
                queue.add(new Wall(out.x, out.y, out.cnt, 1-out.night));
                dist[out.x][out.y][out.cnt][1-out.night] = dist[out.x][out.y][out.cnt][out.night] + 1; //머물러도 거리는 증가하는 것임
            }
        }

        int ans = -1;
        for (int i=0; i<=K; i++) {
            for(int j=0; j<=1; j++) {
                if (dist[N-1][M-1][i][j] == 0) continue;
                if (ans == -1) {
                    ans = dist[N-1][M-1][i][j];
                } else if (ans > dist[N-1][M-1][i][j]) {
                    ans = dist[N-1][M-1][i][j];
                }
            }
            
        }
        System.out.println(ans);
    }
}
