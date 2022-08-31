package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] D = new int[n+1];
        int[] rD = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        D[1] = 1;
        int max = 1;


        //i를 기준으로 오른쪽으로 감소하는 길이 구하기 
        for(int i=1; i<=n; i++) { //D[i] = i가 기준이 되었을 때, 가장 긴 바이토닉 수열의 길이 
            D[i] = 1; 
            //D[n-i] = 1;

            for(int j=1; j<i; j++){
              //  D[j] = 1;
                if(arr[j] < arr[i] && D[i] < D[j]+1){
                    D[i] = D[j] +1;
                }
            }

            //System.out.println(i + " -> " + D[i]);

        }

        for(int i=1; i<=n; i++) 
            if(max < D[i]+rD[i])
                max = D[i]+rD[i]-1;

        System.out.println(max);
    }
}
