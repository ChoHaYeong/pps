package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int N, M, cnt = 1;
    static int[][] arr;
    static int r, c, d;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) 
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
       // arr[r][c] = -1;
        dfs(r, c, d);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int d) {
        //현재 위치를 청소한다.
      //  visited[x][y] = true;
      for(int i=0; i<N; i++) {
        //st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++) 
            System.out.print(arr[i][j] +" ");
        System.out.println();
        }
        System.out.println();
        arr[x][y] = -1;
        //cnt++; //여기 두면 dfs실행될때마다 증가됨

        //청소가 안되어 있는 경우 청소하기
        for(int i=0; i<4; i++) {
            //처음에 들어온 d가 북쪽(0)이라면 0-> 3->2-> 1 -> 0 (북 서 남 동 북)
            d =  (d>0) ? d-1 : d+3;
            int nx = x + dx[d]; 
            int ny = y + dy[d];
            
            if(nx>=0 && ny >=0 && nx<N && ny <M &&  arr[nx][ny] == 0) { //2-1 (2-2는 해당 if문에 걸리지 않고, for문을 돌면서 방향 변환함 )
                cnt++;
             //   visited[nx][ny] = true;
                dfs(nx, ny, d);
                return ;
            }
            //else if(visited[nx][ny]) dfs(x, y, (d+3)%4);
        }

       // int back = (d+2)%4; //북에서 후진하면 남, 남에서 후진하면 북, 동에서 후진하면 서, 서에서 후진하면 동 (0 -> 2 , 2 -> 0, 1-> 3, 3 ->1)
        int bx = x - dx[d];
        int by = y - dy[d];

        if(bx>=0 && by >=0 && bx<N && by <M && arr[bx][by] != 1 ) //2-3
            dfs(bx, by, d); //후진한다고 해서 방향이 바뀌는건 아니니까



    }
}
