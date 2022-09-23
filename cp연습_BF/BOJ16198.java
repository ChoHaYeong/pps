package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16198 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
       // int w[] = new int[N];
        List<Integer> w = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            //w[i] = Integer.parseInt(st.nextToken());
            w.add(Integer.parseInt(st.nextToken()));
            list.add(w.get(i));
        }

        go(w, 0);
        System.out.println(max);
    }
    static void go(List<Integer> w, int sum) {

        System.out.println("sum " + sum);
        int n = w.size();
        if(n == 2) {
            //System.out.println(sum);
            max = Math.max(max, sum);
            return ;
        }
       // if(curr != 0 && curr != n-2) {
            //list.remove(curr);
           // System.out.println(sum + " += " + w.get(curr-1) *w.get(curr+1) );
            

            // go(w, curr+1, sum);
            // int plus = w.get(curr-1) *w.get(curr+1);
            // w.remove(curr);
            // go(w, curr+1, sum + plus));
            // w.add(curr, list.get(curr));

      //  }

        for(int i=1; i<n-1; i++) {
            int mul = w.get(i-1) *w.get(i+1);
            ArrayList<Integer> b = new ArrayList<>(w);
            b.remove(i);
            System.out.println(sum + " + " + mul);
            go(b, sum + mul);
        }
    }
}
