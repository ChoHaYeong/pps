import java.util.*;
import java.io.*;

public class BOJ2573 {
    /*무한반ㄴ복 (year를 증가시켜간다.)
  => 0이 아닐 때 bfs 진행하여 탐색할 때 인접한 지역이 0이라면 개수를 세어준다.
  => 동서남북 네 방향으로 탐색이 끝났을 떄, 개수만큼 높이를 줄인다. ? (이 때 0보다 작다면 0으로 한다.)
  => bfs를 호출할 때마다 count를 센다.
  => count가 2 이상이면 빙산이 2개 이상으로 분리되었다고 볼 수 있다. 이 떄의 year를 출력한다.
  => count가 2 이상이 아니면, count도 초기화하고 방문배열도 초기화하고 다시 반복문을 시작한다.

  끝까지 빙산이 녹지 않는 경우 ,,
   */
  static int N, M;
  static int[][] height, zeroNum;
  static boolean[][] visited;
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    height = new int[N][M];
    visited = new boolean[N][M];
    zeroNum = new int[N][M];

    int cnt = 0;
    for(int i=0; i<N; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++) {
            height[i][j] = Integer.parseInt(st.nextToken());
            if(height[i][j] == 0)
                cnt++;
        }
    }

    if(cnt == 0){
        System.out.println(0);
        return ;
    }

    int year = 0;
    while(true) {
        int count = 0;
        int count_zero = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(height[i][j] != 0 && !visited[i][j]){
                    bfs(i, j);
                    count++;
                }
                if(height[i][j] == 0) 
                    count_zero++;
            }
        }

        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<M; j++) {
        //         System.out.print(height[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        if(count >= 2) 
            break;
        else {

            if(count_zero == N*M){ //2덩이 이상으로 나뉘지 않았지만 모든 빙산이 녹았을 경우 
                System.out.println(0);
                return ;
            }


            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(height[i][j] < zeroNum[i][j])
                        height[i][j] = 0;
                    else
                        height[i][j] -= zeroNum[i][j]; // 인접한 0의 개수만큼 높이 감소
                }
            }


            year++;
            count = 0 ;

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    visited[i][j] = false;
                    zeroNum[i][j] = 0;
                }
            }
        }

    }

    System.out.println(year);
   } 

   static void bfs(int x, int y) {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    Queue<Position> queue = new LinkedList<>();
    queue.add(new Position(x, y));
    visited[x][y] = true;

    while(!queue.isEmpty()) {
        Position out = queue.poll();

        for(int i=0; i<4; i++) {
            int nx = out.x + dx[i];
            int ny = out.y + dy[i];

            if(nx < 0 || ny <0 || nx >=N || ny >= M) continue;
            else if(visited[nx][ny]) continue;
            else if(height[nx][ny] == 0) 
                zeroNum[out.x][out.y]++; // 0과 인접한 개수를 더해간다.
            else {
                queue.add(new Position(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }
   }
}
