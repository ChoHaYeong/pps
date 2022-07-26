import java.util.*;
import java.io.*;

public class BOJ2583 {
    
    static boolean[][] visited;
    static int[][] arr;
    static int maxArea = 0, M, N, K;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new int[N][M];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken()); 
            int fy = Integer.parseInt(st.nextToken());
            int bx = Integer.parseInt(st.nextToken()); 
            int by = Integer.parseInt(st.nextToken()); 

            for(int j=fx; j<bx; j++) {
                for(int k=fy; k<by; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int area_count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && arr[i][j] == 0) {
                    bfs(i, j);
                    area_count++;
                }
            }
        }


        System.out.println( area_count);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++)
            System.out.print(list.get(i) + " ");

    }

    public static void bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int area = 0;

        visited[x][y] = true;
        q.add(new Position(x, y));
        area++;


        while(!q.isEmpty()) {
            Position out = q.poll();
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                else if(visited[nx][ny] || arr[nx][ny] == 1) continue;
                else {
                    visited[nx][ny] = true;
                    q.add(new Position(nx, ny));
                    area++;
                } 
            }
        }
        list.add(area);
    }
}
