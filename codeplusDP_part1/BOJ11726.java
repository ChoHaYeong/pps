package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] D = new int[N+1];

        D[1] = 1;
        D[2] = 2;

        for(int i=3; i<=N; i++)
            D[i] = (D[i-1] + D[i-2]) % 10007;

        System.out.println(D[N]);
    }
}
