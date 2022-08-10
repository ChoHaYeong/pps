package codeplus_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int idx = 0;
        while(true) {
            int N = 28 * idx + S;
            if((N-E) % 15 == 0 && (N-M) % 19 == 0){
                System.out.println(N);
                break;
            }
            idx++;
        }
    }
    
}
