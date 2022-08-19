import java.util.*;
import java.io.*;

public class BOJ7569 {

    static int H, N, M;
    static boolean[][][] visited;
    static int[][][] tomatos;
    static int[][][] dist;
    static int days = 0;
    static Queue<Position2> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); 


        visited = new boolean[H][N][M];
        tomatos = new int[H][N][M];
        dist = new int[H][N][M];
        boolean flag = true;
        boolean complete = true;

        for(int i=0; i< H; i++) {
            for(int j=0; j< N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    tomatos[i][j][k] = Integer.parseInt(st.nextToken());  //  정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸

                    if(tomatos[i][j][k] == 0) 
                        flag = false; //익지 않은 것이 하나라도 있음
                    if(tomatos[i][j][k] == 1){
                        q.add(new Position2(i, j, k)); 
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        
        // if(flag)
        //     return 0; //처음부터 다 익어있음 

        int count = 0;
        for(int i=0; i< H; i++) {
            for(int j=0; j< N; j++) {
                for(int k=0; k<M; k++) {
                    if(tomatos[i][j][k] == 1){
                        bfs(i, j, k); 
                    }
                }
            }
        }

        for(int i=0; i< H; i++) {
            for(int j=0; j< N; j++) {
                for(int k=0; k<M; k++) {
                    if(tomatos[i][j][k] == 0) {
                        complete = false;
                    }
                        
                }
            }
        }

        //System.out.println(count + " ==================== ");
        if(flag)
            System.out.println(0);
        else if(!complete)
            System.out.println(-1);
        else{

            System.out.println(days);
        }
        //return count;
    }

    static void bfs(int h, int x, int y) {
        int[] dh = {0, 0, 0, 0, 1, -1};
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        // Queue<Position2> q = new LinkedList<>();

        // visited[x][y][z] = true;
        // q.add(new Position2(x, y, z));

        while(!q.isEmpty()) {
            Position2 out = q.poll();

            for(int i=0; i<6; i++) {
                int nh = out.h + dh[i];
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nh< 0 || nx< 0 || ny< 0 || nh >= H || nx>= N || ny >= M ) continue;
                else if( visited[nh][nx][ny] || tomatos[nh][nx][ny] == -1 ) continue;
                else {
                   // System.out.println(nx + " ," + ny + " , " + nz);
                    visited[nh][nx][ny] = true;
                    tomatos[nh][nx][ny]  = 1;
                    q.add(new Position2(nh, nx, ny));
                    dist[nh][nx][ny]  = dist[out.h][out.x][out.y] + 1;
                    days = dist[nh][nx][ny] ;
                }
            }

        }
    }
    
}

class Position2{

    int h;
    int x;
    int y;
    
    Position2(int h, int x, int y) {

        this.h = h;
        this.x = x;
        this.y = y;
    }
}
