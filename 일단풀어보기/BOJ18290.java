package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18290 {
    static int N, M ,K, max = 0;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,  0);
        System.out.println(max);
    }

    static void dfs(int curr,  int sum) {
        if(curr == K) {
            if(max < sum) 
                max = sum;
            return ;
        }
        
        for(int i=0; i<N; i++) {
           // st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                // if(x-1 > 0 ) visited[x-1][y] = true;
                // if(y-1 > 0) visited[x][y-1] = true;
                // if(x+1 < N) visited[x+1][y] = true;
                // if(y+1 < M) visited[x][y+1] = true;

                if(!visited[i][j] && canPick(i, j)) {
                    visited[i][j] = true;
                   // sum += arr[i][j];

                  //  System.out.println("sum " + sum + " , curr " + curr + " 더해진 것 " + arr[i][j] + " ("+i+" , " + j +  ")");
                    dfs(curr+1,  sum+arr[i][j]);

                  //  System.out.println("backsum " + sum);
                    visited[i][j] = false;
                }

                
            }
        }
    }

    static boolean canPick(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M)  {
                if(visited[nx][ny])
                    return false;
            }
        }

        return true;
    }
}
