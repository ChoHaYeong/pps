package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ15686 {
    static int N, M,total_dis = Integer.MAX_VALUE;
    static int[][] arr;
    static Position[] chicken, n_arr;
    static boolean[] visited;

    static private class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        chicken = new Position[14];
        visited = new boolean[14];
        n_arr = new Position[M];

        int idx = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    chicken[idx] = new Position(i, j);
                    idx++;
                }
            }
        }

        dfs(0, 0 );
        System.out.println(total_dis);
    }

    static void dfs(int curr, int start) {
        if(curr == M) {
            total_dis = Math.min(total_dis, getChickenDis());
            return ;
        }

        for(int i=start; i<chicken.length; i++) {
            if(!visited[i] && chicken[i] != null) {
                visited[i] = true;
                n_arr[curr] = chicken[i];
                dfs(curr+1, i);
                visited[i] = false;
            }
        }
    }

    static int getChickenDis() {
        int this_dis = 0;
        for(int i=0; i<N; i++) {
            
            for(int j=0; j<N; j++) {
                if(arr[i][j] == 1){ //집일 때

                    int dis = Integer.MAX_VALUE;
                    for(int k=0; k<M; k++) { //|r1-r2| + |c1-c2|
                        dis = Math.min(dis, (Math.abs(i - n_arr[k].x) + Math.abs(j - n_arr[k].y)));
                       // System.out.println("("+i+","+j+") and ("+n_arr[k].x+","+n_arr[k].y+") dist => " + dis);
                    }
                    //Syst
                    this_dis += dis;
                }
            }
        }
        //System.out.println("=================================================");
        return this_dis;

       // System.out.println(total_dis);
    }
}
