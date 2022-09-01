package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9184 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][][] D = new long[51][51][51];

        for(int i=0; i<51; i++) {
            for(int j=0; j<51; j++) {
                for(int k=0; k<51; k++) {
                    if( i <= 0 || j <= 0 || k <= 0){
                        D[i][j][k] = 1;
                       // break;
                    }
                    else if( i>20 || j > 20 || k > 20){
                        D[i][j][k] = D[20][20][20];
                      //  break;
                    }
                    else if(i < j && j < k){ //w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
                        D[i][j][k] = D[i][j][k-1] + D[i][j-1][k-1] + D[i][j-1][k];
                     //   break;
                    }
                    else{
                        D[i][j][k] = D[i-1][j][k] + D[i-1][j-1][k] + D[i-1][j][k-1] + D[i-1][j-1][k-1];
                        
                        //D[1][1][1] = D[0][1][1] + D[0][0][1] + D[0][1][0] + D[0][0][0];
                      //  break;
                    }
                }
            }
        }

        System.out.println(D[2][2][2]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // "w(1, 1, 1) = 2"

        while(true) {
            if(a == -1 && b == -1 && c == -1) break;
            System.out.println("w(" + a+ ", "+b+", "+c+") = " +D[a][b][c]);
        }
    }
}
