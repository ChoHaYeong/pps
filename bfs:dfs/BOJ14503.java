import java.util.*;
import java.io.*;

public class BOJ14503 {
    static int N, M, r, c, d;
    static int[][] space;
    static boolean[][] visited;
    static Queue<Mirror> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        queue.add(new Mirror(r, c, 1, d));
        visited[r][c] = true;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        int[] dx = {-1, 0, 1, 0}; //북 동 남 서
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            Mirror out = queue.poll();
            System.out.println(out.cnt);
            boolean flag = false;

            int direction = out.dir ; //(out.dir + 3)%4; //out.dir = 0이면 direction은 3
            for(int i=0; i<4; i++) {
                int nd = (direction + 3)%4; // 0 -> 3 -> 2 -> 1
                int nx = out.x + dx[nd];
                int ny = out.y + dy[nd];

                if(nx < 0 || nx >=N || ny < 0 || ny >= M) continue;
                if(!visited[nx][ny] && space[nx][ny] != 1) { //방문 안함 (= 아직 청소 안됨) 그리고 벽이 아님 
                    visited[nx][ny] = true;
                    flag = true;
                    queue.add(new Mirror(nx, ny, out.cnt+1, direction)); //청소된 구역 + 1
                }
                // else if(visited[nx][ny] && space[nx][ny] != 1) {
                //     queue.add(new Mirror(out.x, out.y, out.cnt, direction));
                // }
                direction = (direction+3)%4;
            }
            
            
            if(!flag) {
                // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는
                //뒤도 벽인경우 
                int nd = (out.dir + 2) % 4;
                int bx = out.x + dx[nd];
                int by = out.y + dy[nd];
                //System.out.println(out.x + " , " + out.y + " dir " + out.dir + "  / 나아갈 곳 (" + nx + " ," +ny+ " ) 후진할 곳 (" + bx + ", " + by + " )"  );
                if( bx >= 0 && bx <N && by >= 0 && by < M && space[bx][by] != 1)  { //바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
                    visited[bx][by] = true;
                    queue.add(new Mirror(bx, by, out.cnt, out.dir)); //방향을 유지한채로, 청소되는 구역이 추가되는 것은 아님
                }
            }
        }

    }
}

