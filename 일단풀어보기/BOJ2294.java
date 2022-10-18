package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        int[] coin = new int[n+1];

        for(int i=1; i<=n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        int[] D = new int[k+1];
        Arrays.fill(D, 10001);

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                if(j%coin[i] == 0)
                    D[j] = j / coin[i];
               if(j-coin[i] > 0) {


                    //System.out.print("D["+j+"] = D[" + j+ "] + D[" +(j-arr[i]) + "] ( " + D[j] + " = " + D[j] + " + " + D[j-arr[i]] + ")");
                    D[j] = Math.min(D[j], D[j-coin[i]] + 1);



                }

               // System.out.print(D[j] + " ");
            }   

            if(D[k] == 100001){
                System.out.println(-1);
                return ;
            }
            min = Math.min(min, D[k]);
           // System.out.println();
        }
        System.out.println(min);
    }
}
