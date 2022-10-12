package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];

        for(int i=1; i<=N; i++) {
            if(i == 1){
                D[i] = 0;

                System.out.println("1인디 ..  " + D[i]);
            }
            else if(i == 2 || i== 3)
                D[i] = 1;
            else if(i%3 == 0 && i%2 ==0) {
                D[i] = Math.min(Math.min(D[i/3]+1, D[i/2]+1), D[i-1]+1);
            } else if(i%3 == 0) {
                D[i] = Math.min(D[i-1]+1, D[i/3]+1);
            } else if(i%2 == 0) {
                D[i] = Math.min(D[i-1]+1, D[i/2]+1);
            } else{
                D[i] =D[i-1]+1;
            }
            System.out.println(D[i]);
        }

        System.out.println(D[N]);

    }
    
}
