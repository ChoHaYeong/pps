package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] D = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        D[1] = 1;
        int max = 1;
        for(int i=2; i<=n; i++) {
            D[i] = 1;
            for(int j=1; j<i; j++) { // i = 2, j = 1  arr[2] = 30 < arr[1] = 10 가 false임 
                if(arr[j] > arr[i])
                    D[i] = Math.max(D[i], D[j]+1); 
            }
          //  System.out.println(D[i]);
            if(max < D[i])
                max = D[i];
        }

        System.out.println(max);


    }
    
}
