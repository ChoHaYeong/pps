package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        long[] D = new long[n+1];
        Arrays.fill(D, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       // long min = Integer.MAX_VALUE ;
        D[1] = 0;
        for(int i=1; i<=n; i++) {
            // D[i] = Math.min(min, D[i]);
            // if(i+arr[i] <= n)  //내가 멀었다고 느낀 부분 1 ~ arr[i] 만큼 이동할 수 있는데 arr[i]만 이동함 
            if(D[i] == 0 && i != 1) continue;
            for(int j=1; j<=arr[i]; j++) {
                if(i+j <= n)
                    D[i+j] = Math.min(D[i+j], D[i] + 1);
            }
                
            
            //System.out.println(D[i]);
            //min = Math.min(min, D[i]);
        }
        if(D[n] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(D[n]);
    }
}
