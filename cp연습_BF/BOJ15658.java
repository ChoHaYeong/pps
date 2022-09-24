
package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15658 {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
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

        go(0, a[0], plus, minus, multi, div);
        System.out.println(max);
        System.out.println(min);
    }

    static void go(int index, int cnt, int plus, int minus, int multi, int div) { //연산자의 개수, 계산결과
        // for(char l : list) System.out.print(l + " ");
        // System.out.println();

        if(index == N-1) {
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            
            return ;
        }

        if(plus > 0)
            go(index+1, cnt + a[index+1], plus-1, minus, multi, div);
        if(minus > 0)
            go(index+1, cnt - a[index+1], plus, minus-1, multi, div);
        if(multi > 0)
            go(index+1, cnt * a[index+1], plus, minus, multi-1, div);
        if(div > 0)
            go(index+1, cnt / a[index+1], plus, minus, multi, div-1);
        
        



    }
}

