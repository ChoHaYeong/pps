package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16234 {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited;
    static boolean canMove = true;
    static class Position{
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;
        while(canMove) {
            canMove = false;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j])
                        bfs(i, j);
                }
            }

            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         System.out.print(arr[i][j] + " " ) ;
            //     }
            //     System.out.println();
            // }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    visited[i][j] = false;
                }
            }
            if(canMove) days++;
        }

        System.out.println(days);

    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        int howMany = 0;
        int cnt = 0;
        List<Position> list = new LinkedList<>();
        
        queue.add(new Position(x, y));
        visited[x][y] = true;
        list.add(new Position(x, y));
        howMany += arr[x][y];
        cnt++;
        
        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny <0 || nx >= N || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if(Math.abs(arr[out.x][out.y] - arr[nx][ny]) < L || Math.abs(arr[out.x][out.y] - arr[nx][ny]) > R) continue;
                list.add(new Position(nx, ny));
                queue.add(new Position(nx, ny));
                visited[nx][ny] = true;

                howMany += arr[nx][ny];
                cnt++;

            }
        }


        if(list.size() > 1) {
            canMove = true;
            for(Position l : list)
                arr[l.x][l.y] = (int) Math.floor(howMany / cnt);
        }
    }
}
