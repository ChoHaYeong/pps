package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1987 {
    static private class PositionAndAlpha {
        int x;
        int y;
        char alphabet;

        PositionAndAlpha (int x, int y, char alphabet){
            this.x = x;
            this.y = y;
            this.alphabet = alphabet;
        }

    }
    static int R, C, cnt = 0;
    static char[][] arr;
    static int[][] visited;
    static boolean[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new int[R][C];
        alpha = new boolean[26];


        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) 
                arr[i][j] = str.charAt(j);  
        }

        bfs();
        // int 
        // for(boolean a: alpha){
        //     if(a)
        //         cnt++;
        // }

        System.out.println(cnt);
    }

    static void bfs() {
        Queue<PositionAndAlpha> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new PositionAndAlpha(0, 0, arr[0][0]));
        visited[0][0] = 1;
        System.out.println("~~~~~~ " + (arr[0][0]-65));
        alpha[arr[0][0]-65] = true;
        cnt++;

        while(!queue.isEmpty()) {
            PositionAndAlpha out = queue.poll();
            System.out.println(out.x + " , " + out.y + " : " + out.alphabet);
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny<0 || nx >= R || ny >=C){
                    System.out.println(1 + " nx : " + nx + " , ny " + ny + " R " + R +  " C " + C  );
                    continue;
                }
                // if(visited[nx][ny]){
                //     System.out.println(2+ " nx : " + nx + " , ny " + ny );
                //     continue;
                // }
                // if(alpha[arr[nx][ny]-65]) {
                //     System.out.println(3+ " nx : " + nx + " , ny " + ny + " / " + alpha[arr[nx][ny]-65]);
                //     continue;
                // }
                    //!visited[nx][ny] || (visited[nx][ny] && 
                if(!alpha[arr[nx][ny]-65]) {
                    queue.add(new PositionAndAlpha(nx, ny, arr[nx][ny]));
                    visited[nx][ny] = visited[out.x][out.y] + 1;
                    alpha[arr[nx][ny]-65] = true;
                    cnt = visited[nx][ny];
                }
                
            }
        }
    }
    
}
