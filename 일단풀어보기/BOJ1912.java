package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] D = new int[n+1]; // D[n] = n번째 숫자까지 연속해서 선택했을 때 가장 큰 합 
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        D[1] = arr[1];
        int max = D[1];

        for(int i=2; i<=n; i++) {
            D[i] = Math.max(D[i-1] + arr[i], arr[i]);
            if(max < D[i])
                max = D[i];
        }

        System.out.println(max);
    }
}
