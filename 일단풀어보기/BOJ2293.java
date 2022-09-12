package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[] D = new int[k+1];
       // D[1] =1;
        for(int i=1; i<=n; i++) {
          //  D[i] = 1;
            for(int j=1; j<=k; j++) {
                if(j-arr[i] == 0)
                    D[j] += 1;
                else if(j-arr[i] > 0) {

                    //System.out.print("D["+j+"] = D[" + j+ "] + D[" +(j-arr[i]) + "] ( " + D[j] + " = " + D[j] + " + " + D[j-arr[i]] + ")");
                    D[j] = D[j] + D[j-arr[i]];



                }

             //   System.out.print(D[j] + " ");
            }   
            //System.out.println();
        }
        System.out.println(D[k]);
    }
}
