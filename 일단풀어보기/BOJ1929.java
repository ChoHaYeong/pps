package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1929 { //소수 구하기- 두개의 숫자가 주어졌을 때 두 수 사이의 소수 구하기
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime = new boolean[N+1];

        primeCheck(M, N);

        for(int i=M; i<=N; i++) {
            if(!isPrime[i])
                System.out.println(i);
        }
    }

    static void primeCheck(int M, int N) { //false면 소수, true면 소수 아님
        isPrime[0] = true;
        isPrime[1] = true;

        for(int i=2; i<=Math.sqrt(N); i++) { //N 이 아니라 Math.sqrt(N)인 이유는 ?
          //  if(!isPrime[i]) {
                for(int j = i*i; j <=N; j+=i) { //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
                    isPrime[j] = true;
                }
         //   }
        }

    }

    
}
