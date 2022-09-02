package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 곡의 개수
        int S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        int M = Integer.parseInt(st.nextToken());  // 최대볼륨
        int[] V = new int[N+1]; 
        int[] D = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            V[i] = Integer.parseInt(st.nextToken());

        if(S + V[1] > M && S - V[1] < 0) {
            System.out.println(-1);
            return ;
        }
        else if(S + V[1] > M){
            D[1] = S - V[1];
        }
        else  {
            D[1] = S + V[1];
        }   

        System.out.println("1 : " + D[1]);
        for(int i=2; i<=N; i++) {
            if(D[i-1] + V[i] > M && D[i-1] - V[i] < 0) {
                System.out.println(-1);
                return ;
            }
            else if(D[i-1] + V[i] > M ){
                D[i] = Math.max(D[i-1] - V[i], D[i-1]) ;
            }
            else  {
                D[i] = Math.max(D[i-1] + V[i], D[i-1]);
            }
            System.out.println(i + " : "  +D[i]);
        }

        System.out.println(D[N]);
    }
}
