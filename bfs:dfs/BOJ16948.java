import java.util.*;
import java.io.*;

public class BOJ16948 {
    // static int N, r1, c1, r2, c2;
    // static int[][] borad, dist;
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     N = Integer.parseInt(br.readLine());
        
    //     StringTokenizer st = new StringTokenizer(br.readLine());
    //     r1 = Integer.parseInt(st.nextToken());
    //     c1 = Integer.parseInt(st.nextToken());
    //     r2 = Integer.parseInt(st.nextToken());
    //     c2 = Integer.parseInt(st.nextToken());

    //     borad = new int[N][N];
    //     dist = new int[N][N];

    //     for(int j=0; j<dist.length; j++) {
    //         Arrays.fill(dist[j], -1);
    //     }

    //     bfs(r1, c1);
    // }

    // static void bfs(int r, int c) {
    //     boolean flag = false;
    //     Queue<Position> queue = new LinkedList<>();
    //     int[] dx = {-2, -2, 0, 0, 2, 2};
    //     int[] dy = {-1, 1, -2, 2, -1, 1};

    //     queue.add(new Position(r, c));
    //     dist[r][c] = 0;

    //     while(!queue.isEmpty()) {
    //         Position out = queue.poll();

    //         if(out.x == r2 && out.y == c2) {
    //             System.out.println(dist[out.x][out.y]);
    //             flag = true;
    //             return ;
    //         }
    //         for(int i=0; i<6; i++) {
    //             int nx = out.x + dx[i];
    //             int ny = out.y + dy[i];

    //             if(nx <0 || ny<0 || nx >=N || ny >= N ) continue;
    //             if(dist[nx][ny] > 0) continue;

    //             queue.add(new Position(nx, ny));
    //             dist[nx][ny] = dist[out.x][out.y] + 1;
    //         }
    //     }

    //     if(!flag)
    //         System.out.println(-1);
    //     return ;
    // }
    // (r, c)라면, (r-2, c-1), (r-2, c+1), (r, c-2), (r, c+2), (r+2, c-1), (r+2, c+1)
    static int N, r1, c1, r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] a, dist;
    static boolean flag = false;
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N][N];
        dist = new int[N][N];

        for(int i=0; i<N; i++)
            Arrays.fill(dist[i], -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());

        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1);
        if(!flag) System.out.println(-1);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        dist[x][y] = 0;

        while(!queue.isEmpty()) {
            Point out = queue.poll();

            if(out.x == r2 && out.y == c2) {
                System.out.println(dist[out.x][out.y]);
                flag = true;
                return ;
            }

            for(int i=0; i<6; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx >=0 && nx <N && ny >=0 && ny <N && dist[nx][ny] == -1) {
                    queue.add(new Point(nx, ny));
                    dist[nx][ny] = dist[out.x][out.y] + 1;
                }
            }
        }
    }
}
