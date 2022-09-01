package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) 
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int h_sum =0, w_sum =0;
        for(int i=0; i<N; i++) {
            int h_max = 0,  h_max_x = 0, h_max_y = 0;
            for(int j=0; j<M; j++) {
                if(h_max < arr[i][j]){
                    h_max = arr[i][j];
                    h_max_x = i;
                    h_max_y = j;
                }
            }
            h_sum += h_max;

            //System.out.println("h_max " + h_max + " (" + h_max_x + " , " + h_max_y+ ") : " + h_sum + " / w_max " +  w_max + " (" + w_max_x + " , " + w_max_y+ ") : " + w_sum);
            for(int j=0; j<M; j++) {
                
              //  System.out.println((w_max == arr[j][i]) + " (" + j + " , " + i + ") (" + w_max_x + " , " + w_max_y + " )");
                if(h_max == arr[i][j] && (i != h_max_x || j != h_max_y) && ((j>0 && arr[i][j-1] != arr[i][j])))
                    h_sum++;

                if(j>0 && arr[i][j-1] < arr[i][j]){
                    //System.out.println((w_max == arr[j][i]) + " (" + j + " , " + i + ")");
                    w_sum +=  arr[i][j] - arr[i][j-1];
                }
            }
            
        }

        for(int i=0; i<M; i++) { //0,0 1,0 2,0 3,0 4,0 5,0
            int  w_max = 0, w_max_x = 0, w_max_y = 0;
            for(int j=0; j<N; j++) {
                if(w_max < arr[j][i]){
                    w_max = arr[j][i];
                    w_max_x = j;
                    w_max_y = i;
                }
            }
            w_sum += w_max;

            //System.out.println("h_max " + h_max + " (" + h_max_x + " , " + h_max_y+ ") : " + h_sum + " / w_max " +  w_max + " (" + w_max_x + " , " + w_max_y+ ") : " + w_sum);
            for(int j=0; j<N; j++) {
                if(j>1 && arr[j-2][i] > arr[j-1][i] && arr[j-1][i] < arr[j][i]){
                    //System.out.println((w_max == arr[j][i]) + " (" + j + " , " + i + ")");
                    w_sum +=  arr[j][i]- arr[j-1][i];
                }
            }
            
        }
        System.out.println((h_sum*2));
        System.out.println((w_sum*2));
        System.out.println((N*M)*2);
        System.out.println((h_sum*2) + (w_sum*2) + (N*M)*2);
    }
}
// 3 3
// 4 1 3
// 2 2 2
// 2 2 2

// 3 5
// 4 3 1 3 4
// 1 1 1 1 1
// 1 1 1 1 1