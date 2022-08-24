import java.util.*;
import java.io.*;

public class BOJ17086 {
    static int N, M, max = 0;
    static int[][] space, dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];
        dist = new int[N][M];

        //상어가 있는 칸에서 bfs를 한다.
        //다른 상어를 만나면, 최대거리를 업데이트해준다.

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dist[i], -1);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(space[i][j] == 0 && dist[i][j] == -1){
                   // System.out.println(i + " , " + j);
                    bfs(i, j);

                    for(int k=0; k<N; k++)
                        Arrays.fill(dist[k], -1); //다시 업뎃
                }
            }


            // System.out.println();
            // for(int k=0; k<N; k++) {
            //     for(int j=0; j<M; j++) {
            //         System.out.print(dist[k][j] + " ");
            //     }
            //     System.out.println();
            // }

            // for(int j=0; j<N; j++)
            //     Arrays.fill(dist[j], -1); //다시 업뎃

            // for(int k=0; k<N; k++) {
            //     for(int j=0; j<M; j++) {
            //         System.out.print(dist[k][j] + " ");
            //     }
            //     System.out.println();
            // }
        }


        System.out.println(max);

    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

        queue.add(new Position(x, y));
        dist[x][y] = 0;

        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<8; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >=N || ny >= M) continue;
                if(dist[nx][ny] >= 0) continue;
                queue.add(new Position(nx, ny));
                dist[nx][ny] = dist[out.x][out.y] + 1;
                //System.out.println("(" + out.x + " , " + out.y + " ) => (" + nx + " , " + ny + ") 로 이동 " + dist[nx][ny]);

                if(space[nx][ny] == 1) { // 다른 아기 상어를 만났을 경우 
                    //System.out.println(nx + "  =>  " + ny);
                    max = Math.max(max, dist[nx][ny]);
                    return ;
                }
            }
        }
    }
    
}
