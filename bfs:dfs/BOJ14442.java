
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
    static int N, K, M;
    static int[][] map;
    static int[][][] dist; //거리를 나타냄
    static boolean[][][] visited; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][12];
        visited = new boolean[N][M][12];


        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }

        bfs(0, 0);

    }

    static void bfs(int x, int y) {
        Queue<Wall> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean flag = false;

       // queue.add(new Position(x, y));
        if(map[x][y] == 0){ //벽이 아니면
            visited[x][y][0] = true;
            queue.add(new Wall(x, y, 0));

        } else {  //벽이
            visited[x][y][1] = true;
            queue.add(new Wall(x, y, 1)); //

        }

        while(!queue.isEmpty()) {
            Wall out = queue.poll();

            if(out.x == N-1 && out.y == M-1 ){
                System.out.println(dist[out.x][out.y][out.cnt]+1);
                flag = true;
                return ;
            }

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;


                int cnt = out.cnt;
                if(map[nx][ny] == 1)  cnt++;
                if(visited[nx][ny][cnt] || cnt > K) continue;


                visited[nx][ny][cnt] = true;
                queue.add(new Wall(nx, ny, cnt));
                dist[nx][ny][cnt] = dist[out.x][out.y][out.cnt] + 1;

                // else if(map[nx][ny] == 0) { //벽이 아닐 때 => 해당 위치에서는 벽을 부술 필요가 없음
                    
                //     visited[nx][ny][out.cnt] = true;
                //     queue.add(new Wall(nx, ny, out.cnt));
                //     dist[nx][ny][out.cnt] = dist[out.x][out.y][out.cnt] + 1;
                    
                // } 
                // else if(map[nx][ny] == 1) { //벽일 떄 => 벽을 부술 필요가 있음 (K개까지 벽을 부술수 있기 때문에 확인해보기)
                    
                //     visited[nx][ny][out.cnt+1] = true;
                //     queue.add(new Wall(nx, ny, out.cnt+1));
                //     dist[nx][ny][out.cnt+1] = dist[out.x][out.y][out.cnt] + 1;
                // }
            }
        }

        if(!flag)
            System.out.println(-1);
    }
    
}
