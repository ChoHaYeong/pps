package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16964 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] check ;
    static List<Integer> cList = new LinkedList<>();
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());
        check = new boolean[N+1];

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from =Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list.get(from).add(to);
            list.get(to).add(from);
        }

        int[] board = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            board[i] = Integer.parseInt(st.nextToken());
            cList.add(board[i]);
        }

        if(board[1] != 1){
            System.out.println(0);
            return ;
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(list.get(i), new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    return board[o1] - board[o2];
                }
                
            });
        }

        // 시작 정점은 1이기 때문에 가장 처음에 호출하는 함수는 dfs(1)이다. 
        for(int i=1; i<=N; i++)
            if(!check[i]) dfs(i);
        System.out.println(1);
    }

    static void dfs(int x) {
        if (check[x] == true) {
            return;
        }
        //System.out.println(x);
        if(x != cList.get(idx)) {
            System.out.println(0);
            System.exit(0);
        } else{ idx++; }
        check[x] = true;
        // x를 방문
        for (int y : list.get(x)) {
           // System.out.println(y);
            if (check[y] == false) {
                //check[y] = true;
                dfs(y);
                //check[y] = false;
            }
        }
        //check[x] = false;
    }
}
