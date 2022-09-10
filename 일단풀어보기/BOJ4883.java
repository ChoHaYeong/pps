package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4883 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       // int N = -1;
       String line;
        int testCase = 0;
        while(( Integer.parseInt(line = br.readLine())) !=  0) {
            testCase++;
            int N = Integer.parseInt(line);
            int[][] arr = new int[N][3];
            int[][] D = new int[N][3];
            
            for(int i=0; i< N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<3; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            D[0][0] = arr[0][0];
            D[0][1] = arr[0][1];
            D[0][2] = arr[0][2];// + arr[0][2]; //Math.min(arr[0][1], arr[0][2]);

            D[1][0] = D[0][1] + arr[1][0];
            D[1][1] = Math.min(Math.min(D[0][1], D[1][0]), (D[0][1]+D[0][2])) + arr[1][1]; // [1][0], [0][1], ([0][1] + [0][2])
            D[1][2] = Math.min(Math.min(D[0][1], D[1][1]), (D[0][1]+D[0][2]))+ arr[1][2];

            for(int i=2; i<N; i++) {
                
                for(int j=0; j<3; j++) {
                    // if(i == 1) {
                    //     if(j == 0)
                    //         D[i][0] = D[i-1][1] + arr[i][j];
                    //     else
                    //         D[i][j] = Math.min(Math.min(D[i-1][j], D[i][j-1]), D[i-1][1] + D[i-1][2]) + arr[i][j];   
                    //     // if(j == 1)
                    //     //     D[i][1] = Math.min(D[i-1][1], D[i][0]) + arr[i][j];
                    //     // if(j == 2 )
                    //     //     D[i][2] = Math.min(D[i-1][1], D[i][1]) + arr[i][j];
                    // }
                    // else{

                    if(j == 0 )
                        D[i][0] = Math.min(D[i-1][0], D[i-1][1]) + arr[i][j];
                    if(j == 1)
                        D[i][1] = Math.min(Math.min(Math.min(D[i-1][0], D[i-1][1]), D[i-1][2]), D[i][0]) + arr[i][j];
                    if(j == 2 )
                        D[i][2] = Math.min(Math.min(D[i-1][1], D[i-1][2]), D[i][1]) + arr[i][j];
                   // }

                    //System.out.println(testCase + ". " + D[N-1][1]);
                }   
            }

            System.out.println(testCase + ". " + D[N-1][1]);
            //testCase++;
        }
    }   
}

