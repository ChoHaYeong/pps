

import java.util.*;
import java.io.*;

public class BOJ2206 {
    static int N, M, r_min = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] dist; //거리를 나타냄
    static boolean[][] change; //해당 좌표의 벽이 뚫어진 적 있는지 나타냄
    static boolean flag ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        change = new boolean[N][M];


        int count = 0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
                if(map[i][j] == 1)
                    count++;
            }
        }


       // for(int i=0; i<count; i++) { //벽의 개수만큼 

        for(int j=0; j<N; j++) {
            for(int k=0; k<M; k++) {
                if(map[j][k] == 1 && !change[j][k]) {
                    map[j][k] = 0;
                    change[j][k] = true;
                }

                flag = false;
                //System.out.println(" min : " + min + " flag " + flag + "change[j][k] " + change[j][k] + " j " + j + " , k " + k);
                bfs(0, 0); //bfs(j, k) 가 아님,

               
                //System.out.println(" min : " + min ++ " flag " + flag + "change[j][k] " + change[j][k] + " j " + j + " , k " + k);
                if(flag)
                    r_min = Math.min(r_min, min);

                map[j][k] = 1; //벽은 다시 원상복구 
                
                for(int l=0; l<N; l++) {
                    for(int m=0; m<M; m++) {
                        dist[l][m] = 0;
                    }
                }
            }
        }
        
        if(r_min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(r_min);

       // }

        
    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new Position(x, y));
        
        dist[x][y] ++;

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                else if(map[nx][ny] == 1 || dist[nx][ny] > 0) continue;
                else {
                    queue.add(new Position(nx, ny));
                    dist[nx][ny] = dist[out.x][out.y] + 1;

                    if(nx == N-1 && ny == M-1) {
                        min = dist[nx][ny] + 1;
                        flag = true;
                        return ;
                    }
                }
            }
        }
    }

    
}
