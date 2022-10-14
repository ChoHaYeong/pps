import java.util.*;
import java.io.*;

public class BOJ17142 {
    static int N, M, ans = -1;
    static int[][] lab, newMap, n_arr, dist;
    static boolean[] visited;
   // static Queue<Position> queue;
    static List<Position> virus = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //연구실 크기
        M = Integer.parseInt(st.nextToken()); //바이러스 개수

        lab = new int[N][N];
        dist = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                lab[i][j] = Integer.parseInt(st.nextToken()); 
                if(lab[i][j] == 2){
                   // lab[i][j] = 0; //우선 0으로 바꾸고 나중에 바이러스 놓은 곳만 바꿔주기
                    virus.add(new Position(i, j));
                }
            }
        }

        go(0, 0);
        System.out.println(ans);
            
    }

    static void go(int curr, int start) {
        if(curr == virus.size()) {
            if(start == M) {
                bfs();
            }
        }
        else {
            int x = virus.get(curr).x;
            int y = virus.get(curr).y;
            lab[x][y] = 3; //바이러스 둠
            go(curr+1, start+1);
            lab[x][y] = 2;
            go(curr+1, start);
        }
    }

    static void bfs() {
        Queue<Position> queue = new LinkedList<>();

        for(int i=0; i<N; i++)
            Arrays.fill(dist[i], -1);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(lab[i][j] == 3) {
                    queue.add(new Position(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        //boolean flag = false;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                // if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // if(dist[nx][ny] > -1 || lab[nx][ny] == 1) continue;
                if(nx >=0 && nx <N && ny >=0 && ny < N) {
                    if(lab[nx][ny] != 1 && dist[nx][ny] == -1) {

                        queue.add(new Position(nx, ny));
                        dist[nx][ny] = dist[out.x][out.y] + 1;
                    } 
                }
            }
            
        }

        int curr = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(lab[i][j] == 0) {
                    if(dist[i][j] == -1) return ; //바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우
                    if(curr < dist[i][j]) curr = dist[i][j];
                }
            }
        }

        if(ans == -1 || ans > curr) ans = curr;



        // if(!flag)
        //     System.out.println(-1);
        // return ;
    }
    
}
