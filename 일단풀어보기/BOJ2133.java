package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+1];

        D[1] = 0;
        D[2] = 3;

        for(int i=3; i<=n; i++) {
            D[i] = D[i-2] * 3;
        }
        System.out.println(D[n]);
    }
}
