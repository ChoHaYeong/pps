package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2660 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;
    static int N, min = Integer.MAX_VALUE;
    static List<Integer> candidate = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //회원 수
        visited = new boolean[N+1];

        for(int i=0; i<N+1; i++)
            list.add(new ArrayList<>());

        //int to, from;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        while(true ) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            if(to == -1 && from == -1) break;
            //i(to = Integer.parseInt(st.nextToken())) != -1 && (from = Integer.parseInt(st.nextToken())) != -1
            list.get(to).add(from);
            list.get(from).add(to);
        }

        for(int i=1; i<N+1; i++) {
            dfs(0, 0, i);

            for(int j=1; j<N+1; j++) visited[j] = false;
            //visited 방문여부 초기화하기
        }

        System.out.println(min);
    }

    static void dfs(int curr, int depth, int x) {
        //System.out.println("curr " + curr);
        if(curr == N-1) {
            System.out.println("min " + min + " , x " + x + " , depth " + depth);
            if(min > depth){
                min = depth;

                candidate = new LinkedList<>(); 
                candidate.add(x);
                //list초기화하고 새로 넣기
            }
            if(min == depth){
                candidate.add(x);
            }

            return ;
        }
        visited[x] = true;
        for(int l : list.get(x)) {
            if(!visited[l]) {
                visited[l] = true;
                dfs(curr+1, depth, l);

                //depth++;
                visited[l] = false;
            }  else depth++;
        }

    }
}
