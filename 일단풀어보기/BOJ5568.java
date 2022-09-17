package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ5568 {
    static int n, k;
    static int[] arr, n_arr;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        n_arr = new int[k];
        visited = new boolean[n];

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(set.size());
    }

    static void dfs(int curr) {
        if(curr == k) {
            String str = "";

            for(int n : n_arr)
                str += n;
           // System.out.println(str + " / " + Integer.parseInt(str) + " - " + set.size());
            set.add(str);

            return ;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                n_arr[curr] = arr[i];
                dfs(curr+1);
                visited[i] = false;
            }
        }
    }
}
