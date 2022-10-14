

import java.util.*;
import java.io.*;


public class BOJ2206 {
    static int N,M;
    static int[][] map;
    static int[][][] dist;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Wall {
        int x, y, broken;
        Wall(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];


        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                Arrays.fill(dist[i][j], -1);
            }
        }

        bfs();



    }

    static void bfs() {
        Queue<Wall> queue = new LinkedList<>();
        if(map[0][0] == 0) {
            queue.add(new Wall(0, 0, 0));
            dist[0][0][0] = 0;
        }
        if(map[0][0] == 1) {
            queue.add(new Wall(0, 0, 1));
            dist[0][0][1] = 0;
        }

        while(!queue.isEmpty()) {
            Wall out = queue.poll();
            if(out.x == N-1 && out.y == M-1) break;
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && dist[nx][ny][out.broken] == -1) {
                    if(map[nx][ny] == 0 ) { //빈칸이면 항상 갈 수 있어
                        queue.add(new Wall(nx, ny, out.broken));
                        dist[nx][ny][out.broken] = dist[out.x][out.y][out.broken] + 1;
                    } 
                    else if(map[nx][ny] == 1) { //벽이라면 
                        if(out.broken == 0) { //아직 벽을 부수지 않았을 때만 가능함

                            queue.add(new Wall(nx, ny, out.broken+1));
                            dist[nx][ny][out.broken+1] = dist[out.x][out.y][out.broken] + 1;

                        } else continue;
                    }
                }
            }
        }

        int ans = Math.max(dist[N-1][M-1][0] , dist[N-1][M-1][1]);
        if(ans == -1) System.out.println(ans);
        else System.out.println(ans+1);


    }

    
}
