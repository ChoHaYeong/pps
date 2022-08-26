import java.util.*;
import java.io.*;

public class BOJ17141 {
    static int N, M, wall = 0, total, min = Integer.MAX_VALUE;
    static int[][] lab, newMap, n_arr, dist;
    static boolean[] visited;
    static Queue<Position> queue;
    static List<Position> virus = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //연구실 크기
        M = Integer.parseInt(st.nextToken()); //바이러스 개수

        lab = new int[N][N];
        n_arr = new int[M][2];
        dist = new int[N][N];

        int idx = 0, count = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                lab[i][j] = Integer.parseInt(st.nextToken()); 
                if(lab[i][j] == 1) {
                    wall ++; //벽의 개수 ++
                } 
                else if(lab[i][j] == 2)
                    virus.add(new Position(i, j));
                else
                    count++;
            }
        }


        visited = new boolean[virus.size()];

        dfs(0, 0);
        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
            
    }

    static void dfs(int curr, int start) {
        if(curr == M) {
            total = N*N;
            queue = new LinkedList<>();
            newMap = new int[N][N];
            dist = new int[N][N];
            for(int i=0; i<dist.length; i++)
                Arrays.fill(dist[i], -1);

            for(int i=0; i<N; i++) 
                for(int j=0; j<M; j++) 
                    newMap[i][j] = (lab[i][j] == 2 ? 0 : lab[i][j]);
            

            for(int i=0; i<virus.size(); i++) {
                if(visited[i]){
                    Position p = virus.get(i);
                    newMap[p.x][p.y] = 2;
                    queue.add(new Position(p.x, p.y));
                    dist[p.x][p.y] = 0;
                    total--;
                }
            }


            // System.out.println();
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         System.out.print(newMap[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            bfs();

           
        //    System.out.println("----> bfs");
        //     System.out.println();
        //     for(int i=0; i<N; i++) {
        //         for(int j=0; j<N; j++) {
        //             System.out.print(dist[i][j] + " ");
        //         }
        //         System.out.println();
        //     }

            return ;

        }

        for(int i=start; i<virus.size(); i++) {
            Position v = virus.get(i);
            if(!visited[i]) {
                visited[i] = true;
                n_arr[curr][0] = v.x;
                n_arr[curr][1] = v.y;
                dfs(curr+1, start+1);
                visited[i] = false;
            }
        }

    }

    static void bfs() {
        boolean flag = false;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            if(min <=  dist[out.x][out.y] ) break;

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(dist[nx][ny] > -1 || lab[nx][ny] == 1) continue;
                queue.add(new Position(nx, ny));
                dist[nx][ny] = dist[out.x][out.y] + 1;
                total--;
            }

            if(total == wall) {
                if(dist[out.x][out.y] == 0)
                    min = Math.min(min, dist[out.x][out.y]);
                else
                    min = Math.min(min, dist[out.x][out.y]+1);
                flag = true;
                return ;
            }

            
        }

        // if(!flag)
        //     System.out.println(-1);
        // return ;
    }
    
}
