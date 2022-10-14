import java.io.*;
import java.util.*;

public class BOJ4991 {
    static char[][] c ;
    static int[][] dist;
    static class Point{
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int w, h;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;
            c = new char[h][w];
            dist = new int[h][w];

            for(int i=0; i<h; i++) {
                String str = br.readLine();
                for(int j=0; j<w; j++) {
                    c[i][j] = str.charAt(j);
                    if(c[i][j] == 'o') {
                        queue.add(new Point(i, j));
                        //c[i][j] = '.';
                    }
                }
            }

            int dis = bfs();
            boolean flag = true;
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(c[i][j] == '*') {
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }

            if(!flag) System.out.println(-1);
            else System.out.println(dis);


            queue = new LinkedList<>();

        }
    }

    static int bfs() {
        int dis = 0;
        while(!queue.isEmpty()) {
            Point out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx >=0 && nx < h && ny >=0 && ny < w && c[nx][ny] != '#') {
                    if(c[nx][ny] == '*') c[nx][ny] = '.';
                    queue.add(new Point(nx, ny));
                    dist[nx][ny] = dist[out.x][out.y] + 1;
                    System.out.println(dist[nx][ny]);
                    dis =  dist[nx][ny];
                }
            }
        }

        return dis;
    }
}
