package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int depth, cnt = 0 , N, S;
    static boolean[] visited;
    static int[] arr;
    static int[] n_arr;
    public static void main(String[] args) throws IOException {
        //1 ~ 주어진 수열 크기까지 선택하면서 해당 개수 골라졌을 떄, sum == S라면 ++하기
        //순서와 상관없이 무엇을 선택했는지가 중요함 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        n_arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)  
            arr[i] = Integer.parseInt(st.nextToken());

      //  for(int i=1; i<=N; i++) {
      ///      depth = i;

        dfs(0, 0);
       // }
        if(S == 0)
            System.out.println(cnt-1);
        else
            System.out.println(cnt);
    }

    static void dfs(int curr, int sum) {
        if(curr == N){
            if(sum == S){
                // for(int n: n_arr)
                //     System.out.print(n + " ");
                // System.out.println(depth + " 개 선택, 합은 " + sum );
                cnt++;
            }
            return ;
        }

        // for(int i=0; i<N; i++) {
        //     if(!visited[i] ) {
        //         visited[i] = true;
        //         n_arr[curr] = arr[i];
        //         dfs(curr+1, sum + arr[i]);
        //         visited[i] = false;
        //     }
        // }

        dfs(curr+1, sum + arr[curr]);
        dfs(curr+1, sum);
    }
}
