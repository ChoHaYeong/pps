
import java.util.*;
import java.io.*;

public class BOJ6593 {
    static int L, R, C;
    static char[][][] building;
    static int[][][] dist;
    static boolean[][][] visited;
    static Queue<Position2> queue = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0)
                break;

            building = new char[L][R][C];
            dist = new int[L][R][C];
            visited = new boolean[L][R][C];


            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++) {
                    String str = br.readLine();
                    for(int k=0; k<C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if(building[i][j][k] == 'S'){
                            queue.add(new Position2(i, j, k));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            //bfs 시작
            bfs();

            if(flag)
                System.out.println("Escaped in " +min+ " minute(s).");
            else
                System.out.println("Trapped!");
            
            min = Integer.MAX_VALUE;
            flag = false;
            queue = new LinkedList<>();


        }
    }

    static void bfs() {
        //상 하 좌 우 위층 아래층
        int[] dx = {0, 0, 0, 0, 1, -1};
        int[] dy = {-1, 0, 1, 0, 0, 0};
        int[] dz = {0, -1, 0, 1, 0, 0};

        while(!queue.isEmpty()) {
            Position2 out = queue.poll();
            for(int i=0; i<6; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];
                int nz = out.z + dz[i];

                if(nx < 0 || ny < 0 || nz <0 || nx >= L || ny >= R || nz >= C) continue;
                else if(visited[nx][ny][nz] || building[nx][ny][nz] == '#') continue;
                else {
                    queue.add(new Position2(nx, ny, nz));
                    visited[nx][ny][nz] = true;
                    dist[nx][ny][nz] = dist[out.x][out.y][out.z] + 1;

                    if(building[nx][ny][nz] == 'E') {
                        flag = true;
                        min = dist[nx][ny][nz];
                        return ;
                    }
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
