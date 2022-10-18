package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1520 {
    static int N, M;
    static int[][] arr, D;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        D = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
    }

    static void dfs(int x, int y, int curr) {
        if(x == N-1 && y == M-1){
            System.out.println(D[x][y]);

            System.exit(0);
            return ;
        }

        if(visited[x][y]) return ;
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny <0 || nx >= N || ny >= M) continue;
            if(arr[x][y] > arr[nx][ny]) {
                visited[nx][ny] = true;
                D[nx][ny] = D[x][y] + 1;
                dfs(nx, ny, curr+1);
            }
            System.out.println(D[nx][ny] + "(" + nx + " , " + ny + ")");
        }
    }
}
