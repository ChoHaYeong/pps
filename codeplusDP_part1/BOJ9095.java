package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] D = new int[N+1];
            D[0] = 1;
            D[1] = 1;
            D[2] = 2;

            for(int i=3; i<=N; i++) {
                for(int j=1; j<=3; j++) {
                    D[i] += D[i-j];
                }
            }

            System.out.println(D[N]);
        }
    }
}
