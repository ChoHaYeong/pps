package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N, M, max = 0;
    static int[][] a;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        //하나를 제외하고는 연속으로 3개가 이어져있음 4가 될 때 sum의 최대값 업데이트하자.
        //정답인 조건 : 4번째 블록이 선택되었을 때
            //sum을 업데이트해준다.
        //동서남북 탐색하면서, 범위 내에 있을 때 다시 함수 호출하기 

        //++++++after

        //정답인 조건 : 4번째 블록이 선택되었을 때
            //sum을 업데이트해준다.
        //불가능한 조건 : 범위를 벗어남, 이미 탐색함
        //동서남북 탐색하면서, 함수 호출하기 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        v = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) 
                go(0, 0, i, j);
        }

        System.out.println(max);
    }

    static void go(int curr, int sum, int x, int y) {
        if(curr == 4) {
            max = Math.max(max, sum);
        }
        if(!(x >= 0 && x < N && y >=0 && y <M)) return ;
        if(v[x][y]) return ;
        v[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

             go(curr+1, sum + a[x][y] , nx, ny);
        }

        v[x][y] = false;
    }
}
