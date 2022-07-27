import java.util.*;
import java.io.*;

public class BOJ2589 {

    static int M, N, area = 0;
    static char[][] map;
    static int[][] dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());  
        N = Integer.parseInt(st.nextToken()); 
        map = new char[M][N];
        dist = new int[M][N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int distance = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'L') {

                    visited = new boolean[M][N];
                    bfs(i, j);
                }

            }
        }

       System.out.println(area-1);
    }

    static void bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int dis = 0;

        q.add(new Position(x, y));
        visited[x][y] = true;
        dist[x][y] = 1;


        while(!q.isEmpty()) {
            Position out = q.poll();

            dis = Math.max(dis, dist[out.x][out.y]);

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx <0 || ny < 0 || nx >= M || ny >= N) continue;
                else if(visited[nx][ny] || map[nx][ny] == 'W') continue;
                else {
                    visited[nx][ny] = true;
                    q.add(new Position(nx, ny));
                    dist[nx][ny] = dist[out.x][out.y] + 1;
                    //System.out.println(nx + " , " + ny + " : " + dist[nx][ny]);
                    area = Math.max(area, dist[nx][ny]);
                }
            }
        }
        //return dis-1;
        // area = Math.max(area, dis+1);
       // System.out.println(dis);

    }
    
}
