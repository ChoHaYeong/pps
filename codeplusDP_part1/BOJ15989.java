package codeplusDP_part1;

import java.io.*;
import java.util.*;

public class BOJ15989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] D = new int[N+1];
            D[0] = 1;
           

            for(int j=1; j<=3; j++) {
                for(int i=1; i<=N; i++) {
                    if(i-j >= 0)
                        D[i] += D[i-j];
                }
            }

            System.out.println(D[N]);
        }
    }
}
