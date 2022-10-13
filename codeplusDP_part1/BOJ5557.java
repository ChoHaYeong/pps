package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5557 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) 
            a[i] = Integer.parseInt(st.nextToken());

        long[][] D = new long[n][21];
        D[1][a[1]] = 1;
        for(int i=2; i<n; i++) {
            for(int j=0; j<=20; j++) {
                if(j - a[i] >= 0 ) D[i][j] += D[i-1][j-a[i]] ; // i-1번째의 합보다 i번째의 합이 더 큰 경우
                if(j + a[i] <= 20) D[i][j] += D[i-1][j+a[i]] ; // i-1번째의 합보다 i번째의 합이 더 작은 경우 
            }
        }

        System.out.println(D[n-1][a[n]]);
    }
}
