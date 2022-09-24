package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19236 {
    static final int n = 4;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] num = new int[n][n]; //물고기의 번호를 담은 배열
        int[][] dir = new int[n][n]; //방향을 담은 배열

        for(int i=0; i<n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                dir[i][j] = Integer.parseInt(st.nextToken())-1;
            }
        }

        //상어가 물고기 먹음
        int ans = num[0][0];
        num[0][0] = 0;

        ans += go(num, dir, 0, 0, dir[0][0]);



    }

    static int go(int[][] num, int[][] dir, int x, int y, int d) {

        for(int l=0; l<n*n; l++) { 


        }
    }
}
