package 일단풀어보기;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            int[][] D = new int[2][n+1];

            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=1; k<=n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            //arr[0][j] j번째 스티커의 위쪽 숫자, arr[1][j] j번째 스티커의 아래쪽 숫자 
            for(int j= 1; j<=n; j++) {
                if(j == 1){
                    D[0][1] = arr[0][1];
                    D[1][1] = arr[1][1];
                    // System.out.println("D[0][0] : " + D[0][0]);
                    // System.out.println("D[1][0] : " + D[1][0]);
                }
                // else if(j == 1) {
                //     D[0][1] = D[1][0] + arr[0][1];
                //     D[1][1] = D[0][0] + arr[1][1];
                //     // System.out.println("D[0][1] : " + D[0][1] +  " = " + D[1][0] + " + " + arr[0][1]);
                //     // System.out.println("D[1][1] : " + + D[1][1] +  " = " +  D[0][0] + " + " +  arr[1][1]);
                // }
                else {
                    D[0][j] = Math.max(D[1][j-2] ,  D[1][j-1]) + arr[0][j];
                    D[1][j] = Math.max(D[0][j-2] , D[0][j-1]) + arr[1][j];
                    // System.out.println(j + " : " + D[0][j] + " =  " + Math.max(D[1][j-2] , D[0][j-2] + D[1][j-1]) + " + " + arr[0][j] + " / " + D[1][j-2] + "랑 " + D[0][j-2] +  " + "  + D[1][j-1] + " 중 고름");
                    // System.out.println(j + " : " + D[1][j] + " =  " + Math.max(D[0][j-2] , D[1][j-2] + D[0][j-1]) + " + " +  arr[1][j] + " / " + D[0][j-2] + "랑 " + D[1][j-2] + " + "  + D[0][j-1] + " 중 고름");
                }
            }

            System.out.println(Math.max(D[0][n], D[1][n]));

        }
    }
}
