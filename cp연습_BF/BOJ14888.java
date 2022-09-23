package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int N, max = 0, min = Integer.MAX_VALUE;
    static int[] a;
    static char[] c, n_c;

    static boolean[] visited;
    static ArrayList<Character> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        c = new char[N];
        n_c = new char[N];

        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        //for(int i=0; i<4; i++) {
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multi = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());
        for(int j=0; j<plus; j++) {
            c[idx] = '+';
            idx++;
        }
        for(int j=0; j<minus; j++) {
            c[idx] = '-';
            idx++;
        }
        for(int j=0; j<multi; j++) {
            c[idx] = '*';
            idx++;
        }
        for(int j=0; j<div; j++) {
            c[idx] = '/';
            idx++;
        }
       // }
        // for(char cc :c)
        //     System.out.println(cc);
        dfs(0, 0);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int index, int cnt) {
        // for(char l : list) System.out.print(l + " ");
        // System.out.println();

        if(index == N-1) {
            //System.out.println("ㅠㅠ");
            int idx = 1;
            int sum = a[0];
            for(char l : list) {
                // if(l == '+') sum += a[idx];
                // if(l == '-') sum -= a[idx];
                // if(l == '*') sum *= a[idx];
                // if(l == '/') sum /= a[idx];
                // idx++;
                System.out.print(l + " ");
            }
            System.out.println();
            // max = Math.max(max, sum);
            // min = Math.min(min, sum);
            
            return ;
        }
        if(c.length == index) return ;
        //if(index == N) return ;
    //     //System.out.println(curr);
            list.add(c[cnt]);
            dfs(index+1, cnt+1);
        // System.out.println("??" + curr);
            list.remove(list.size()-1);

            for(char l : list) System.out.print(l + " ");
         System.out.println();
        // for(int i=0; i<N-1; i++) {
        //     if(!visited[i]) {
        //         visited[i] = true;
        //         n_c[curr] = c[i];
        //         dfs(curr+1);
        //         visited[i] = false;
        //     }
        // }


    }
}

