package simulation;

import java.io.*;
import java.util.*;

public class BOJ17144 {
    static int R, C, T;
    static int[][] arr, n_arr;
    static class Position{
        int x, y;
        Position (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Position> queue = new LinkedList<>();
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        n_arr = new int[R][C];

        int x=0 , y = 0;

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                //if(arr[i][j] > 0 ) queue.add(new Position(i, j));
                if(arr[i][j] == -1 ){
                    x = i; 
                    y = j;
                }
            }
        }
        for(int l=0; l<T; l++) {

            //spread();

            for (int i=0; i<R; i++) {
                for (int j=0; j<C; j++) {
                    if (arr[i][j] <= 0) continue;
                    int cnt = 0;
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if (0 <= nx && nx < R && 0 <= ny && ny < C && arr[nx][ny] >= 0) {
                            cnt += 1;
                        }
                    }
                    if (cnt > 0) {
                        int val = arr[i][j]/5;
                        for (int k=0; k<4; k++) {
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if (0 <= nx && nx < R && 0 <= ny && ny < C && arr[nx][ny] >= 0) {
                                n_arr[nx][ny] += val;
                        }
                        }
                        n_arr[i][j] = n_arr[i][j] - cnt*val;
                    }
                }
            }
            

            System.out.println();
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                   // if (arr[i][j] == -1) continue;
                    arr[i][j] += n_arr[i][j];
                    System.out.print(arr[i][j] + " ");
                    n_arr[i][j] = 0 ;
                }
                System.out.println();
            }
            clearAir(x-1, y, 1);
            clearAir(x, y, 3);
        }
        
        int sum =0;
        for(int i=0; i<R; i++) {
           
            for(int j=0; j<C; j++) {
                if(arr[i][j] != -1)
                    sum += arr[i][j];
            }
        }
        System.out.println(sum);
        /*
         * 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
            (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
            인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
            확산되는 양은 Ar,c/5이고 소수점은 버린다.
            (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.

         */

    }

    static void spread() {

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            int spreadDir = 0;

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx >= 0 && ny >=0 && nx < R && ny < C && arr[nx][ny] >= 0) spreadDir++;
            }

            if (spreadDir > 0) {
                int howMany = arr[out.x][out.y] / 5; // 확산되는 양
                for(int i=0; i<4; i++) {
                    int nx = out.x + dx[i];
                    int ny = out.y + dy[i];
    
                    if(nx >= 0 && ny >=0 && nx < R && ny < C && arr[nx][ny] >= 0)
                        n_arr[nx][ny] += howMany;
                }
    
               // a[i][j] = a[i][j] - cnt*val;

                n_arr[out.x][out.y] =  n_arr[out.x][out.y] - howMany * spreadDir; //(r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
            }
            


        }
    }

    static void clearAir(int sx, int sy, int z) {
       
        int prev = 0;
        int x = sx, y = sy+1;
        int k =0;
        while(true) {
            if(x == sx && y == sy) break;
            int temp = prev;
            prev = arr[x][y];
            arr[x][y] = temp;

            x += dx[k];
            y += dy[k];

            if(x <0 || y < 0 || x >= R || y >= C) {
                x -= dx[k];
                y -= dy[k];
                k += z;
                k %= 4;
                x += dx[k];
                y += dy[k];

            }
        }
    }


}
