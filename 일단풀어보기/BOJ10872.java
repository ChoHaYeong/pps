package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];
        D[0] = 1;
        for(int i=1; i<=N; i++)
            D[i] = D[i-1] * i;
        System.out.println(D[N]);
    }
}
