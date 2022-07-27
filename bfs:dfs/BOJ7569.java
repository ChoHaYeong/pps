import java.util.*;
import java.io.*;

public class BOJ7569 {

    static int H, N, M;
    static boolean[][][] visited;
    static int[][][] tomatos;
    static int[][][] dist;
    static int days = 0;

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
                }
            }
        }
        
        // if(flag)
        //     return 0; //처음부터 다 익어있음 

        int count = 0;
        for(int i=0; i< H; i++) {
            for(int j=0; j< N; j++) {
                for(int k=0; k<M; k++) {
                    if(tomatos[i][j][k] == 1 && !visited[i][j][k]){
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

    static void bfs(int x, int y, int z) {
        int[] dx = {-1, 0, 1, 0, 0, 0};
        int[] dy = {0, -1, 0, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        Queue<Position2> q = new LinkedList<>();

        visited[x][y][z] = true;
        q.add(new Position2(x, y, z));

        while(!q.isEmpty()) {
            Position2 out = q.poll();

            for(int i=0; i<6; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];
                int nz = out.z + dz[i];

                if(nx< 0 || ny< 0 || nz< 0 || nx >= H || ny>= N || nz >= M ) continue;
                else if( visited[nx][ny][nz] || tomatos[nx][ny][nz] == -1 ) continue;
                else {
                   // System.out.println(nx + " ," + ny + " , " + nz);
                    visited[nx][ny][nz] = true;
                    tomatos[nx][ny][nz] = 1;
                    q.add(new Position2(nx, ny, nz));
                    dist[nx][ny][nz] = dist[out.x][out.y][out.z] + 1;
                    days = dist[nx][ny][nz];
                }
            }

        }
    }
    
}

class Position2{
    int x;
    int y;
    int z;
    
    Position2(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
