package codeplus_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14500 {
    static int N, M, max = 0;
    static int[][] paper;
    static boolean[][] visited;
    static int[] arr = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로크기 
        M = Integer.parseInt(st.nextToken()); // 가로크기 

        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                dfs(0, i, j);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                bfs(i, j);
            }
        }
        

        System.out.println(max);
    }

    static void dfs(int curr, int x, int y) {
        //지금은 대각선까지도 연결된 것으로 취급.
        //그거 아니고, 상,하,좌,우 만 탐색해서 깊이가 4이상일 때, 그 sum을 구한다.
        //필요한 파라미터는 현재 위치를 나타내는 x, y, 그리고 깊이 curr
        if(curr == 4) {
            int sum = 0 ;
            for(int a: arr) {
               // System.out.print(a + " ");
                sum += a;
            }

            if(sum == 20) {
                for(int a: arr) {
                    System.out.print(a + " ");
                }

            System.out.println(" ===================> sum : " + sum + " x : " + x + " y : " + y);
            }

            if(max < sum)
                max = sum;

            return ;
        }

        for(int i=x; i<N; i++) {
            for(int j=y; j<M; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    arr[curr] = paper[i][j];
                    dfs(curr+1, i, j);
                    visited[i][j] = false;
                }
            }
        }
    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();

        int[] x1 = {0, 0, 1};
        int[] y1 = {1, 2, 1};
        //paper[x][y] + paper[x][y+1] + paper[x][y+2] + paper[x+1][y+1]
        //굳이 queue에 넣고 할 필요가 없음

        int[] x2 = {1, 2, 1};
        int[] y2 = {0, 0, -1};

        int[] x3 = {0, 0, -1};
        int[] y3 = {-1, -2, -1};

        int[] x4 = {-1, -2, -1};
        int[] y4 = {0, 0, 1};

        int sum = 0;

        queue.add(new Position(x, y));

       // while(!queue.isEmpty()) {
            Position out = queue.poll();
            sum += paper[out.x][out.y];
            //System.out.println("1)sum : "+ sum);
            for(int i=0; i<3; i++) {
                int nx = out.x + x1[i];
                int ny = out.y + y1[i];
                if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
                else{
                    queue.add(new Position(nx, ny));
                    sum += paper[nx][ny];

                   // System.out.println("1)sum => "+ sum);
                }
            }
       // }

        if(max < sum){
            System.out.println("1) max : "+ max + " sum : " + sum);
            max = sum;
        }

        sum = 0;
        queue.add(new Position(x, y));

       // while(!queue.isEmpty()) {
            out = queue.poll();
            sum += paper[out.x][out.y];

            for(int i=0; i<3; i++) {
                int nx = out.x + x2[i];
                int ny = out.y + y2[i];
                if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
                else{
                    queue.add(new Position(nx, ny));
                    sum += paper[nx][ny];
                }
            }
       // }

        if(max < sum){
            System.out.println("2) max : "+ max + " sum : " + sum);
            max = sum;
        }
        queue.add(new Position(x, y));
        sum = 0;

       // while(!queue.isEmpty()) {
            out = queue.poll();
            sum += paper[out.x][out.y];

            for(int i=0; i<3; i++) {
                int nx = out.x + x3[i];
                int ny = out.y + y3[i];
                if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
                else{
                    queue.add(new Position(nx, ny));
                    sum += paper[nx][ny];
                }
            }
       // }

        if(max < sum){
            System.out.println("3) max : "+ max + " sum : " + sum);
            max = sum;
        }

        queue.add(new Position(x, y));
        sum = 0;

        //while(!queue.isEmpty()) {
            out = queue.poll();
            sum += paper[out.x][out.y];

            for(int i=0; i<3; i++) {
                int nx = out.x + x4[i];
                int ny = out.y + y4[i];
                if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
                else{
                    queue.add(new Position(nx, ny));
                    sum += paper[nx][ny];
                }
            }
        //}

        if(max < sum){
            System.out.println("4) max : "+ max + " sum : " + sum);
            max = sum;
        }


    }
    
}
