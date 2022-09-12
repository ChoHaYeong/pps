package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9084 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine()); //동전의 개수
            int[] coin = new int[N]; //동전 금액이 담긴 배열
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N ; j++)
                coin[j] = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(br.readLine()); //만들어야하는 금액
            int[] D = new int[M+1]; // D[M] = a 금액 M을 만드는 가짓 수 a

            for(int j=0; j<N; j++) {
                for(int k=1; k<=M; k++) {
                    if(k-coin[j] > 0 )
                        D[k] += D[k-coin[j]];
                    else if(k-coin[j] == 0) D[k] += 1;
                }
            }


            System.out.println(D[M]);
        }
    }   
}
