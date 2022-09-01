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

        int start = 0;

        while(start < N) {
            for(int i=1; i<M; i++){
                if(M-(i+1) >= start){
                    n_arr[start][M-(i+1)] = arr[start][M-i];
                    System.out.println(start+","+ (M-(i+1)) + " = " +n_arr[start][M-(i+1)]);}
            }
            System.out.println();
            for(int i=1; i<N; i++){
                if(i >= start){
                    n_arr[i][start] = arr[i-1][start];
                    System.out.println(i+","+ start + " = " + n_arr[i][start]);}
            }
            System.out.println();
            for(int i=1; i<M; i++){
                if(i >= start){
                    n_arr[N-1][i] = arr[N-1][i-1];
                    System.out.println((N-1)+","+ i + " = " + n_arr[N-1][i]);}
            }
            System.out.println();
            for(int i=1; i<N; i++){
                if(N-(i+1) >= start){
                    n_arr[N-(i+1)][M-1] = arr[N-i][M-1];
                    System.out.println((N-(i+1))+","+ (M-1) + " = " + n_arr[N-(i+1)][M-1] );}
            }
            System.out.println();
            M--;
            N--;
            start++;
           // arr = n_arr;

            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++)
                    System.out.print(n_arr[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            System.out.println("M " + M + " , N : " + N);
        }
        

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }


    }
}
