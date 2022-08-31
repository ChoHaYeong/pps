package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][2];
        int[] S = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n ; i++)
            S[i] = Integer.parseInt(st.nextToken());

        //. 단, 수는 한 개 이상 선택해야 한다. --> 이 전제조건이 있기 때문에 D[1][0] = Math.max(0, S[1])이 될 수 없음 
        D[1][0] = S[1]; // i번째 수가 연속합의 마지막 숫자이면서 지금까지 숫자를 제거한적이 있는(제거 안할수도 있음) 연속합 중 최댓값
        D[1][1] = S[1];
        long max = S[1];
        for(int i=2; i<=n; i++) {
            D[i][0] = Math.max(D[i-1][1], D[i-1][0] + S[i]);
            D[i][1] = Math.max(D[i-1][1] + S[i], S[i]);

            max = Math.max(max, Math.max(D[i][0], D[i][1]));

            //System.out.println(i + " : " + D[i][0] + " " + D[i][1]);
        }

        System.out.println(max);
    }
}
