import java.util.*;
import java.io.*;

class LikeHorse {
    int x; 
    int y;
    int cnt;

    LikeHorse(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class BOJ1600 {
    static int K, W, H;
    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new int[H][W][K+1];

        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(visited[i][j],   -1);
            }
        }

        bfs(0,0);
    }   

    static void bfs(int x, int y) {
        boolean flag = false;
        Queue<LikeHorse> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};

        queue.add(new LikeHorse(x, y, 0));
        visited[x][y][0] = 0;

        while(!queue.isEmpty()) {
            LikeHorse out = queue.poll();
            //System.out.println(out.x + " , " +  out.y + " queue에서 뺀것")
            if(out.x == H-1 && out.y == W-1) {
                System.out.println(visited[out.x][out.y][out.cnt]);
                flag = true;
                return ;
            }

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx <0 || ny < 0|| nx >= H || ny >= W) continue;
                if(map[nx][ny] == 1) continue;
                if(visited[nx][ny][out.cnt] > -1) continue;
               // if(K <= out.cnt) continue;

                queue.add(new LikeHorse(nx, ny, out.cnt));
                visited[nx][ny][out.cnt] = visited[out.x][out.y][out.cnt] + 1;
                System.out.println(nx + " , " + ny + " 거리 :  " + visited[nx][ny][out.cnt] +" (일반)");

            }

            if(out.cnt < K) {
                for(int i=0; i<8; i++) {
                    int nx = out.x + hx[i];
                    int ny = out.y + hy[i];

                    if(nx <0 || ny < 0|| nx >= H || ny >= W) continue;
                    if(map[nx][ny] == 1) continue;
                    if(visited[nx][ny][out.cnt+1] > -1) continue;
                    if(K <= out.cnt) continue;

                    queue.add(new LikeHorse(nx, ny, out.cnt+1));
                    visited[nx][ny][out.cnt+1] = visited[out.x][out.y][out.cnt] + 1;
                    System.out.println(nx + " , " + ny + " 거리 :  " + visited[nx][ny][out.cnt] + " (말)");
                }
            }
            // else { //K번보다 많이 말처럼 이동해서 더이상 말처럼 이동할 수 없음 

            //     for(int i=0; i<4; i++) {
            //         int nx = out.x + dx[i];
            //         int ny = out.y + dy[i];

            //         if(nx <0 || ny < 0|| nx >= H || ny >= W) continue;
            //         if(map[nx][ny] == 1) continue;
            //         if(visited[nx][ny][out.cnt] > -1) continue;
            //        // if(K <= out.cnt) continue;

            //         queue.add(new LikeHorse(nx, ny, out.cnt));
            //         visited[nx][ny][out.cnt] = visited[out.x][out.y][out.cnt] + 1;
            //         System.out.println(nx + " , " + ny + " 거리 :  " + visited[nx][ny][out.cnt] +" (일반)");

            //     }

            // }
        }

        if(!flag)
            System.out.println(-1);
        return ;
    }
    
}
