package codeplusDP_part1;

import java.io.*;
import java.util.*;

public class BOJ11060 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N+1];
        int[] D = new int[N+1];
        Arrays.fill(D, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        D[1] = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=a[i]; j++) {
                if(i + j <= N && D[i+j] == -1 ) { // i- j <= a[i]가 아니지 ㅠㅠ
                    if(D[i] != -1 || D[i+j] > D[i] + 1) {
                        D[i+j] = D[i] + 1;
                    }
                }
            }
        }

        System.out.println(D[N]);
    }
}
