package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int H = N;
        int W = M;
        int[][] arr = new int[N][M];
        int[][] n_arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int rotate = Math.min(N, M) / 2;
        /*
         * 3. 돌릴 횟수만큼 반복
  3-1. 각 횟수마다 모든 라인 반복
    3-1-1. 각 라인의 첫번째 원소(0,0 / 1,1 / 2,2 ...)를 따로 저장해둔다.
    3-1-2. 한 라인의 위쪽, 오른쪽, 아래쪽, 왼쪽 순서로 반시계 방향으로 스와이프한다.
    3-1-3. 마지막 스와이프 위치에 따로 저장해둔 원소를 저장한다.
         */

        for(int l = 0; l< (R % (N * (M-1))); l++) {
            for(int i=0; i<rotate; i++) {

                int start = arr[i][i];
                for(int j=i; j<M-1-i; j++) //4-1-1 
                    n_arr[i][j] = arr[i][j+1]; //n_arr[1][0] = arr[1][1]
                
                for(int j=i; j<N-1-i; j++) //n_arr[0][4] = arr[1][4]
                    n_arr[j][M-1-i] = arr[j+1][M-1-i];
                
                for(int j=1+i; j<M-i; j++){
                  //  System.out.println( n_arr[N-1-i][j] + " = " + arr[N-1-i][j-1] + " (" + (N-1-i) + " , " + j + " )" + " // (" + (N-1-i) + " , " + (j-1) + " )");
                    n_arr[N-1-i][j] = arr[N-1-i][j-1];
                }
                
                for(int j=1+i; j<N-i; j++){
                   // System.out.println(n_arr[j][i]  + " = " + arr[j-1][i]);
                    n_arr[j][i] = arr[j-1][i];
                }
    
            }

            // arr = n_arr;

            for(int k=0; k<N; k++){
                for(int j=0; j<M; j++) {
                    arr[k][j] = n_arr[k][j];
                }
            }

           
        }

         for(int k=0; k<N; k++){
            for(int j=0; j<M; j++) {
                System.out.print(arr[k][j] + " ");
            }
            System.out.println();
        }

        

       


    }
}
