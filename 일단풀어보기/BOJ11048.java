package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        int[][] D = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
            
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(i == 0 && j == 0)
                    D[0][0] = maze[0][0];
                else if(i == 0) {
                    D[i][j] = D[i][j-1] + maze[i][j];
                }
                else if(j == 0)
                    D[i][j] = D[i-1][j] + maze[i][j];
                else
                    D[i][j] = Math.max(D[i-1][j], Math.max(D[i][j-1], D[i-1][j-1])) + maze[i][j];
            }
            
        }

        System.out.println(D[N-1][M-1]);
    } 
}
