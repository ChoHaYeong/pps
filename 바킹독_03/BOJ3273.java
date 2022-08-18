package 바킹독_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            num[i] = Integer.parseInt(st.nextToken()); 
        }

        int X = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1; i<=N; i++) {
            for(int j=i; j<=N; j++) {
                if( num[i] + num[j] == X)
                    count++;
            }
        }
        System.out.println(count);
    }
    
}
