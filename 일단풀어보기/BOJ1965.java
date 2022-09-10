package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] D = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        D[1] = 1;
        int max = 0;
        for(int i=2; i<=n; i++) {
            D[i] = 1;
            for(int j=1; j<=i; j++) {
                if(arr[j] < arr[i] && D[i] < D[j]+1 )
                    D[i] = D[j]+1;
            }
            max = Math.max(D[i], max);
            //System.out.println(D[i]);
        }

        System.out.println(max);
    }
}
