package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1707 { //그래프의 dfs는 각 정점마다 타고 들어가며 확인하는 듯..?
   // static Queue<Integer> queue = new LinkedList<>();

    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static int[] visited;
    static boolean[] n_visited;
    static boolean flag;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); //정점개수
            E = Integer.parseInt(st.nextToken()); //간선개수
            visited = new int[V+1];
            n_visited = new boolean[V+1];
            flag = true;
            list = new ArrayList<ArrayList<Integer>>();
            for(int j=0; j<=V; j++)
                list.add(new ArrayList<>());

            for(int j=0; j<E; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                list.get(from).add(to);
                list.get(to).add(from);
            }
            //System.out.println(V);
            for(int j=1; j<=V; j++) {
                if(visited[j] == 0) {

                    visited[j] = 1;
                    dfs(j);
                }
                
            }


            for(int j=1; j<=V; j++) {
                for(int l : list.get(j)) {
                    if(visited[l] == visited[j]){
                        flag = false;
                        // System.out.println("NO");
                        // return ;
                    }
                }
                // if(!n_visited[j]) {

                //     bfs(j);
                //     if(!flag){

                //         System.out.println("NO");
                //         //return ;
                //         break;
                //     }
                // }
                
            }            //dfs(1);
            //bfs(1);
            // for(int v : visited)
            //     System.out.print(v + " ");
        //    // dfs(1);
           if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }


    /*
     * 주어진 그래프가 이분 그래프인지 확인하는 것은 어렵지 않다. 
     * 그래프의 꼭짓점들을 깊이 우선 탐색으로 나열한 뒤, ==> 깊이 우선 탐색의 base case 는 무엇일까 ?
     * 각 꼭짓점들을 이웃 꼭짓점들과 다른 색으로 계속해서 칠해 나가면서, 
     * 같은 색깔의 꼭짓점이 서로 연결되어 있는 모순이 발생하는지 여부를 확인하면 된다. 
     * 이 알고리즘은 O(|V|+|E|)이다.
1
5 4
1 2
3 4
3 5
4 5


     */

     static void dfs(int x) {
      //  if(list.get(x).size() == 0) return ;
        //visited[x] = c;
        for(int l: list.get(x)) {
           // System.out.println("l    " + l + "  x   " + x);
            if(visited[l] == 0){
                visited[l] = 0 - visited[x];
                dfs(l);
            } 
        }
       // return ;
     }
    static void bfs(int x) {
       // boolean[] n_visited = new boolean[V+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        n_visited[x] = true;
        while(!queue.isEmpty()) {
            int out = queue.poll();

            for(int l : list.get(out)) { //l.bg랑 
                if(!n_visited[l]) {
                    queue.add(l);
                    n_visited[l] = true;
                }
                if(visited[out] == visited[l]) {
                    flag = false;
                    
                  // System.out.println("NO");
                    return ;
                }
            }
        }
    }
}
