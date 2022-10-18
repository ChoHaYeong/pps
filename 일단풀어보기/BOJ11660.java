package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int[][] D= new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(j > 0 )
                    D[i][j] = D[i][j-1] + arr[i][j];
                // if(i==0 && j==0) D[i][j] = arr[i][j];
                // else if(i>0 && j == 0) D[i][j] = D[i-1][N-1] + arr[i][j];
                // else D[i][j] = D[i][j-1] + arr[i][j];
            }
        }

        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            System.out.println((D[x2][y2]-D[x1][y1]+arr[x1][y1]) + " //");
        }


    }
}
