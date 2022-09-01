import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
    int x, y, cnt;

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point p) {
        return this.cnt - p.cnt;
    }
}

public class BOJ1261 {
    static int[][] maze, dist;
    static boolean[][] visited;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        //cnt = 0;

        maze = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];

        // for(int j=0; j<dist.length; j++) {
        //     Arrays.fill(dist[j], -1);
        // }

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
            }
        }

        bfs(0,0);

    }

    static void bfs(int x, int y) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.offer(new Point(x, y, 0));
        visited[x][y] = true;
        //dist[x][y] = 0;

        while(!queue.isEmpty()) {
            Point out= queue.poll();
           // System.out.println(out.x + " , " + out.y + " => " + out.cnt);

            if(out.x == N-1 && out.y == M-1){

                System.out.println(out.cnt);
                //System.out.println(dist[out.x][out.y] + 1);
                return ;
            }

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //if(dist[nx][ny] > -1) continue;
                int cnt = out.cnt;
                if(maze[nx][ny] == 1) cnt++;

                if(!visited[nx][ny]) { //방문 안했을 때
                    // if(maze[nx][ny] == 1) {
                    //     visited[nx][ny] = true;
                    //     dist[nx][ny] = out.cnt+1;
                    //     queue.offer(new Point(nx, ny, out.cnt+1));
                    //     //System.out.println(nx + " , " + ny + " => " + (out.cnt+1));
                    // } 
                    // if(maze[nx][ny] == 0) {
                    //     visited[nx][ny] = true;
                    //     dist[nx][ny] = out.cnt;
                    //     queue.offer(new Point(nx, ny, out.cnt));
                    // }

                    visited[nx][ny] = true;
                    dist[nx][ny] = cnt;
                    queue.offer(new Point(nx, ny, cnt));
                }
                else if(visited[nx][ny] && dist[nx][ny] > cnt) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = cnt;
                    queue.offer(new Point(nx, ny, cnt));
                }
                

                //dist[nx][ny] = dist[out.x][out.y] + 1;

            }
        }

        //System.out.println(cnt);
    }

}