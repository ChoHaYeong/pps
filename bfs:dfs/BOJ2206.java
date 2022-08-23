

import java.util.*;
import java.io.*;

class Wall {
    int x, y; //현재 map의 위치
    boolean change; //지금까지 벽을 부순적 있는지

    Wall(int x, int y, boolean change) {
        this.x = x;
        this.y = y;
        this.change = change;
    }
}

public class BOJ2206 {
    static int N, M, r_min = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][][] dist; //거리를 나타냄
    static boolean[][][] visited; 
    static boolean flag ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];
        visited = new boolean[N][M][2];

        int count = 0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }


       // for(int i=0; i<count; i++) { //벽의 개수만큼 

        // for(int j=0; j<N; j++) {
        //     for(int k=0; k<M; k++) {
        bfs(0, 0); //bfs(j, k) 가 아님,


        
    }

    static void bfs(int x, int y) {
        /*
         * BFS 탐색 조건은 다음과 같다.
         * 
            벽이 아니면
            부신 벽이 여태까지 없었으면 -> visited[?][?][0] 방문 처리 + queue에 넣음
            벽을 한번 부신 적이 있으면 -> visited[?][?][1] 방문 처리 + queue에 넣음
            벽이면
            한번도 벽을 부신 적이 없으면 부수고 -> visited[?][?][1] 방문 처리 + queue에 넣음
         */
        Queue<Wall> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean flag = false;

       // queue.add(new Position(x, y));
        if(map[x][y] == 0){ //벽이 아니면
            visited[x][y][0] = true;
            queue.add(new Wall(x, y, false));

        } else {  //벽이면
            //부수고
            map[x][y] = 0;
            visited[x][y][1] = true;
            queue.add(new Wall(x, y, true)); //

        }

        while(!queue.isEmpty()) {
            Wall out = queue.poll();

            if(out.x == N-1 && out.y == M-1){
                //{
                if(out.change)
                    System.out.println(dist[out.x][out.y][1] + 1);
                else
                    System.out.println(dist[out.x][out.y][0] + 1);
                // System.out.println(Math.min(dist[out.x][out.y][0] + 1, dist[out.x][out.y][1] + 1));
                flag = true;
                return ;
               // }
            }
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                else if(map[nx][ny] == 0) { //벽이 아닐 때
                    if(!out.change && !visited[nx][ny][0]) { //벽을 부순적이 없다면
                        visited[nx][ny][0] = true;
                        queue.add(new Wall(nx, ny, out.change));
                        dist[nx][ny][0] = dist[out.x][out.y][0] + 1;
                    } 
                    if(out.change && !visited[nx][ny][1]) { //벽을 부순적이 있다면
                        visited[nx][ny][1] = true;
                        queue.add(new Wall(nx, ny, out.change));
                        dist[nx][ny][1] = dist[out.x][out.y][1] + 1;
                    }
                } 
                else if(map[nx][ny] == 1) { //벽일 떄
                    if(!out.change && !visited[nx][ny][0]) { //벽을 부순적이 없으면
                       // map[nx][ny] = 0;
                        visited[nx][ny][1] = true;
                        queue.add(new Wall(nx, ny, true));
                        dist[nx][ny][1] = dist[out.x][out.y][0] + 1;
                    }
                }
            }
        }

        if(!flag)
            System.out.println(-1);
    }

    
}
