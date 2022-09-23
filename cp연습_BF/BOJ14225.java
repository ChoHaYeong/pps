package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14225 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] ok = new boolean[100000*N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(ok, arr, 0, 0);

        for(int i=1; i<ok.length; i++) {
            if(!ok[i]) {System.out.println(i); break;}
        }
    }

    static void dfs(boolean[] ok, int[] arr, int curr, int sum) {
        ok[sum] = true;
        if(curr == N) return ;
        dfs(ok, arr, curr+1, sum + arr[curr]);
        dfs(ok, arr, curr+1, sum);
    }
}
