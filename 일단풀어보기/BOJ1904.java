package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][2];

        for(int i=1; i<=n; i++) {
            if(i==1){
                D[1][1] = 1;
            }
            else if(i==2){
                D[2][0] = 1;
                D[2][1] = 1;
            }
            else if(i==3){
                D[3][0] = 1;
                D[3][1] = 2;
            }
            else {
                D[i][0] = (D[i-2][0] + D[i-2][1])%15746;
                D[i][1] = (D[i-1][0] + D[i-1][1])%15746;
            }
           // System.out.println(i + " " + D[i][0] + " , " + D[i][1]);
        }

        System.out.println((D[n][0]+D[n][1])%15746);
    }
}
