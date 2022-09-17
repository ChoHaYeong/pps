package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[][] D = new boolean[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<N+1; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<N+1; i++) 
            D[i][i] = true; //길이가 1이면 true

        for(int i=1; i<N; i++) {
            if(arr[i] == arr[i+1])
                D[i][i+1] = true;            
        }


        int M = Integer.parseInt(br.readLine());

    }    
}
