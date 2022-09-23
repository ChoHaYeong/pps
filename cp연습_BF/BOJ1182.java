package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int N, S, cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(cnt-1);   
    }
    static void dfs(int curr, int sum) {
        if(sum == S && curr == N) {
            cnt++;
            return ;
        }
        if(sum != S && curr == N) return ;
        dfs(curr+1, sum + arr[curr]);
        dfs(curr+1, sum);
    }
}
