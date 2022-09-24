package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16197 {
    static int N,M,fx,fy,sx,sy, ans = Integer.MAX_VALUE;
    static char[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        boolean isFirst = true;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
                
                if(arr[i][j] == 'o') {
                    if(isFirst){
                        fx = i;
                        fy = j;
                        isFirst = false;
                    } else {
                        sx = i;
                        sy = j;
                        isFirst = true;
                    }
                    // int[] xy = {i, j};
                    // queue.add(xy);
                }
            }
        }
      //  System.out.println(fx + " , " + fy + " , " + sx + " , " + sy);
        dfs(fx, fy, sx, sy, 0);
        if(ans > 10)
            System.out.println(-1);
        else
            System.out.println(ans);

    }

    static void dfs(int fx, int fy, int sx, int sy, int curr) {
        if( curr > 10) {
            System.out.println(-10);
            System.exit(0);
            //return ;
        }

       // int fx = 0, fy = 0, sx = 0, sy = 0;

        for(int i=0; i<4; i++) {
            // int[] array = queue.poll();
            // int[] array2 = queue.poll();

            int nx = fx + dx[i];
            int ny = fy + dy[i];

            int nx2 = sx + dx[i];
            int ny2 = sy + dy[i];

            
            //동전이 이동하려는 방향에 칸이 없으면 동전은 보드 바깥으로 떨어진다
            if(isOutofBound(nx, ny) && isOutofBound(nx2, ny2)){
                if(i== 3 ) {

                //System.out.println(-12);
                return ;
                } else {
                    continue;
                }
            }
            if((!isOutofBound(nx, ny) && isOutofBound(nx2, ny2)) || isOutofBound(nx, ny) && !isOutofBound(nx2, ny2)){
                ans = Math.min(ans, curr+1);
                return ;
               // System.exit(0);
            }

            //동전이 이동하려는 칸이 벽이면, 동전은 이동하지 않는다.
            if(arr[nx][ny] == '#' ) {
                nx = fx;
                ny = fy;
            }

            if(arr[nx2][ny2] == '#'){
                nx2 = sx;
                ny2 = sy;
            }


            // int[] n_arr = {fx, fy};
            // int[] n_arr2 = {sx, sy};
            // queue.add(n_arr);
            // queue.add(n_arr2);
            dfs(nx, ny, nx2, ny2, curr+1);

        }



    }

    static boolean isOutofBound(int x, int y) {
        if(x >= 0 && x < N && y >=0 && y <M) return false;
        else return true;
    }
}
