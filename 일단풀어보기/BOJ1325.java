package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325 {
    static int N, M, depth = 0, max = 0;
    static int[] D;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //visited = new boolean[N+1];
        D = new int[N+1];
        for(int i =0; i<=N;i ++) 
            list.add(new ArrayList<>());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
        }

        // for(int i=1; i<=N; i++){
        //     System.out.print(i + " : ");
        //     for(int l: list.get(i))
        //         System.out.print(l + " / " );
        //     System.out.println();
        // }

        for(int i=1; i<=N; i++){
        //    System.out.print(i + " : " );

            visited = new boolean[N+1];
            dfs(i, i);
            visited[i] = true;
            //D[i] = depth;
          //  System.out.println();
            //Arrays.fill(visited, false);
        }

        // for(int i=1; i<=N; i++){
        //     if(D[i] == max) System.out.print(i + " ");
        // }

        for(int i=1; i<=N; i++){
            max = Math.max(max, D[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(max == D[i]){
                sb.append(i+" ");
            }
        }
        System.out.println(sb.toString());
    }

    static void dfs(int curr, int x) {

      //  System.out.print(x + " ,");
        // if(list.get(x).size() == 0) {
        //     max = Math.max(max, curr);
        //     depth = curr;
        //     //System.out.println("curr : " +curr);
        //     return ;
        // }
       // System.out.print(x + " ,");
        for(int l : list.get(x)) {
           // System.out.print(l + " ,");
            if(!visited[l]) {
                visited[l] = true;
                dfs(curr, l);
                D[curr]++;
                //visited[l] = false;
            }
        }
    }
}
